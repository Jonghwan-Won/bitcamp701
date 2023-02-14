import React, { useContext } from "react";
import { ThemeContext } from "./ThemeContext";
import { UserContext } from "./UserContext";

function Content(props) {
  const { isDark } = useContext(ThemeContext);
  //   console.log("Content isDark=" + isDark);
  const username = useContext(UserContext);
  //   console.log(username);
  return (
    <div
      className="content"
      style={{ backgroundColor: isDark ? "gray" : "white" }}
    >
      <h1>{username}님...useContext 공부중</h1>
    </div>
  );
}

export default Content;
