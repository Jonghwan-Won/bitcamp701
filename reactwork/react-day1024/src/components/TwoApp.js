import { Switch } from "@material-ui/core";
import { Alert, AlertTitle } from "@material-ui/lab";
import React, { useState } from "react";

function TwoApp(props) {
  //방법 1
  const [show, setShow] = useState(true);

  //방법 2
  const [visible, setVisible] = useState("visible");

  return (
    <div>
      {/* 방법 1 */}
      <Alert severity="info" style={{ fontSize: "1.5em" }}>
        <AlertTitle>Image Show</AlertTitle>
        이미지 또는 컴포넌트 안보이게 하는 여러가지 방법{" "}
        <strong>Check it</strong>
      </Alert>
      <label>
        <input
          type={"checkbox"}
          defaultChecked
          onClick={(e) => {
            setShow(e.target.checked);
          }}
        />{" "}
        이미지1 Show
      </label>
      <br />
      {show && <img alt="" src="image/17.jpg" width={200} />}

      {/* 방법 2 */}
      <hr />
      <Switch
        defaultChecked={true}
        color="primary"
        onChange={(e) => {
          console.log(e.target.checked); //true, false
          setVisible(e.target.checked ? "visible" : "hidden");
        }}
      />
      <br />
      <img
        src="image/12.jpg"
        alt=""
        width={200}
        style={{ visibility: visible }} //여기서 visible 은 변수명
      />
    </div>
  );
}

export default TwoApp;
