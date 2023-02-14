import { Alert } from "@material-ui/lab";
import React, { useState } from "react";
import SixChildApp from "./SixChildApp";

function SixParentApp(props) {
  const [count, setCount] = useState(10);

  //count를 증가하는 이벤트
  const countIncre = () => {
    setCount(count + 1);
  };

  return (
    <div>
      <Alert severity="success">
        <b style={{ fontSize: "20px" }}>
          Six - 부모 자식간 통신에 대한 예제입니다
        </b>
      </Alert>
      <b style={{ fontSize: "20px" }}>방문횟수 : {count}회</b>

      {/*  자식 컴포넌트 호출 */}
      <div style={{ margin: "10px 10px" }}>
        {/* 자식 컴포넌트 호출, 부모 컴포넌트의 state변수는 자식컴포넌트에서 직접 변경 불가
        이벤트를 통한 변경은 가능하다 */}
        <SixChildApp name={"이영자"} age={23} countHandler={countIncre} />
        <SixChildApp name={"캔디"} age={32} countHandler={countIncre} />
        <SixChildApp name={"마이클"} age={40} countHandler={countIncre} />
      </div>
    </div>
  );
}

export default SixParentApp;
