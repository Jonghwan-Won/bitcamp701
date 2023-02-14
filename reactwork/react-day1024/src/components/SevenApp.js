import { Alert } from "@material-ui/lab";
import React from "react";

function SevenApp(props) {
  const array1 = ["red", "green", "orange", "hotpink", "black"];
  const array2 = [
    { name: "캔디", addr: "서울" },
    { name: "이라이자", addr: "제주" },
    { name: "안소니", addr: "부산" },
    { name: "테리우스", addr: "대구" },
  ];

  const array3 = ["03", "06", "09", "12", "19"];

  // array1
  const colorList = array1.map((name, idx) => (
    <p
      key={idx}
      style={{
        backgroundColor: `${name}`,
        width: "100px",
        height: "100px",
        marginRight: "10px",
        borderRadius: "50px",
      }}
    >
      {name}
    </p>
  ));

  // array2
  const candy = array2.map((name, idx) => <span key={idx}>{name}</span>);

  // array3
  const imgList = array3.map((imgname, idx) => (
    <img
      alt=""
      src={require(`../image2/${imgname}.png`)}
      key={idx}
      style={{ width: "100px" }}
    />
  ));

  return (
    <div>
      <Alert severity="info" style={{ fontSize: "1.5em" }}>
        map 반복문 #3
      </Alert>
      {/* 반복문 연습 */}
      <h5 className="alert alert-secondary">출력 1</h5>
      <div style={{ display: "flex" }}>{colorList}</div>
      {/* 반복문 연습 */}
      <h5 className="alert alert-secondary">출력 2</h5>w{/* 반복문 연습 */}
      <h5 className="alert alert-secondary">출력 3</h5>
      {imgList}
    </div>
  );
}

export default SevenApp;
