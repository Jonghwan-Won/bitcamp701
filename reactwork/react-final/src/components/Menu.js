import React, { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";

function Menu(props) {
  const [myname, setMyname] = useState("");

  useEffect(() => {
    // setMyname(localStorage.myname);
    setMyname(sessionStorage.myname);
  }, []);

  /*
    localStorage는 브라우저를 닫아도 계속 남아있음
    sessionStorage는 브라우저를 닫으면 자동으로 지워짐
  */

  return (
    <ul className="menu">
      <li>
        <NavLink to={"/"}>Home</NavLink>
      </li>
      <li>
        <NavLink to={"/member/form"}>회원가입</NavLink>
      </li>
      <li>
        <NavLink to={"/member/list"}>회원목록</NavLink>
      </li>
      <li>
        <NavLink to={"/board/list"}>게시판</NavLink>
      </li>

      <li>
        <NavLink to={"/reducer1"}>리듀서에제1</NavLink>
      </li>

      <li>
        <NavLink to={"/reducer2"}>리듀서예제2</NavLink>
      </li>

      <li>
        <NavLink to={"/qstring?color=red&name=lee&addr=seoul"}>
          쿼리스트링
        </NavLink>
      </li>

      {sessionStorage.loginok == null ? (
        // {localStorage.loginok == null ? (
        <li>
          <NavLink to={"/login"}>로그인</NavLink>
        </li>
      ) : (
        <div>
          &nbsp;&nbsp;&nbsp;
          <b>{myname}님</b>&nbsp;&nbsp;
          <button
            type="button"
            className="btn btn-danger"
            onClick={() => {
              //   localStorage.removeItem("loginok");
              //   localStorage.removeItem("myid");
              //   localStorage.removeItem("myname");

              sessionStorage.removeItem("loginok");
              sessionStorage.removeItem("myid");
              sessionStorage.removeItem("myname");

              window.location.reload(); //새로고침
            }}
          >
            로그아웃
          </button>
        </div>
      )}
    </ul>
  );
}

export default Menu;
