import { Alert } from "@material-ui/lab";
import React, { useRef, useState } from "react";

function ThreeApp(props) {
  const [msg, setMsg] = useState("");
  const nameRef = useRef("");
  const korRef = useRef(0);
  const engRef = useRef(0);

  //버튼 이벤트
  const resultButtonEvent = () => {
    //입력값
    let name = nameRef.current.value;
    let kor = korRef.current.value;
    let eng = engRef.current.value;

    if (isNaN(kor)) {
      //숫자가 아니면 True
      alert("국어점수를 숫자형태로 입력해주세요");
      return;
    }

    if (isNaN(eng)) {
      //숫자가 아니면 True
      alert("영어점수를 숫자형태로 입력해주세요");
      return;
    }

    //총점, 평균 구하기
    let tot = Number(kor) + Number(eng);
    let avg = tot / 2;

    //출력 문자열
    let s = `
    [결과 확인]
    이름 : ${name}
    국어 점수 : ${kor}
    영어 점수 : ${eng}
    총점 : ${tot}
    평균 : ${avg}`;

    setMsg(s); //랜더링

    //이름에 포커스 보내기
    nameRef.current.value = "";
    korRef.current.value = "";
    engRef.current.value = "";
    nameRef.current.focus();
  };

  return (
    <div>
      <Alert severity="info">
        <b style={{ fontSize: "20px" }}>ThreeApp</b>
      </Alert>

      <table className="table table-bordered" style={{ width: "400px" }}>
        <tbody>
          <tr>
            <th style={{ width: "100px" }}>이름</th>
            <td>
              <input type={"text"} ref={nameRef} className="form-control" />
            </td>
          </tr>

          <tr>
            <th style={{ width: "100px" }}>국어 점수</th>
            <td>
              <input type={"text"} ref={korRef} className="form-control" />
            </td>
          </tr>

          <tr>
            <th style={{ width: "100px" }}>영어 점수</th>
            <td>
              <input type={"text"} ref={engRef} className="form-control" />
            </td>
          </tr>

          <tr>
            <td colSpan={2} align="center">
              <button
                type="button"
                className="btn btn-outline-danger"
                onClick={resultButtonEvent}
              >
                결과 확인
              </button>
            </td>
          </tr>
          <tr style={{ height: "100px", backgroundColor: "orange" }}>
            <td colSpan={2} style={{ whiteSpace: "pre-line" }}>
              {/* 
              이 름 : {nameRef.current.value}
              <br />
              국어 점수 : {korRef.current.value}
              <br />
              영어 점수 : {engRef.current.value}
              <br />
            */}
              <h4>{msg}</h4>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default ThreeApp;
