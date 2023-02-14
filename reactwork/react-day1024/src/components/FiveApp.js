import { Alert } from "@material-ui/lab";
import React from "react";

function FiveApp(props) {
  const names = ["눈사람", "얼음", "눈", "바람"];

  //방법 1
  const nameList = names.map(function (name, index) {
    return (
      <li key={index}>
        {index}:{name}
      </li>
    );
  });

  //방법 2
  const nameList2 = names.map((name, i) => (
    <li key={i}>
      {i}:{name}
    </li>
  ));

  //방법3 - for문으로 하고자 할 경우 - 잘 사용 안함 (map 위주)
  const loop4 = () => {
    let arr = [];
    for (let i = 0; i < names.length; i++) {
      arr.push(<h5>{names[i]}</h5>);
    }
    return arr;
  };

  return (
    <div>
      <Alert severity="info" style={{ fontSize: "1.5em" }}>
        map 반복문
      </Alert>

      {/* 방법 1 */}
      <hr />
      {nameList}

      {/* 방법 2 */}
      <hr />
      {nameList2}

      <hr />
      {/* 직접 반복문 출력 */}
      {names.map((name, idx) => (
        <h3 className="alert alert-secondary" key={idx}>
          {name}
        </h3>
      ))}

      <hr />
      {loop4()}
    </div>
  );
}

export default FiveApp;
