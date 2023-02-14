import React from "react";
import { Route, Routes } from "react-router-dom";
import { Home, About, Food } from "./pages"; //해당 방식으로 하려면  pages의 index.js 에서 MyPhotoList 넣어줘야됨
//pages 안에 또 index.js 를 만든 이유
//pages 폴더명만 써도 그 안의 index.js가 자동 import된다
import imgFail from "./image/3.jpg";
import Menu from "./components/Menu";
import MyPhotoList from "./myphoto/MyPhotoList";
import MyPhotoWriteForm from "./myphoto/MyPhotoWriteForm";
import MyPhotoDetail from "./myphoto/MyPhotoDetail";
import MyPhotoUpdateForm from "./myphoto/MyPhotoUpdateForm";
import FoodList from "./food/FoodList";
import FoodForm from "./food/FoodForm";
import FoodDetail from "./food/FoodDetail";
import FoodUpdateForm from "./food/FoodUpdateForm";

function RouterMain(props) {
  return (
    <div>
      <Menu />
      <hr style={{ clear: "both" }} />
      <Routes>
        <Route path="/" element={<Home />} /> {/* '/' root일때 */}
        {/* <Route path="/about/:emp" element={<About />} /> */}
        <Route path="/about" element={<About />}>
          <Route path={":emp"} element={<About />} />
        </Route>
        <Route path="/food" element={<Food />} />
        <Route path="/food/:food1/:food2" element={<Food />} />
        {/* 포토 목록 #1 */}
        {/* <Route path="/photo/list/:num" element={<MyPhotoList />} /> */}
        {/* <Route path="/photo/write" element={<MyPhotoWriteForm />} /> */}
        {/* <Route path="/photo/detail/:num" element={<MyPhotoDetail />} /> */}
        {/* 포토 목록 #2 */}
        <Route path="/photo">
          <Route path="list/:num" element={<MyPhotoList />} />
          <Route path="write" element={<MyPhotoWriteForm />} />
          <Route path="detail/:num" element={<MyPhotoDetail />} />
          <Route path="updateform/:num" element={<MyPhotoUpdateForm />} />
        </Route>
        {/* Food 매핑 등록 */}
        <Route path="/food">
          <Route path="list" element={<FoodList />} />
          <Route path="addform" element={<FoodForm />} />
          <Route path="detail/:num" element={<FoodDetail />} />
          {/* 1031 update 추가 */}
          <Route path="updateform/:num" element={<FoodUpdateForm />} />
        </Route>
        {/* 아래는 테스트 */}
        <Route
          path="/login/*"
          element={
            <div>
              <h2>로그인의 하위태그 입니다</h2>
              <Home />
              <Food />
            </div>
          }
        />
        {/* 그 이외의 매핑주소일 경우 호출 */}
        <Route
          path="*"
          element={
            <div>
              <h1>잘못된 URL 주소 입니다</h1>
              <img alt="" src={imgFail} />
            </div>
          }
        />
        {/* 문제 Photo */}
        {/* <Route path="/photo/list" element={<MyPhotoList />}>
          <Route path={":emp"} element={<MyPhotoList />} />
        </Route> */}
      </Routes>
    </div>
  );
}

export default RouterMain;
