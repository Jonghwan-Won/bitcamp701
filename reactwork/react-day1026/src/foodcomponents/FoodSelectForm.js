import React, { useState } from "react";

function FoodSelectForm(props) {
  //메뉴명 배열
  const foodNameArray = [
    "에그샌드",
    "닭꼬치",
    "육칼면",
    "비프스튜",
    "콘치즈",
    "한라산볶음밥",
    "토마토솥밥",
    "샌드위치",
    "우엉반찬",
    "햄마요덮밥",
    "망고빙수",
    "순두부열라면",
  ];

  const [foodname, setFoodname] = useState(foodNameArray[0]);
  const [foodphoto, setFoodphoto] = useState("1.jpg");
  const [foodprice, setFoodprice] = useState(0);
  const [foodcount, setFoodcount] = useState(1);

  //select 변경 이벤트
  const selectEvent = (e) => {
    //value 값
    setFoodphoto(e.target.value);

    //text 값
    console.log(e.target.selectedIndex);
    let fname = e.target.options[e.target.selectedIndex].text;
    console.log(fname);
    setFoodname(fname);
  };

  //배열에 추가 이벤트 - 부모 컴포넌트의 onAddData
  const btnAddEvent = () => {
    if (foodprice === 0) {
      alert("가격을 입력해주세요");
      return;
    }

    if (Number(foodcount) === 0) {
      //if 조건에 따른 alert 가 안되는 현상
      // ===를 쓸때는 타입과 값 모두 일치해야되므로 String -> Number로 변환해줘야됨
      // 또는 값만 비교하도록 == 두개만 쓰면됨

      alert("수량을 입력해주세요");
      return;
    }

    props.onAddData({ foodname, foodphoto, foodprice, foodcount });

    //입력값 지우기
    setFoodprice("0");
    setFoodcount("1");
    setFoodphoto("1.jpg");
    setFoodname(foodNameArray[0]);
  };

  return (
    <div className="input-group" style={{ width: "800px" }}>
      {/* div 1 */}
      <div style={{ marginLeft: "20px" }}>
        <h5>주문할 메뉴를 선택하세요</h5>
        <select className="form-control" onChange={selectEvent}>
          {
            // option의 value는 1~12, 메뉴명은 option text로 넣어보세요
            foodNameArray.map((fname, idx) => (
              <option value={`${idx + 1}.jpg`}>{fname}</option>
            ))
          }
        </select>

        <br />

        <div className="input-group">
          <h5>단가:</h5>&nbsp;&nbsp;
          <input
            type={"number"}
            className="form-control"
            value={foodprice}
            step={500}
            onChange={(e) => {
              setFoodprice(e.target.value);
            }}
          />
        </div>
        <br />
        <div className="input-group">
          <h5>수량:</h5>&nbsp;&nbsp;
          <input
            type={"number"}
            className="form-control"
            value={foodcount}
            step={1}
            onChange={(e) => setFoodcount(e.target.value)}
          />
        </div>
      </div>
      {/* div 2 */}
      <div style={{ marginLeft: "30px" }}>
        <h5>현재 주문 메뉴 확인</h5>
        <img
          alt=""
          src={require(`../food/${foodphoto}`)}
          style={{ width: "120px", height: "120px", border: "2px solid gray" }}
          align="left"
          hspace="20"
        />
        <b>메뉴명: {foodname}</b>
        <br />

        <b>가 격: {foodprice}원</b>
        <br />

        <b>수 량: {foodcount}개</b>
        <br />

        <button
          type="button"
          className="btn btn-outline-success"
          onClick={btnAddEvent}
        >
          확인 후 주문
        </button>
      </div>
    </div>
  );
}

export default FoodSelectForm;
