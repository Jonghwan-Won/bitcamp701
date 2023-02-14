import { DeleteForeverRounded } from "@material-ui/icons";
import { Alert } from "@material-ui/lab";
import React, { useState } from "react";

function FourApp(props) {
  const [inputs, setInputs] = useState({
    //객체 형태
    name: "캔디",
    nickname: "곰돌이",
    hp: "010-2222-3333",
    address: "서울시 강남구",
  });

  //입력시 호출할 이벤트
  const changeData = (e) => {
    // console.log(e.target.name, e.target.value);
    let { name, value } = e.target; //e.target으로부터 name과 value추출

    //객체로 되어있을때 수정하는방법★
    setInputs({
      ...inputs, //기존 inputs 객체의 값이 쫙 펼쳐짐 (=복사해서 넣음 : 펼침 연산자)
      [name]: value, //내가 입력하는 name(=input태그의 name)의 value값을 넣는다
    });
  };

  //초기화 버튼 이벤트
  const resetButtonEvent = () => {
    setInputs({
      name: "",
      nickname: "",
      hp: "",
      address: "",
    });
  };

  //배열에 객체 저장
  //배열 선언
  const [inputArray, setInputArray] = useState([]);

  //저장버튼 클릭 이벤트
  const saveButtonEvent = () => {
    setInputArray(inputArray.concat(inputs));

    console.log(inputArray);
  };

  //삭제버튼 이벤트
  const deleteData = (idx) => {
    setInputArray(inputArray.filter((item, i) => i !== idx));
  };

  return (
    <div>
      <Alert severity="info">
        <b style={{ fontSize: "20px" }}>FourApp</b>
      </Alert>
      <div className="input-group">
        <div>
          <table className="table table-bordered" style={{ width: "400px" }}>
            <tbody>
              <tr>
                <th style={{ width: "100px" }}>이름</th>
                <td>
                  <input
                    type={"text"}
                    name="name"
                    className="form-control"
                    value={inputs.name}
                    onChange={changeData}
                  />
                </td>
              </tr>

              <tr>
                <th style={{ width: "100px" }}>닉네임</th>
                <td>
                  <input
                    type={"text"}
                    name="nickname"
                    className="form-control"
                    value={inputs.nickname}
                    onChange={changeData}
                  />
                </td>
              </tr>

              <tr>
                <th style={{ width: "100px" }}>연락처</th>
                <td>
                  <input
                    type={"text"}
                    name="hp"
                    className="form-control"
                    value={inputs.hp}
                    onChange={changeData}
                  />
                </td>
              </tr>

              <tr>
                <th style={{ width: "100px" }}>주소</th>
                <td>
                  <input
                    type={"text"}
                    name="address"
                    className="form-control"
                    value={inputs.address}
                    onChange={changeData}
                  />
                </td>
              </tr>

              <tr>
                <td colSpan={2} align="center">
                  <button
                    type="button"
                    className="btn btn-outline-danger"
                    onClick={resetButtonEvent}
                  >
                    입력값 초기화
                  </button>
                  &nbsp;
                  <button
                    type="button"
                    className="btn btn-dark"
                    onClick={saveButtonEvent}
                  >
                    배열에 객체 추가
                  </button>
                </td>
              </tr>
              <tr style={{ height: "100px", backgroundColor: "silver" }}>
                <td colSpan={2}>
                  <pre style={{ fontSize: "20px", fontFamily: "Jua" }}>
                    이 름 : {inputs.name}
                    <br />
                    닉네임 : {inputs.nickname}
                    <br />
                    연락처 : {inputs.hp}
                    <br />주 소 : {inputs.address}
                  </pre>
                </td>
              </tr>
            </tbody>
          </table>
        </div>

        <div style={{ float: "left" }}>
          {/* 선생님 버전 div */}
          {/* <div style={{position:'absolute',left:'500px',top:'70px'}} ></div> */}
          <h5>총 {inputArray.length}개의 정보가 있습니다</h5>
          <table
            className="table table-bordered"
            style={{ width: "600px", textAlign: "center" }}
          >
            <thead>
              <tr style={{ backgroundColor: "#ddd" }}>
                <th>번호</th>
                <th>이름</th>
                <th>닉네임</th>
                <th>연락처</th>
                <th>주소</th>
                <th>삭제</th>
              </tr>
            </thead>

            <tbody>
              {inputArray.map((info, idx) => (
                <tr key={idx}>
                  <td>{idx + 1}</td>
                  <td>{info.name}</td>
                  <td>{info.nickname}</td>
                  <td>{info.hp}</td>
                  <td>{info.address}</td>
                  <td>
                    <span
                      style={{
                        float: "right",
                        color: "red",
                        cursor: "pointer",
                      }}
                      onClick={() => deleteData(idx)}
                    >
                      <DeleteForeverRounded />
                    </span>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      {/* input-group 감싼거 */}
    </div>
  );
}

export default FourApp;
