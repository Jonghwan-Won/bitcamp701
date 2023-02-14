import { Alert } from "@material-ui/lab";
import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function MyPhotoWriteForm(props) {
  const [photo, setPhoto] = useState("");
  const [title, setTitle] = useState("");
  const navi = useNavigate();

  // .env의 환경변수를 사용하려면 앞에 process.env. 붙여준다
  const COOMON_URL = process.env.REACT_APP_BACK_URL;

  let uploadUrl = COOMON_URL + "/myphoto/upload"; //upload 경로
  let imageUrl = COOMON_URL + "/image/"; //환경변수로 등록해두면 나중에 경로바뀌더라도 한번에 바꿀 수 있음

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
      setPhoto(res.data);
    });
  };

  //저장 함수
  const onSave = ({ title, photo }) => {
    //사진은 이미 보냈으므로 title만 받기로 했는데....중간에 변경함 (컨트롤러에서 photo관련 처리하거나 프론트에서..)

    let insertUrl = COOMON_URL + "/myphoto/insert";

    axios //위 url로 보냄
      .post(insertUrl, { title, photo })
      //key값도 title, value 값도 title 이라서 한번만 써도됨
      //같지않을떄는
      //axios.post(insertUrl, "message":{ title }); 이런 식으로 함

      .then((res) => {
        // List(); //목록 다시 출력
        navi(-1); //이전 페이지로 이동 (num이 있으면 `/image ... ${num}`)
      })

      .catch((error) => {
        console.log("데이터 추가 에러 : " + error);
      });
  };

  //저장 이벤트
  const insertButtonEvent = () => {
    onSave({ title, photo }); //부모 컴포넌트의 onSave 함수 호출

    //값 비우기
    setPhoto("");
    setTitle("");
  };

  return (
    <div>
      <Alert severity="info">
        <b style={{ fontSize: "25px" }}>
          axios 라이브러리 공부하기 - 사진 업로드폼
        </b>
      </Alert>

      <h5>사진을 업로드하세요</h5>

      <div className="input-group" style={{ width: "800px" }}>
        <input
          type={"file"}
          className="form-control"
          onChange={photoUploadEvent} //업로드 이벤트 연결
          style={{ width: "300px" }}
        />

        <input
          type={"text"}
          className="form-control"
          style={{ width: "300px" }}
          placeholder="사진에 대한 메세지 입력"
          value={title}
          onChange={(e) => {
            //이벤트를 받아서
            setTitle(e.target.value);
          }}
        />
        <button
          type="button"
          className="btn btn-outline-dark"
          onClick={insertButtonEvent}
        >
          DB저장
        </button>
      </div>

      {/* 사진출력 */}
      <br />
      <img alt="" src={imageUrl + photo} style={{ maxWidth: "300px" }} />
    </div>
  );
}

export default MyPhotoWriteForm;
