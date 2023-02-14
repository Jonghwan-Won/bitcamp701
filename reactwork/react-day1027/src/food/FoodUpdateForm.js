import { CameraAltOutlined, CloseOutlined } from "@material-ui/icons";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function FoodUpdateForm(props) {
  const [fooddata, setFoodData] = useState("");
  const [photo, setPhoto] = useState([]); //기존 사진
  const [newphoto, setNewPhoto] = useState([]); //새로운 사진

  const navi = useNavigate();
  const { num } = useParams();
  console.log(num);

  const url = localStorage.url + "/food/detail?num=" + num;
  const photoUrl = localStorage.url + "/image/";

  const selectFoodData = () => {
    axios.get(url).then((res) => {
      setFoodData(res.data);
      if (res.data.fphoto !== "no") {
        setPhoto(res.data.fphoto.split(","));
      } else {
        setPhoto([]);
      }
    });
  };

  useEffect(() => {
    selectFoodData();
  }, []);

  //파일 업로드 이벤트
  const onUploadChange = (e) => {
    let uploadUrl = localStorage.url + "/food/upload2";

    //여러개의 파일 업로드시
    console.log(e.target.files.length + "개");
    const uploadFile = new FormData();
    for (let i = 0; i < e.target.files.length; i++) {
      uploadFile.append("uploadFile", e.target.files[i]);
    }

    axios({
      method: "post",
      url: uploadUrl,
      data: uploadFile,
      headers: { "Content-Type": "multipart/form-data" },
    }).then((res) => {
      console.log(res.data.length + "개 들어옴");

      setNewPhoto(res.data); // res.data를 새로운 사진(newPhoto)에 넣는다
    });
  };

  //수정 버튼 클릭시 호출
  const onSubmit = (e) => {
    //액션이 호출되는게 submit
    e.preventDefault(); //submit의 기본 이벤트 무효화시킴

    let updateUrl = localStorage.url + "/food/update";

    axios.post(updateUrl, fooddata).then((res) => {
      navi(`/food/detail/${num}`); //수정이 끝나면 detail로
    });
  };

  return (
    <div style={{ margin: "50px 50px" }}>
      <input
        type={"file"}
        id="filephoto"
        multiple
        style={{ visibility: "hidden" }}
        onChange={onUploadChange}
      />

      <h4>여러장의 사진을 등록해주세요</h4>
      <span
        onClick={() => {
          document.getElementById("filephoto").click();
        }}
      >
        <CameraAltOutlined style={{ fontSize: "2em", cursor: "pointer" }} />
      </span>
      <br />
      <br />
      <div>
        <h6>기존 추가되어있는 사진들입니다</h6>
        {fooddata.fphoto === "no" ? (
          <h5>사진없음</h5>
        ) : (
          photo &&
          photo.map((fname, idx) => (
            <figure style={{ float: "left" }}>
              <img
                alt=""
                key={idx}
                className="foodphoto"
                src={`${photoUrl}${fname}`}
              />
              <figcaption>
                <CloseOutlined
                  style={{ cursor: "pointer" }}
                  onClick={() => {
                    // backend 의 사진에서 삭제 (백엔드와의 통신이니까 axios)
                    const purl = localStorage.url + "/food/delphoto?idx=" + idx;
                    axios.get(purl).then((res) => {
                      //purl 로 데이터만 보내기
                      //DB에서 삭제되진않음
                    });

                    // front 의 photo 배열에서 삭제
                    setPhoto(photo.filter((a, i) => i !== idx));
                  }}
                />
              </figcaption>
            </figure>
          ))
        )}
      </div>
      {/* float:left 속성 해제 */}
      <div style={{ clear: "both" }}>
        <h6>새로 추가된 사진들입니다</h6>
        {newphoto &&
          newphoto.map((photo, idx) => (
            <img
              alt=""
              key={idx}
              src={`${photoUrl}${photo}`}
              className="foodphoto"
            />
          ))}
      </div>

      <h4>정보를 수정해주세요</h4>
      <form onSubmit={onSubmit}>
        <table className="table table-bordered" style={{ width: "400px" }}>
          <tbody>
            <tr>
              <th style={{ width: "120px" }}>예약자 이름</th>
              <td>
                <input
                  type={"text"}
                  className="form-control"
                  value={fooddata.fname}
                  onChange={(e) => {
                    setFoodData({
                      ...fooddata,
                      fname: e.target.value,
                    });
                  }}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "120px" }}>예약자 핸드폰</th>
              <td>
                <input
                  type={"text"}
                  className="form-control"
                  value={fooddata.fhp}
                  onChange={(e) => {
                    setFoodData({
                      ...fooddata,
                      fhp: e.target.value,
                    });
                  }}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "120px" }}>하고싶은 말</th>
              <td>
                <textarea
                  style={{ width: "280px", height: "100px" }}
                  className="form-control"
                  value={fooddata.fcontent}
                  onChange={(e) => {
                    setFoodData({
                      ...fooddata,
                      fcontent: e.target.value,
                    });
                  }}
                ></textarea>
              </td>
            </tr>
            <tr>
              <th style={{ width: "120px" }}>예약 날짜</th>
              <td>
                <input
                  type={"date"}
                  className="form-control"
                  value={fooddata.bookingday}
                  onChange={(e) => {
                    setFoodData({
                      ...fooddata,
                      bookingday: e.target.value,
                    });
                  }}
                />
              </td>
            </tr>

            <tr>
              <td colSpan={2} align="center">
                <button type="submit" className="btn btn-outline-danger">
                  수정하기
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
}

export default FoodUpdateForm;
