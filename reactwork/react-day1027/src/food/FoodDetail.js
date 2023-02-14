import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

import noimage from "../image/noimage.png";

function FoodDetail(props) {
  const [fooddata, setFoodData] = useState("");
  const [photo, setPhoto] = useState([]);

  const navi = useNavigate();
  const { num } = useParams();
  console.log(num);

  const url = localStorage.url + "/food/detail?num=" + num;
  const photoUrl = localStorage.url + "/image/";

  const selectFoodData = () => {
    axios.get(url).then((res) => {
      setFoodData(res.data);

      //데이터 중 fphoto 는 컴마로 분리해서 배열형태로 넣어준다
      setPhoto(res.data.fphoto.split(",")); //컴마 분리하면 배열타입으로 바뀜
    });
  };

  const deleteFood = () => {
    const deleteUrl = localStorage.url + "/food/delete?num=" + num;
    axios.delete(deleteUrl).then((res) => {
      alert("삭제되었습니다");
      navi("/food/list");
    });
  };

  useEffect(() => {
    selectFoodData();
  }, []);

  return (
    <div style={{ margin: "50px 50px" }}>
      <h5>
        주문자명 : {fooddata.fname}님(핸드폰 : {fooddata.fhp})
      </h5>
      <h5>주문한 메뉴 사진들</h5>
      {fooddata.fphoto === "no" ? (
        <img
          alt=""
          src={noimage}
          width="250"
          style={{ border: "1px solid lightgray", borderRadius: "10px" }}
        />
      ) : (
        //비동기데이터 출력 순서 문제 발생할때 해결방법 ★ => 데이터가 null이 아닐때 출력한다
        photo &&
        photo.map((myphoto, idx) => (
          <img
            key={idx}
            alt=""
            src={photoUrl + myphoto}
            className="foodphoto"
          />
        ))
      )}
      <br />
      <br />
      <h6 style={{ color: "lightgray" }}>[내용]</h6>
      <pre>
        <b>{fooddata.fcontent}</b>
      </pre>
      <h5>예약일 : {fooddata.bookingday}</h5>
      <h5>주문일 : {fooddata.orderday}</h5>
      <br />
      <button
        type="button"
        className="btn btn-secondary"
        onClick={() => navi("/food/list")}
      >
        목록
      </button>
      &nbsp;&nbsp;
      <button
        type="button"
        className="btn btn-success"
        onClick={() => navi("/food/addform")}
      >
        주문
      </button>
      &nbsp;&nbsp;
      <button
        type="button"
        className="btn btn-dark"
        onClick={() => navi(`/food/updateform/${num}`)}
      >
        수정
      </button>
      &nbsp;&nbsp;
      <button type="button" className="btn btn-danger" onClick={deleteFood}>
        삭제
      </button>
    </div>
  );
}

export default FoodDetail;
