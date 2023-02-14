import { Alert } from "@material-ui/lab";
import React, { useState } from "react";
import SevenRowItem from "./SevenRowItem";
import SevenWriteForm from "./SevenWriteForm";

function SevenApp(props) {
  const [dataArray, setDataArray] = useState([
    {
      irum: "성민",
      blood: "O",
      today: new Date(),
    },
    {
      irum: "선혜",
      blood: "O",
      today: new Date(),
    },
    {
      irum: "종환",
      blood: "O",
      today: new Date(),
    },
  ]);

  //삭제 이벤트
  const deleteData = (idx) => {
    setDataArray(dataArray.filter((d, i) => i !== idx));
  }; //자식이 idx를 받아서 처리할 수 있게 props로 보내야됨

  //추가 이벤트
  /*
  데이터 보낼 때 json 형태로 주는데
  blood:myBlood /* 키값과 변수명이 다른 경우 key, value 모두 작성
  blood:blood /* 키값과 변수명이 같을경우 blood만 쓰면 된다
  */
  const dataAdd = (data) => {
    // setDataArray(dataArray.concat(data)); //today가 없을땐 이렇게 하면됨
    setDataArray(
      dataArray.concat({
        ...data, //같은 이름의 데이터 일부만 추가하는 경우
        today: new Date(),
      })
    );
  };

  return (
    <div style={{ textAlign: "center" }}>
      <Alert severity="success">
        <b style={{ fontSize: "20px" }}>
          Seven - 부모 자식간 통신에 대한 예제입니다
        </b>
      </Alert>

      <hr />
      {/* 하위 컴포넌트로 보낼 경우 이벤트명은 onSave가 된다(같아도 되고 달라도 됨) */}
      <SevenWriteForm onSave={dataAdd} />
      <br />

      <table className="table table-bordered" style={{ width: "400px" }}>
        <thead>
          <tr style={{ backgroundColor: "#ddd" }}>
            <th style={{ width: "60px" }}>번호</th>
            <th style={{ width: "100px" }}>이름</th>
            <th style={{ width: "100px" }}>혈액형</th>
            <th style={{ width: "150px" }}>등록일</th>
            <th style={{ width: "60px" }}>삭제</th>
          </tr>
        </thead>
        <tbody>
          {dataArray.map((row, idx) => (
            <SevenRowItem
              key={idx}
              row={row}
              idx={idx}
              deleteData={deleteData} //자식이 idx를 받아서 처리할 수 있게 props로 보내야됨
            />
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default SevenApp;
