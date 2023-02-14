import React, { useState } from "react";
import "./mystyle.css";

function SixApp() {
  const [msg, setMsg] = useState("마우스위치");

  //이벤트 따로 분리하기
  const handleEvent = (e) => {
    setMsg(`마우스위치 X:${e.pageX}, Y:${e.pageY}`);
  };

  return (
    <div
      onMouseMove={handleEvent}
      style={{ width: "400px", height: "400px", border: "1px solid gray" }}
    >
      <h1 style={{ fontFamily: "SDSamliphopangche_Outline" }}>
        SixApp 컴포넌트입니다
      </h1>
      <br />
      <b style={{ fontSize: "2em", fontFamily: "twayair" }}>{msg}</b>
      <br />
      <b style={{ fontSize: "2em", fontFamily: "GongGothicMedium" }}>{msg}</b>
      <br />
      <b style={{ fontSize: "2em", fontFamily: "Cafe24Ssurround" }}>{msg}</b>
    </div>
  );
}

export default SixApp;
