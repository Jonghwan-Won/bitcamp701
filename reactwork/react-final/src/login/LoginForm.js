import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function LoginForm(props) {
  const [myid, setMyid] = useState("");
  const [mypass, setMypass] = useState("");
  const navi = useNavigate();

  //submit 이벤트
  const onSubmitLogin = (e) => {
    e.preventDefault();

    let url = localStorage.url + "/login/check";
    // let url = sessionStorage.url + "/login/check";

    axios.post(url, { myid, mypass }).then((res) => {
      console.log(res.data.check);
      console.log(res.data.myname);

      if (res.data.check === 1) {
        //각종 정보를 Storage에 저장
        // localStorage.loginok = "yes";
        // localStorage.myid = myid;
        // localStorage.myname = res.data.myname;

        sessionStorage.loginok = "yes";
        sessionStorage.myid = myid;
        sessionStorage.myname = res.data.myname;

        //일단 Home으로 이동
        navi("/");
        window.location.reload(); //새로고침
      } else {
        alert("아이디 또는 비밀번호가 맞지 않습니다");
        setMyid("");
        setMypass("");
      }
    });
  };

  return (
    <div className="login">
      <form onSubmit={onSubmitLogin}>
        <table className="table table-bordered">
          <tbody>
            <tr>
              <th style={{ width: "100px", backgroundColor: "#ddd" }}>
                아이디
              </th>
              <td>
                <input
                  type="text"
                  className="form-control"
                  placeholder="아이디"
                  required
                  autoFocus
                  value={myid}
                  onChange={(e) => setMyid(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "100px", backgroundColor: "#ddd" }}>
                비밀번호
              </th>
              <td>
                <input
                  type="password"
                  className="form-control"
                  required
                  placeholder="비밀번호"
                  value={mypass}
                  onChange={(e) => setMypass(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td colSpan={2} className="table table-bordered" align="center">
                <button
                  type="submit"
                  className="btn btn-dark"
                  style={{ width: "150px" }}
                >
                  회원로그인
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
}

export default LoginForm;
