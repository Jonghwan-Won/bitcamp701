import { DeleteForeverRounded } from "@material-ui/icons";
import { Alert } from "@material-ui/lab";
import React, { useState } from "react";

function FiveApp(props) {
  const [foodArray, setFoodArray] = useState([
    {
      foodName: "에그샌드",
      foodPhoto: "1.jpg",
      foodPrice: "23,000",
      foodMessage: "에그샌드 최고에용",
    },
    {
      foodName: "망고 빙수",
      foodPhoto: "11.jpg",
      foodPrice: "15,000",
      foodMessage: "망빙 최고에용",
    },
    {
      foodName: "이것저것 꼬치",
      foodPhoto: "2.jpg",
      foodPrice: "11,000",
      foodMessage: "이것저것 꼬치 최고에용",
    },
  ]);

  //삭제 이벤트
  const deleteFood = (idx) => {
    //index 받아서~
    setFoodArray(foodArray.filter((f, i) => i !== idx));
  };

  return (
    <div>
      <Alert severity="info">
        <b style={{ fontSize: "20px" }}>FiveApp - 객체 배열 출력</b>
      </Alert>

      {/* 출력 테이블 */}
      <div style={{ margin: "15px 15px" }}>
        {foodArray.map((food, idx) => (
          <table className="table table-bordered" style={{ width: "600px" }}>
            <tbody>
              <tr>
                <td rowspan="3" style={{ width: "150px" }}>
                  <img
                    alt=""
                    src={require(`../food/${food.foodPhoto}`)}
                    style={{ width: "140px" }}
                  />
                </td>
                <td>음식명 : {food.foodName}</td>
                <td rowSpan={3} valign="middle" style={{ width: "50px" }}>
                  <span
                    style={{
                      float: "right",
                      color: "gray",
                      cursor: "pointer",
                    }}
                    onClick={() => deleteFood(idx)}
                  >
                    <DeleteForeverRounded />
                  </span>
                </td>
              </tr>
              <tr>
                <td>가격 : {food.foodPrice}</td>
              </tr>
              <tr>
                <td>후기 : {food.foodMessage}</td>
              </tr>
            </tbody>
          </table>
        ))}
      </div>
    </div>
  );
}

export default FiveApp;
