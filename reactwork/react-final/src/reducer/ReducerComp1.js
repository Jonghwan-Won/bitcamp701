import React, { useReducer, useState } from "react";

//Reducer 를 이용해서 입출금관리를 하는 간단한 예제입니다

//action.type 을 미리 상수화해서 정해놓고자 할 경우
const ACTION_TYPES = {
  add: "addmoney",
  sub: "submoney",
};

const reducer = (state, action) => {
  console.log("reducer 가 일을 합니다", state, action);

  switch (action.type) {
    // case "addmoney":
    case ACTION_TYPES.add:
      return state + Number(action.payload);
    case "submoney":
      return state - Number(action.payload);
    default:
      return state;
  }
};

function ReducerComp1(props) {
  const [number, setNumber] = useState(0);

  //money의
  const [money, dispatch] = useReducer(reducer, 0); // 0은 money 의 초기값

  return (
    <div style={{ margin: "50px 50px" }}>
      <h1>useReducer 은행에 오신것을 환영합니다</h1>
      <h3>잔 고 : {money} 원</h3>
      <input
        type={"number"}
        value={number}
        step={1000}
        onChange={(e) => setNumber(e.target.value)}
      />
      <br />
      <br />
      <button
        type="button"
        className="btn btn-outline-success"
        onClick={() => dispatch({ type: ACTION_TYPES.add, payload: number })}
        // onClick={() => dispatch({ type: "addmoney", payload: number })}
      >
        입금
      </button>
      &nbsp;&nbsp;&nbsp;
      <button
        type="button"
        className="btn btn-outline-danger"
        onClick={() => dispatch({ type: ACTION_TYPES.sub, payload: number })}
        // onClick={() => dispatch({ type: "submoney", payload: number })}
      >
        출금
      </button>
    </div>
  );
}

export default ReducerComp1;
