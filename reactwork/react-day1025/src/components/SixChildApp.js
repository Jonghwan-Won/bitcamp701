import { Alert } from "@material-ui/lab";
import React from "react";

function SixChildApp(props) {
  return (
    <div>
      <Alert
        severity="success"
        style={{
          border: "5px inset green",
          width: "300px",
          marginBottom: "10px",
        }}
      >
        <b style={{ fontSize: "15px" }}>SixChildApp 입니다</b>
        <br />
        <b>이름:{props.name}</b>
        <b style={{ marginLeft: "30px" }}>나이:{props.age}세</b>
        &nbsp;&nbsp;
        <button
          type="button"
          className="btn btn-sm btn-dark"
          onClick={props.countHandler}
        >
          증가
        </button>
      </Alert>
    </div>
  );
}

export default SixChildApp;
