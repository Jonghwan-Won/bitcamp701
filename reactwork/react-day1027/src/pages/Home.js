import React from "react";
import { useNavigate } from "react-router-dom";
import imgHome from "../image/2.jpg"; //수동 import

function Home(props) {
  const navi = useNavigate();

  return (
    <div style={{ margin: "50px 50px" }}>
      <h2>홈페이지 방문을 환영합니다</h2>
      <img alt="" src={imgHome} width="200" />
      <h4>useNavigate 를 이용한 페이지 이동</h4>
      <button
        type="button"
        className="btn btn-outline-dark"
        onClick={() => navi("/photo/list/1")}
      >
        포토게시판 #1
      </button>
      <br />
      <br />
      <button
        type="button"
        className="btn btn-outline-dark"
        onClick={() => navi("/photo/list/2")}
      >
        포토게시판 #2
      </button>
      <br />
      <br />
      <button
        type="button"
        className="btn btn-outline-dark"
        onClick={() => navi("/food")}
      >
        Food게시판
      </button>
      <br />
      <br />
      <button
        type="button"
        className="btn btn-outline-dark"
        onClick={() => navi("/about/Kakao")}
      >
        About 이동
      </button>
      <br />
      <br />
      <button
        type="button"
        className="btn btn-outline-dark"
        onClick={() => navi(-1)}
      >
        이전 페이지
      </button>
    </div>
  );
}

export default Home;
