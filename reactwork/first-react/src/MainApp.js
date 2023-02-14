import React, { useState } from "react";
import { OneApp } from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";
import SevenApp from "./SevenApp";
import EightApp from "./EightApp";

function MainApp() {
  const [idx, setIdx] = useState(8);

  return (
    <div style={{ margin: "50px" }}>
      <h1 style={{ fontFamily: "SDSamliphopangche_Outline" }}>
        2022-10-21 리액트 수업
      </h1>
      <br />
      <br />

      <select
        className="form-control"
        style={{ width: "200px" }}
        onChange={(e) => {
          console.log(e.target.value);
          setIdx(Number(e.target.value)); //String을 숫자타입으로 변경 === 여도 됨
          //   setIdx(e.target.value); //== 이렇게 해야됨
        }}
      >
        <option value={1}>1번 컴포넌트</option>
        <option value={2}>2번 컴포넌트</option>
        <option value={3}>3번 컴포넌트</option>
        <option value={4}>4번 컴포넌트</option>
        <option value={5}>5번 컴포넌트</option>
        <option value={6}>6번 컴포넌트</option>
        <option value={7}>7번 컴포넌트</option>
        <option value={8} selected>
          8번 컴포넌트
        </option>
      </select>
      <br />
      <h3
        className="alert alert-secondary"
        style={{ fontFamily: "GongGothicMedium" }}
      >
        {idx}번 컴포넌트를 선택했습니다
      </h3>

      <br />
      {idx === 1 ? (
        <OneApp />
      ) : idx === 2 ? (
        <TwoApp />
      ) : idx === 3 ? (
        <ThreeApp />
      ) : idx === 4 ? (
        <FourApp />
      ) : idx === 5 ? (
        <FiveApp />
      ) : idx === 6 ? (
        <SixApp />
      ) : idx === 7 ? (
        <SevenApp />
      ) : (
        <EightApp />
      )}
    </div>
  );
}

export default MainApp;
