import { Alert } from "@material-ui/lab";
import React, { useRef, useState } from "react";

function TwoApp(props) {
  const [count, setCount] = useState(0);
  const countRef = useRef(0);

  console.log("랜더링중...");

  //이벤트들
  const countIncre = () => {
    setCount(count + 1);
  };

  const countRefIncre = () => {
    countRef.current = countRef.current + 1; //화면의 변수는 증가되지 않음(내부적으로는 증가)
    console.log("countRef=" + countRef.current);
  };

  return (
    <div>
      <Alert severity="info">
        <b style={{ fontSize: "20px" }}>
          TwoApp - useRef 변수관리 - 랜더링하지 않음
        </b>
      </Alert>
      <h1>state : {count}</h1>
      <h1>Ref : {countRef.current}</h1>
      <br />
      <button type="button" className="btn btn-danger" onClick={countIncre}>
        count 변수 증가
      </button>
      &nbsp;&nbsp;
      <button type="button" className="btn btn-dark" onClick={countRefIncre}>
        countRef 변수 증가
      </button>
    </div>
  );
}

export default TwoApp;
