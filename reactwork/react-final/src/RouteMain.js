import Menu from "./components/Menu";
import Home from "./components/Home";
import React from "react";
import { Route, Routes } from "react-router-dom";
import BoardForm from "./board/BoardForm";
import BoardList from "./board/BoardList";
import LoginForm from "./login/LoginForm";
import MemberForm from "./member/MemberForm";
import MemberList from "./member/MemberList";
import "./App.css";
import BoardSelect from "./board/BoardSelect";
import ReducerComp1 from "./reducer/ReducerComp1";
import ReducerComp2 from "./reducer/ReducerComp2";
import QueryComp from "./reducer/QueryComp";

function RouteMain(props) {
  return (
    <div>
      <Menu />
      <br style={{ clear: "both" }} />
      <br />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<LoginForm />} />
        <Route path="/member">
          <Route path="form" element={<MemberForm />} />
          <Route path="list" element={<MemberList />} />
        </Route>
        <Route path="/board">
          <Route path="form" element={<BoardForm />} />
          <Route path="list" element={<BoardList />} />
          <Route path="list/:currentPage" element={<BoardList />} />
          <Route path="select/:num" element={<BoardSelect />} />
        </Route>

        {/* Reducer 메뉴 */}
        <Route path="/reducer1" element={<ReducerComp1 />} />
        <Route path="/reducer2" element={<ReducerComp2 />} />

        {/* 쿼리 스트링 */}
        <Route path="/qstring" element={<QueryComp />} />

        <Route
          path="*"
          element={
            <div>
              <h1>잘못된 URL 주소입니다</h1>
            </div>
          }
        />
      </Routes>
    </div>
  );
}

export default RouteMain;
