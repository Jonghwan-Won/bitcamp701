import { CameraAltOutlined } from "@material-ui/icons";
import axios from "axios";
import React, { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

function FoodForm(props) {
  const [foodPhoto, setFoodPhoto] = useState([]); //배열타입
  const [fname, setFname] = useState("");
  const [fhp, setFhp] = useState("");
  // const [fcontent, setFcontent] = useState("");  //이슈가있어서 ref로 따로 줌
  const [bookingday, setBookingday] = useState("");

  const navi = useNavigate();

  //content는 Ref로(입력할때마다 다시 랜더링되는거 방지차원에서...)
  const contentRef = useRef("");

  const url = localStorage.url;

  //파일 업로드 이벤트
  const onUploadChange = (e) => {
    let uploadUrl = url + "/food/upload";
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

      setFoodPhoto(res.data); // res.data에 배열에 업로드된 사진이름이 배열 형태로 리턴
    });
  };

  const onSubmit = (e) => {
    //액션이 호출되는게 submit
    e.preventDefault(); //submit의 기본 이벤트 무효화시킴

    //하고싶은 말
    let fcontent = contentRef.current.value;

    let insertUrl = url + "/food/insert";

    axios.post(insertUrl, { fname, fhp, fcontent, bookingday }).then((res) => {
      navi("/food/list");
      setFname("");
      setFhp("");
      setBookingday("");
      contentRef.current.value = "";
    });
  };

  let imageUrl = url + "/image/";

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
        {foodPhoto.map((fname, idx) => (
          <img
            alt=""
            key={idx}
            className="foodphoto"
            src={`${imageUrl}${fname}`}
          />
        ))}
      </div>

      <h4>나머지 정보도 입력해주세요</h4>
      <form onSubmit={onSubmit}>
        <table className="table table-bordered" style={{ width: "400px" }}>
          <tbody>
            <tr>
              <th style={{ width: "120px" }}>예약자 이름</th>
              <td>
                <input
                  type={"text"}
                  className="form-control"
                  required
                  onChange={(e) => setFname(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "120px" }}>예약자 핸드폰</th>
              <td>
                <input
                  type={"text"}
                  className="form-control"
                  required
                  onChange={(e) => setFhp(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "120px" }}>하고싶은 말</th>
              <td>
                <textarea
                  ref={contentRef}
                  style={{ width: "280px", height: "100px" }}
                  className="form-control"
                ></textarea>
              </td>
            </tr>
            <tr>
              <th style={{ width: "120px" }}>예약 날짜</th>
              <td>
                <input
                  type={"date"}
                  className="form-control"
                  required
                  onChange={(e) => setBookingday(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td colSpan={2} align="center">
                <button type="submit" className="btn btn-outline-danger">
                  주문사항저장
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
}

export default FoodForm;
