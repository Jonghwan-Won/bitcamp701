import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import FoodRowItem from "./FoodRowItem";

function FoodList(props) {
  const [foodlist, setFoodList] = useState([]);
  const [photo, setPhoto] = useState("");

  const list = () => {
    let listUrl = localStorage.url + "/food/list"; //백엔드 매핑주소

    axios.get(listUrl).then((res) => {
      setFoodList(res.data); // res.data 는 list 가 아닌 data
    });
  };

  //처음 시작 시 list() 함수 호출 (한번)
  useEffect(() => {
    list();
  }, []);

  const navi = useNavigate();

  return (
    <div style={{ margin: "50px 50px" }}>
      <button
        type="button"
        className="btn btn-outline-danger"
        onClick={() => navi("/food/addform")}
      >
        Food 등록
      </button>
      <br />
      <br />
      <h3 className="alert alert-secondary" style={{ width: "1100px" }}>
        총 {foodlist.length}건의 주문이 있습니다
      </h3>
      <br />
      <table className="table table-bordered" style={{ width: "550px" }}>
        <thead>
          <tr>
            <th style={{ width: "60px" }}>번호</th>
            <th style={{ width: "100px" }}>예약자명</th>
            <th style={{ width: "100px" }}>사진</th>
            <th style={{ width: "150px" }}>예약일</th>
          </tr>
        </thead>
        <tbody>
          {foodlist.map((row, idx) => (
            <FoodRowItem row={row} key={idx} idx={idx} />
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default FoodList;
