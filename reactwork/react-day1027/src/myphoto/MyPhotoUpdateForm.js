import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function MyPhotoUpdateForm(props) {
  const [data, setData] = useState("");

  //navi 사용을 위한 변수 선언
  const navi = useNavigate();

  const url = localStorage.url;
  // const COOMON_URL = process.env.REACT_APP_BACK_URL;

  let uploadUrl = url + "/myphoto/upload"; //upload 경로
  let imageUrl = url + "/image/"; //환경변수로 등록해두면 나중에 경로바뀌더라도 한번에 바꿀 수 있음

  const { num } = useParams();

  //num에 해당하는 dto가져오기
  const onSelectData = () => {
    let selectUrl = url + "/myphoto/select?num=" + num;

    axios.get(selectUrl).then((res) => {
      //res.data에는 스프링에서 반환한 dto가 들어있다
      setData(res.data);
    });
  };

  //처음 시작 시 스프링으로부터 dto를 얻어야하므로 useEffect 에서 호출
  useEffect(() => {
    onSelectData();
    console.log("호출");
  }, []);

  ////////////////////////////////////////////////////////////////////////////////////////////////////

  //파일첨부 이벤트
  const photoUploadEvent = (e) => {
    const uploadFile = e.target.files[0];
    const imageFile = new FormData();
    imageFile.append("uploadFile", uploadFile); //백엔드 컨트롤러에서 MultipartUpload uploadFile 과 일치해야함

    axios({
      method: "post",
      url: uploadUrl,
      data: imageFile,
      headers: { "Content-Type": "multipart/form-data" },
    }).then((res) => {
      //파라미터를 res가 받고(response 를 뜻함) String으로 보냈음(Public String)

      //스프링에서 map이 아닌 String으로 업로드한 파일명을 리턴했으므로 res가 곧 파일명임
      //   setPhoto(res.data);
      setData({
        ...data,
        num,
        photo: res.data,
      });
    });
  };

  //수정 이벤트
  const updateButtonEvent = () => {
    let updateUrl = url + "/myphoto/update";

    axios //위 url로 보냄
      .post(updateUrl, data)

      .then((res) => {
        navi(`/photo/detail/${num}`);
      });
  };

  return (
    <div style={{ margin: "50px 50px" }}>
      <img
        alt=""
        src={`${imageUrl}/${data.photo}`}
        style={{ maxWidth: "300px" }}
      />
      <br />
      <h5>수정할 사진을 업로드하세요</h5>
      <input
        type="file"
        className="form-control"
        style={{ width: "400px" }}
        onChange={photoUploadEvent} //업로드 이벤트 연결
      />

      <input
        type={"text"}
        className="form-control"
        style={{ width: "400px", marginTop: "10px" }}
        placeholder="사진에 대한 메세지 입력"
        value={data.title}
        onChange={(e) => {
          //이벤트를 받아서
          setData({
            ...data,
            title: e.target.value,
          });
        }}
      />
      <br />
      <button
        type="button"
        className="btn btn-success"
        onClick={updateButtonEvent}
      >
        저장
      </button>
    </div>
  );
}

export default MyPhotoUpdateForm;
