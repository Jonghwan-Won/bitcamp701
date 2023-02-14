import { Alert } from "@material-ui/lab";
import React, { useState } from "react";
import FoodRowItem from "./FoodRowItem";
import FoodSelectForm from "./FoodSelectForm";

function FoodMainApp(props) {
  const [foodArray, setFoodArray] = useState([
    {
      foodname: "에그샌드",
      foodphoto: "1.jpg",
      foodprice: 12000,
      foodcount: 2,
    },
    {
      foodname: "닭꼬치",
      foodphoto: "2.jpg",
      foodprice: 16000,
      foodcount: 3,
    },
  ]);

  //저장하는 이벤트
  const onAddData = (data) => {
    //자식 컴포넌트로부터 data를 통째로 받음

    setFoodArray(foodArray.concat(data));
  };

  //데이터 삭제
  const onDelete = (idx) => {
    setFoodArray(foodArray.filter((m, i) => i !== idx)); //반복문에서 rowitem 컴포넌트로보낼때 ondelete도 보내기
  };

  return (
    <div>
      <div className="mainTop">
        <Alert severity="info" style={{ fontSize: "25px" }}>
          Food - 부모 자식간 통신에 대한 예제입니다
        </Alert>

        {/* 주문(추가) 폼 */}
        <hr />
        <FoodSelectForm onAddData={onAddData} />
        <hr />

        <table className="table table-bordered" style={{ width: "800px" }}>
          <caption align="top">
            <b>Food Order List</b>
          </caption>
          <thead>
            <tr style={{ backgroundColor: "orange" }}>
              <th style={{ width: "50px" }}>번호</th>
              <th style={{ width: "200px" }}>메뉴명</th>
              <th style={{ width: "50px" }}>수량</th>
              <th style={{ width: "100px" }}>단가</th>
              <th style={{ width: "100px" }}>총가격</th>
              <th style={{ width: "100px" }}>삭제</th>
            </tr>
          </thead>

          <tbody>
            {foodArray.map((menu, idx) => (
              <FoodRowItem
                menu={menu}
                key={idx}
                idx={idx}
                onDelete={onDelete}
              />
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default FoodMainApp;
