import React, { useState } from "react";

function FiveApp(props) {
  const [name, setName] = useState("이미자");
  const [age, setAge] = useState(23);

  const style1 = {
    color: "deepgreen",
    width: "200px",
    backgroundColor: "#ffc",
    border: "1px solid gray",
    fontFamily: "KOTRAHOPE",
    fontSize: "2em",
  };

  return (
    <div>
      <h1 style={{ fontFamily: "SDSamliphopangche_Outline" }}>
        FiveApp 컴포넌트입니다
      </h1>
      <div style={style1}>
        이름 : {name}
        <br />
        나이 : {age}
      </div>

      <br />
      <button
        type="button"
        className="btn btn-outline-dark"
        onClick={() => {
          setName("또자");
          setAge(24);
        }}
      >
        정보 변경하기
      </button>

      <br />
      <br />
      <b>이름 입력 : </b>
      <input
        type="text"
        className="form-control"
        onKeyUp={(e) => {
          console.log(e.target.value);
          setName(e.target.value);
        }}
      />

      <b>나이 입력 : </b>
      <input
        type="text"
        className="form-control"
        onKeyUp={(e) => {
          console.log(e.target.value);
          setAge(e.target.value);
        }}
      />
    </div>
  );
}

export default FiveApp;
