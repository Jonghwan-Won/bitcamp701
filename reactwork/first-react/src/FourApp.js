import React, { useState } from "react"; //useState 상태유지를 위함
import "./mystyle.css";

function FourApp() {
  const [number, setNumber] = useState(0); //초기값은 0

  return (
    <div>
      <hr />
      <h1 style={{ fontFamily: "SDSamliphopangche_Outline" }}>
        FourApp 컴포넌트입니다
      </h1>
      <b className="number">{number}</b>
      <br />
      <br />
      <button
        type="button"
        className="btn btn-secondary"
        style={{ marginLeft: "50px" }}
        onClick={() => {
          if (number > 0) {
            setNumber(number - 1);
          }
        }}
      >
        감소
      </button>

      <button
        type="button"
        className="btn btn-secondary"
        style={{ marginLeft: "10px" }}
        onClick={() => {
          if (number < 10) {
            setNumber(number + 1);
          }
        }}
      >
        증가
      </button>
    </div>
  );
}

export default FourApp;
