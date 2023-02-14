import React, { useState } from "react";

function SevenApp(props) {
  const [name, setName] = useState("");
  const [score, setScore] = useState(0);
  const [grade, setGrade] = useState("");
  const [tcolor, setTcolor] = useState("gray");

  //이벤트
  const changeName = (e) => {
    setName(e.target.value);
  };

  const changeScore = (e) => {
    setScore(e.target.value);
  };

  const enterEvent = (e) => {
    if (e.key === "Enter") {
      //   alert("Enter");
      if (score >= 90) {
        setGrade("우수학생");
      } else if (score >= 80) {
        setGrade("장학생");
      } else if (score >= 70) {
        setGrade("겨우 통과");
      } else {
        setGrade("재시험");
      }
    }
  };

  //radio 이벤트
  const radioCheck = (e) => {
    // alert(e.target.value);
    setTcolor(e.target.value);
  };

  return (
    <div style={{ fontFamily: "twayair" }}>
      <h1 style={{ fontFamily: "SDSamliphopangche_Outline" }}>
        SevenApp 컴포넌트입니다
      </h1>
      <h3 style={{ fontFamily: "GongGothicMedium" }}>
        이름과 점수를 입력 후 엔터를 누르면 결과가 나옵니다
      </h3>
      <div className="input-group" style={{ width: "250px" }}>
        <span>이름</span>
        <input
          type={"text"}
          className="form-control"
          style={{ marginLeft: "10px" }}
          onChange={changeName}
        />
      </div>
      <div className="input-group" style={{ width: "250px" }}>
        <span>점수</span>
        <input
          type={"number"}
          className="form-control"
          style={{ marginLeft: "10px" }}
          onChange={changeScore}
          onKeyUp={enterEvent}
        />
      </div>
      <br />
      {/*
            true && 컴포넌트 : 보인다
            false && 컴포넌트 : 안보인다
        */}
      {true && ( //보이기 안보이기
        <div style={{ width: "250px", fontSize: "1.5em", color: tcolor }}>
          이 름 : {name}
          <br />점 수 : {score}점
          <br />등 급 : {grade}
          <br />
        </div>
      )}
      <br />
      <label>
        <input
          type={"radio"}
          value="black"
          name="tcolor"
          onClick={radioCheck}
        />{" "}
        검정색
      </label>
      &nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          value="green"
          name="tcolor"
          onClick={radioCheck}
        />{" "}
        녹색
      </label>
      &nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          value="gray"
          name="tcolor"
          defaultChecked
          onClick={radioCheck}
        />{" "}
        회색
      </label>
      &nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          value="orange"
          name="tcolor"
          onClick={radioCheck}
        />{" "}
        주황색
      </label>
      &nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          value="purple"
          name="tcolor"
          onClick={radioCheck}
        />{" "}
        보라색
      </label>
      &nbsp;&nbsp;
    </div>
  );
}

export default SevenApp;
