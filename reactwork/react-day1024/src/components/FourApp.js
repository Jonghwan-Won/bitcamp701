import { Alert } from "@material-ui/lab";
import React, { useEffect, useState } from "react";

function FourApp(props) {
  const [count, setCount] = useState(1);
  const [visible, setVisible] = useState("visible");

  //useEffect .. count값 변경시에만 호출
  useEffect(() => {
    setVisible(count % 3 === 0 ? "visible" : "hidden");
  }, [count]);

  return (
    <div>
      <Alert severity="info" style={{ fontSize: "1.5em" }}>
        count가 3의 배수일때만 이미지 보이게 하기
      </Alert>

      <button
        type="button"
        className="btn btn-outline-secondary"
        onClick={() => {
          setCount(count + 1);
        }}
      >
        count 증가
      </button>

      <b style={{ fontSize: "4em", color: "red", marginLeft: "50px" }}>
        {count}
      </b>
      <br />
      <br />
      <img
        alt=""
        src="image/15.jpg"
        width={300}
        style={{ visibility: visible }}
      />
    </div>
  );
}

export default FourApp;
