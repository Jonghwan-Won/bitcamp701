import React, { useContext } from "react";
import { ThemeContext } from "./ThemeContext";

function Footer(props) {
  const { isDark, setIsDark } = useContext(ThemeContext);
  return (
    <footer
      className="footer"
      style={{ backgroundColor: isDark ? "black" : "lightgray" }}
    >
      <button
        type="button"
        className="btn btn-outline-dark"
        onClick={() => {
          setIsDark(!isDark);
        }}
      >
        Dark Mode
      </button>
    </footer>
  );
}

export default Footer;
