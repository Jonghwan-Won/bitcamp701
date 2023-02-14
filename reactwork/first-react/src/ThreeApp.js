//rcc로 생성 후 PureComponent → Component 수정
import React, { Component } from "react";
import "./mystyle.css";

class ThreeApp extends Component {
  constructor(props) {
    super(props);

    //리액트는 값을 변경하기 위해서는 반드시 state로 선언해야만 한다
    this.state = {
      number: 0 /* number라는 변수에 0을 초기값으로 지정 */,
    };
  }

  render() {
    return (
      <div>
        <h1 style={{ fontFamily: "SDSamliphopangche_Outline" }}>
          ThreeApp 컴포넌트입니다
        </h1>
        <b className="number">{this.state.number}</b>
        <br />
        <br />
        <button
          type="button"
          className="btn btn-outline-dark"
          style={{ marginLeft: "20px" }}
          onClick={() => {
            //0보다 클때만 증가되도록
            if (this.state.number > 0) {
              this.setState({
                number: this.state.number - 1,
              });
            }
          }}
        >
          감소
        </button>

        <button
          type="button"
          className="btn btn-outline-dark"
          style={{ marginLeft: "20px" }}
          onClick={() => {
            //10보다 작을때만 증가되도록
            if (this.state.number < 10) {
              this.setState({
                number: this.state.number + 1,
              });
            }
          }}
        >
          증가
        </button>

        <button
          type="button"
          className="btn btn-outline-dark"
          style={{ marginLeft: "20px" }}
          onClick={() => {
            this.setState({
              number: 0,
            });
          }}
        >
          초기화
        </button>
      </div>
    );
  }
}

export default ThreeApp;
