import React, { useContext } from "react";
import { ThemeContext } from "./ThemeContext";
import { UserContext } from "./UserContext";

function Header(props) {
  const { isDark } = useContext(ThemeContext);
  //   console.log("Header isDark=" + isDark);
  const username = useContext(UserContext);
  //   console.log("username:" + username);
  return (
    <header
      className="header"
      style={{ backgroundColor: isDark ? "black" : "lightgray" }}
    >
      <h1>안녕하세요 {username}님!</h1>
    </header>
  );
}

export default Header;
