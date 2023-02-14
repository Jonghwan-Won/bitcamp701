import { Alert } from "@material-ui/lab";
import React, { useState } from "react";

function OneApp(props) {
  const [nameArray, setNameArray] = useState(["이효리", "한가인"]);
  const [name, setName] = useState("");

  //이벤트들
  const changeName = (e) => {
    setName(e.target.value);
  };

  const addData = () => {
    if (name.trim === "") {
      alert("이름을 입력 후 추가해주세요");
      return;
    }

    setNameArray(nameArray.concat(name));
    setName(""); //name이 지워짐
  };

  const deleteName = (idx) => {
    setNameArray(nameArray.filter((item, i) => i !== idx));
  };

  return (
    <div>
      <Alert severity="info">
        <b style={{ fontSize: "20px" }}>
          OneApp - 배열 추가, 삭제 복습 (10/24)
        </b>
      </Alert>
      <div className="input-group" style={{ width: "250px" }}>
        <h4>이름 입력: </h4>
        <input
          type={"text"}
          className="form-control"
          value={name}
          onChange={changeName}
        />
        <button
          type="button"
          className="btn btn-outline-success"
          onClick={addData}
        >
          추가
        </button>
      </div>
      <hr />

      {/* 출력 */}
      {nameArray.map((item, idx) => (
        <div
          className="input-group"
          style={{ width: "300px", marginBottom: "10px" }}
          key={idx}
          // 부모태그에 key값 넣어주기(idx)
        >
          <h4>{item}</h4>
          <button
            type="button"
            className="btn btn-sm btn-danger"
            style={{ marginLeft: "10px" }}
            onClick={() => {
              deleteName(idx);
            }}
          >
            삭제
          </button>
        </div>
      ))}
    </div>
  );
}

export default OneApp;
