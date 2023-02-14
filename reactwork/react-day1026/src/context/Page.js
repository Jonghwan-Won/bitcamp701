import React, { useContext } from "react";
import Content from "./Content";
import Footer from "./Footer";
import Header from "./Header";
import { ThemeContext } from "./ThemeContext";

function Page(props) {
  //값이 넘어왔다는걸 확인만하고 주석 처리
  //   const data = useContext(ThemeContext);
  //   console.dir(data);
  return (
    <div className="page">
      <Header />
      <Content />
      <Footer />
    </div>
  );
}

export default Page;
