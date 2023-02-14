import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function MemberForm(props) {
  const [myname, setMyname] = useState("");
  const [myid, setMyid] = useState("");
  const [mypass, setMypass] = useState("");

  const [btnok, setBtnok] = useState(false); //중복체크 버튼 클릭여부 판단
  const [idmsg, setIdmsg] = useState(""); //ID적합여부 메세지

  const navi = useNavigate();

  //아이디 중복체크 버튼
  const btnIdCheck = () => {
    // let url = sessionStorage.url + "/login/idcheck?myid=" + myid;
    let url = localStorage.url + "/login/idcheck?myid=" + myid;

    axios.get(url).then((res) => {
      if (res.data === 0) {
        setIdmsg("가입가능");
        setBtnok(true);
      } else {
        setIdmsg("가입불가");
        setBtnok(false);
      }
    });
  };

  //아이디 입력 시 호출되는 이벤트
  const inputIdChange = (e) => {
    setMyid(e.target.value);
    setBtnok(false); //중복체크 후 아이디를 다시 입력할 경우때문에 추가함
    setIdmsg(""); //아이디에 대한 메세지도 지우기
  };

  const onSubmitButton = (e) => {
    e.preventDefault(); //기본 이벤트 무효화

    //아이디 중복체크 버튼 클릭 여부
    if (!btnok) {
      alert("아이디 중복체크 버튼을 눌러주세요");
      return;
    }

    let url = localStorage.url + "/member/insert";
    axios.post(url, { myname, myid, mypass }).then((res) => {
      alert("회원가입 성공");
      setMyid("");
      setMyname("");
      setMypass("");
      setBtnok(false);

      //로그인폼으로 이동
      navi("/login");
    });
  };

  return (
    <div style={{ margin: "50px 50px" }}>
      <form onSubmit={onSubmitButton}>
        <table className="table table-bordered" style={{ width: "500px" }}>
          <caption align="top">
            <h2>회원가입</h2>
          </caption>
          <tbody>
            <tr>
              <th style={{ width: "130px", backgroundColor: "#ddd" }}>이름</th>
              <td>
                <input
                  type={"text"}
                  className="form-control"
                  required
                  value={myname}
                  onChange={(e) => setMyname(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <th style={{ width: "130px", backgroundColor: "#ddd" }}>
                아이디
              </th>
              <td>
                <div className="input-group">
                  <input
                    type={"text"}
                    className="form-control"
                    required
                    value={myid}
                    onChange={inputIdChange}
                  />
                  <button
                    type="button"
                    className="btn btn-secondary"
                    onClick={btnIdCheck}
                  >
                    아이디 중복
                  </button>
                  <b style={{ width: "100px" }}>{idmsg}</b>
                </div>
              </td>
            </tr>

            <tr>
              <th style={{ width: "130px", backgroundColor: "#ddd" }}>
                비밀번호
              </th>
              <td>
                <div className="input-group">
                  <input
                    type={"password"}
                    className="form-control"
                    required
                    value={mypass}
                    onChange={(e) => setMypass(e.target.value)}
                  />
                </div>
              </td>
            </tr>
            <tr>
              <td colSpan={2} align="center">
                <button type="submit" className="btn btn-dark">
                  회원가입
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
}

export default MemberForm;
