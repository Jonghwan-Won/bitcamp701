import React, { useReducer, useState } from "react";
import Student from "./Student";

const initialState = {
  count: 1,
  students: [
    {
      id: new Date(),
      name: "이영자",
      isHere: false,
    },
  ],
};

const reducer = (state, action) => {
  console.log(state, action);

  switch (action.type) {
    case "add-student":
      //payload 를 통해서 입력한 name을 전달받을것이다
      const name = action.payload.name;

      //추가할 학생정보 구성
      const addStudent = {
        id: new Date(),
        // name:name,
        name,
        isHere: false,
      };

      const data = {
        count: state.count + 1,
        students: [...state.students, addStudent], //기존에 10명이 있으면 그대로 넣어주고, addstudent 해주기 -> 11명
      };

      return data;

    case "delete-student":
      return {
        count: state.count - 1,
        students: state.students.filter((s) => s.id !== action.payload.id),
      };

    case "mark-student":
      return {
        count: state.count,
        students: state.students.map((s) => {
          if (s.id === action.payload.id) {
            return { ...s, isHere: !s.isHere };
          }
          return s;
        }),
      };

    default:
      return state;
  }
};

function ReducerComp2(props) {
  const [name, setName] = useState("");
  const [studentInfo, dispatch] = useReducer(reducer, initialState);
  return (
    <div style={{ margin: "50px 50px" }}>
      <h1>Reducer 비트캠프 701호에 오신것을 환영합니다</h1>
      <h4>총 학생 수 : {studentInfo.count}</h4>
      <div className="input-group" style={{ width: "200px" }}>
        <input
          type="text"
          className="form-control"
          defaultValue={name}
          onChange={(e) => setName(e.target.value)}
          autoFocus
        />
        &nbsp;&nbsp;
        <button
          type="button"
          className="btn btn-danger"
          onClick={() => dispatch({ type: "add-student", payload: { name } })}
        >
          추가
        </button>
        {studentInfo.students &&
          studentInfo.students.map((stu, idx) => (
            <Student key={idx} stu={stu} dispatch={dispatch} /> //props로 Student.js에 넘김
          ))}
      </div>
    </div>
  );
}

export default ReducerComp2;
