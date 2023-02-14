import React, { useState } from "react";

function OneApp(props) {
  const [photo, setPhoto] = useState("image/12.jpg");
  const [photo2, setPhoto2] = useState("17");
  const [photo3, setPhoto3] = useState("15");

  //radio1 이벤트
  const changeImage1 = (e) => {
    setPhoto(e.target.value);
  };

  //radio2 이벤트
  const changeImage2 = (e) => {
    setPhoto2(e.target.value);
  };

  //radio3 이벤트
  const changeImage3 = (e) => {
    setPhoto3(e.target.value);
  };

  return (
    <div>
      <h3 className="alert alert-dark">Radio클릭 시 이미지 변경하기</h3>
      <label>
        <input
          type={"radio"}
          defaultValue="image/2.jpg"
          name="photo"
          onClick={changeImage1}
        />
        김우빈
      </label>
      &nbsp;&nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          defaultValue="image/12.jpg"
          defaultChecked
          name="photo"
          onClick={changeImage1}
        />
        박보영
      </label>
      &nbsp;&nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          defaultValue="image/19.jpg"
          name="photo"
          onClick={changeImage1}
        />
        수지
      </label>
      {/* input radio에 name을 부여해줘야 그룹으로 인식되며 1개만 선택됨 */}
      <br />
      <br />
      <img
        alt=""
        src={photo}
        className="rounded-circle"
        style={{ width: "200px", height: "200px", marginLeft: "100px" }}
      />
      <hr />
      <label>
        <input
          type={"radio"}
          defaultValue="10"
          name="photo2"
          onClick={changeImage2}
        />
        김태희
      </label>
      &nbsp;&nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          defaultValue="17"
          defaultChecked
          name="photo2"
          onClick={changeImage2}
        />
        신민아
      </label>
      &nbsp;&nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          defaultValue="18"
          name="photo2"
          onClick={changeImage2}
        />
        신세경
      </label>
      {/* input radio에 name을 부여해줘야 그룹으로 인식되며 1개만 선택됨 */}
      <br />
      <br />
      <img
        alt=""
        src={`image/${photo2}.jpg`}
        className="rounded-circle"
        style={{ width: "200px", height: "200px", marginLeft: "100px" }}
      />
      <hr />
      <label>
        <input
          type={"radio"}
          defaultValue="15"
          name="photo3"
          defaultChecked
          onClick={changeImage3}
        />
        가오나시
      </label>
      &nbsp;&nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          defaultValue="08"
          name="photo3"
          onClick={changeImage3}
        />
        허수아비
      </label>
      &nbsp;&nbsp;&nbsp;
      <label>
        <input
          type={"radio"}
          defaultValue="03"
          name="photo3"
          onClick={changeImage3}
        />
        핑크리본
      </label>
      {/* input radio에 name을 부여해줘야 그룹으로 인식되며 1개만 선택됨 */}
      <br />
      <br />
      <img
        alt=""
        src={require(`../image2/${photo3}.png`)}
        className="img-thumnail"
        style={{ width: "200px", height: "200px", marginLeft: "100px" }}
      />
    </div>
  );
}

export default OneApp;
