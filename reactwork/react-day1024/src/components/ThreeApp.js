import { Alert } from "@material-ui/lab";
import React, { useEffect, useState } from "react";

function ThreeApp(props) {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState("Hello");
  const [number, setNumber] = useState(100);

  //이벤트들
  const changeCount = () => {
    setCount(count + 1);
  };

  const changeNumber = () => {
    setNumber(number + 10);
  };

  const changeAll = () => {
    setCount(count + 2);
    setNumber(number + 5);
  };

  const changeMessage = (e) => {
    setMessage(e.target.value);
  };

  // //useEffect 는 여러번 정의 가능

  // //useEffect
  // useEffect(() => {
  //   console.log("state 값이 변경될때마다 무조건 호출");
  //   //콘솔 확인해보기  -> index.js 에서 react.strictmode 주석처리하면 두개안생김
  //   //버튼클릭해서 값증가할때마다 (state변경) 콘솔에 찍히는게 보임
  // });

  useEffect(() => {
    console.log("처음 딱 한번만 호출됩니다");
  }, []);

  useEffect(() => {
    console.log("처음 시작 그리고 count 값 변경 시 호출됩니다");
  }, [count]);

  useEffect(() => {
    console.log("처음 시작 그리고 number 값 변경 시 호출됩니다");
  }, [number]);

  useEffect(() => {
    console.log("처음 시작 그리고 number,count 변경 시 호출됩니다");
  }, [number, count]);

  useEffect(() => {
    console.log("처음 시작 그리고 message 값 변경 시 호출됩니다");
  }, [message]);

  return (
    <div style={{ width: 600, margin: "20px 20px" }}>
      <Alert severity="info" style={{ fontSize: "1.5em" }}>
        useEffect 에 대한 공부 <strong>중요합니다</strong>
      </Alert>
      <br />
      <button type="button" className="btn btn-dark" onClick={changeCount}>
        count만 증가
      </button>
      &nbsp;
      <button type="button" className="btn btn-dark" onClick={changeNumber}>
        number만 증가
      </button>
      &nbsp;
      <button type="button" className="btn btn-dark" onClick={changeAll}>
        count, number 증가
      </button>
      <br />
      <br />
      <b style={{ fontSize: "4em" }}>{count}</b>
      <b style={{ marginLeft: "30px", fontSize: "4em" }}>{number}</b>
      <hr />
      <input
        type={"text"}
        className="form-control"
        defaultValue={message}
        onKeyUp={changeMessage}
        style={{ width: 400 }}
      />
      <h1>{message}</h1>
    </div>
  );
}

export default ThreeApp;
