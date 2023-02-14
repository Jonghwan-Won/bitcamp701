import React, { useState } from "react";
import Page from "./Page";
import { ThemeContext } from "./ThemeContext";
import "./context.css";
import { UserContext } from "./UserContext";

function Root(props) {
  const [isDark, setIsDark] = useState(false);

  return (
    //아래 태그안에 있는 모든 컴포넌트는 value 값 접근이 가능하다
    <UserContext.Provider value={"이영자"}>
      <ThemeContext.Provider value={{ isDark, setIsDark }}>
        <Page />
      </ThemeContext.Provider>
    </UserContext.Provider>
  );
}

export default Root;
