import React, { useState } from "react";
import img1 from "./02.png";
import img2 from "./03.png";

function EightApp(props) {
  const [message, setMessage] = useState("");
  const [photo, setphoto] = useState("./01.png");
  const [hideImg, setHideImg] = useState(true);
  const [imgSize, setImgSize] = useState(200);
  const [bord, setBord] = useState("solid");

  //   const changePhoto = (e) => {
  //     // alert(e.target.value);
  //     setphoto(e.target.value);
  //   };
  //   위 방법이 안돼서 onChange 직접줬음

  const changeMessage = (e) => {
    setMessage(e.target.value);
  };

  const checkHide = (e) => {
    if (e.target.checked) {
      setHideImg(false);
    } else {
      setHideImg(true);
    }
  };

  const sizeUp = (e) => {
    setImgSize(imgSize + 10);
  };

  const sizeDown = (e) => {
    setImgSize(imgSize - 10);
  };

  const changeBorder = (e) => {
    setBord(e.target.value);
  };

  return (
    <div style={{ fontFamily: "twayair" }}>
      <h1>오늘의 문제</h1>
      <hr />
      <label>
        <input type={"checkbox"} onClick={checkHide} />
        &nbsp; 숨김
      </label>
      &nbsp;&nbsp;&nbsp;
      <button type="button" className="btn btn-dark" onClick={sizeDown}>
        점점작게
      </button>
      &nbsp;&nbsp;&nbsp;
      <button type="button" className="btn btn-secondary" onClick={sizeUp}>
        점점크게
      </button>
      <br />
      <br />
      <input
        type={"text"}
        className="form-control"
        placeholder="메세지 입력"
        style={{ width: "250px" }}
        onChange={changeMessage}
      />
      <br />
      <select
        style={{ width: "250px" }}
        className="form-control"
        onChange={(e) => {
          setphoto(e.target.value);
        }}
      >
        <option disabled hidden selected value="">
          사진 선택
        </option>
        <option value="./01.png">미야자키 1</option>

        {/* src에 있는 파일이라 위에서 import 해줘야됨 */}
        <option value={img1}>미야자키 2</option>
        <option value={img2}>미야자키 3</option>
      </select>
      <br />
      <select
        style={{ width: "250px" }}
        className="form-control"
        onChange={changeBorder}
      >
        <option disabled hidden selected>
          테두리 선택
        </option>
        <option value="solid">solid</option>
        <option value="dotted">dotted</option>
        <option value="inset">inset</option>
      </select>
      <br />
      {hideImg && (
        <img
          src={photo}
          alt="사진없음"
          style={{ width: imgSize, border: `3px ${bord} gray` }}
        />
      )}
      <br />
      <div>
        <h1
          style={{
            backgroundColor: "lightgray",
            width: "500px",
            height: "100px",
            paddingTop: "25px",
            textAlign: "center",
          }}
        >
          {message}
        </h1>
      </div>
    </div>
  );
}

export default EightApp;
