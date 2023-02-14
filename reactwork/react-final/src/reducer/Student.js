import React from "react";

function Student(props) {
  const { stu, dispatch } = props;

  return (
    <div style={{ marginTop: "10px" }}>
      <div
        className="input-group"
        style={{
          width: "200px",
          display: "flex",
          justifyContent: "space-between",
        }}
      >
        <span
          style={{
            textDecoration: stu.isHere ? "line-through" : "none",
            cursor: "pointer",
            color: stu.isHere ? "gray" : "black",
            display: "inline-block",
          }}
          onClick={() =>
            dispatch({ type: "mark-student", payload: { id: stu.id } })
          }
        >
          {stu.name}
        </span>
        &nbsp;&nbsp;
        <button
          type="button"
          className="btn btn-danger btn-sm"
          onClick={
            () => dispatch({ type: "delete-student", payload: { id: stu.id } }) //dispatch를 통해서 ReduceComp2와 통신
          }
        >
          삭제
        </button>
      </div>
    </div>
  );
}

export default Student;
