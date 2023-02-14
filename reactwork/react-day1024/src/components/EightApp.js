import { Alert } from "@material-ui/lab";
import React, { useState } from "react";

function EightApp(props) {
  const [msg, setMsg] = useState(["Happy", "Hello", "안녕"]);

  return (
    <div>
      <Alert severity="info" style={{ fontSize: "1.5em" }}>
        map 반복문 #4
      </Alert>
      <input
        type={"text"}
        className="form-control"
        style={{ width: "300px" }}
        placeholder="메세지를 입력 후 엔터를 누르세요"
        onKeyUp={(e) => {
          if (e.key === "Enter") {
            //리액트에서는 배열에 추가할 때 push 가 아닌 concat을 사용함
            // setMsg(msg.push(e.target.value)); // 안됨
            setMsg(msg.concat(e.target.value));
            e.target.value = "";
          }
        }}
      />
      <hr />
      <h6 className="alert alert-secondary">
        총 {msg.length}개의 메세지가 있어요
      </h6>
      <br />
      {msg.map((m, i) => (
        <h6 key={i}>{m}</h6>
      ))}
    </div>
  );
}

export default EightApp;
