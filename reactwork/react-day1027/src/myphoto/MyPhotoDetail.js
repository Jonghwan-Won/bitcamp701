import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function MyPhotoDetail(props) {
  const [data, setData] = useState("");

  const { num } = useParams();
  const url = localStorage.url;
  // const COOMON_URL = process.env.REACT_APP_BACK_URL;

  console.log("url=" + localStorage.url);

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

  //navi 사용을 위한 변수 선언
  const navi = useNavigate();

  return (
    <div style={{ margin: "50px 50px" }}>
      <img
        alt=""
        src={`${url}/image/${data.photo}`}
        style={{ maxWidth: "300px" }}
      />
      <br />
      <h2>제 목 : {data.title}</h2>
      <br />
      <button
        type="button"
        className="btn btn-secondary btn-sm"
        onClick={() => navi("/photo/list/1")}
      >
        목록 #1
      </button>
      &nbsp;&nbsp;
      <button
        type="button"
        className="btn btn-secondary btn-sm"
        onClick={() => navi("/photo/list/2")}
      >
        목록 #2
      </button>
      &nbsp;&nbsp;
      <button
        type="button"
        className="btn btn-dark btn-sm"
        onClick={() => navi(`/photo/updateform/${num}`)}
      >
        수정하기
      </button>
    </div>
  );
}

export default MyPhotoDetail;
