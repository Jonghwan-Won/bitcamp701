import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
// import OneApp from './OneApp';
import { OneApp } from "./OneApp"; //export로 한 경우 이런식으로..(컴포넌트 가져오듯)
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";

import reportWebVitals from "./reportWebVitals";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import MainApp from "./MainApp";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    {/* <App /> */}

    {/* <OneApp />
    <TwoApp />
    <ThreeApp />
    <FourApp /> 
    <FiveApp />*/}
    <MainApp />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
