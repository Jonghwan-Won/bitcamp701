import { Alert } from "@material-ui/lab";
import React from "react";

function SevenApp_teacher(props) {
  const array1 = ["red", "green", "orange", "hotpink", "black"];
  const array2 = [
    { name: "캔디", addr: "서울" },
    { name: "이라이자", addr: "제주" },
    { name: "안소니", addr: "부산" },
    { name: "테리우스", addr: "대구" },
  ];

  const array3 = ["03", "06", "09", "12", "19"];

  return (
    <div>
      <Alert severity="info" style={{ fontSize: "1.5em" }}>
        map 반복문 #3
      </Alert>
      {/* 반복문 연습 */}
      <h5 className="alert alert-secondary">출력 1</h5>
      {array1.map((color, idx) => (
        <div className="box" style={{ backgroundColor: color }} key={idx}></div>
      ))}

      {/* 반복문 연습 */}
      <h5 className="alert alert-secondary" style={{ clear: "both" }}>
        {/* clear:both 로 css에서 주어진 float 설정이 해제됨 */}
        출력 2
      </h5>
      {array2.map((info, idx) => (
        <h5 key={idx}>
          이름:{info.name}, 지역:{info.addr}
        </h5>
      ))}
      {/* 반복문 연습 */}
      <h5 className="alert alert-secondary">출력 3</h5>
      {array3.map((photoname, idx) => (
        <img
          alt=""
          key={idx}
          width="80"
          src={require(`../image2/${photoname}.png`)}
        />
      ))}
    </div>
  );
}

export default SevenApp_teacher;
