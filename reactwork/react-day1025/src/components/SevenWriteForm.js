import React, { useState } from "react";

function SevenWriteForm({ onSave }) {
  const [irum, setIrum] = useState("");
  const [blood, setBlood] = useState("A"); //선택안하고 등록할 수 있으므로 초기값 A로 주기

  //버튼 이벤트
  const buttonEvent = () => {
    console.log(irum);
    console.log(blood);
    onSave({ irum, blood }); //부모 컴포넌트로부터 전달받은 onSave 호출

    //입력값 지우기
    setIrum("");
  };

  return (
    <div className="input-group" style={{ width: "300px" }}>
      <h5>이름:</h5>&nbsp;
      <input
        type={"text"}
        className="form-control"
        value={irum}
        onChange={(e) => {
          setIrum(e.target.value);
        }}
      />
      &nbsp;&nbsp;
      <h5>혈액형</h5>&nbsp;
      <select
        className="form-select"
        onChange={(e) => {
          setBlood(e.target.value);
        }}
      >
        <option>A</option>
        <option>B</option>
        <option>O</option>
        <option>AB</option>
      </select>
      &nbsp;
      <button
        type="button"
        className="btn btn-dark btn-sm"
        onClick={buttonEvent}
      >
        등록
      </button>
    </div>
  );
}

export default SevenWriteForm;
