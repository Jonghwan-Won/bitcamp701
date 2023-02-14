import { Alert } from "@material-ui/lab";
import React, { useState } from "react";

function NineApp(props) {
  const [array, setArray] = useState(["01", "02"]);

  //text 이벤트
  const addPhoto = (e) => {
    let num = e.target.value;
    if (e.key === "Enter") {
      if (num.length !== 2) {
        alert("숫자 2글자로 입력해주세요");
        e.target.value = "";
        return;
      }

      if (!Number.isInteger(Number(num))) {
        alert("숫자로 입력해주세요");
        e.target.value = "";
        return;
      }

      if (Number(num) < 1 || Number(num) > 20) {
        alert("01~20 사이의 값으로 입력바람");
        e.target.value = ""; 
      }

      //위 세가지 조건에 해당되지 않을 경우 배열에 추가
      setArray(array.concat(num));
      e.target.value = "";
    }
  };

  //이미지 더블클릭 시 호출(삭제)
  const deletePhoto = (index) => {
    alert(index + "번지의 배열 이미지를 삭제합니다");

    // slice 사용
    // setArray([
    //   ...array.slice(0, index),
    //   ...array.slice(index + 1, array.length),
    // ]);

    //idx만 제외하고 배열에 담기 (filter)
    setArray(array.filter((item, i) => i !== index)); //i가 2가 아닌것만 필터링(반환)
  };

  return (
    <div>
      <Alert severity="info" style={{ fontSize: "1.5em" }}>
        01~20사이의 값 입력하면 해당 사진이 나오게 하기 - 더블클릭 시 삭제
      </Alert>
      <b>01~20 입력 후 엔터</b>
      <input type={"text"} style={{ width: "60px" }} onKeyUp={addPhoto} />
      <hr />
      {array.map((iname, i) => (
        <img
          alt=""
          className="photo"
          src={require(`../image2/${iname}.png`)}
          key={i}
          onDoubleClick={() => {
            deletePhoto(i); //사용자 함수 호출
          }}
        />
      ))}
    </div>
  );
}

export default NineApp;
