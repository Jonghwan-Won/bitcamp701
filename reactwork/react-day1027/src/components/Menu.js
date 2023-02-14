import React from "react";
import { NavLink } from "react-router-dom";

function Menu(props) {
  return (
    <div>
      <ul className="menu">
        <li>
          <NavLink to={"/"}>Home</NavLink>
        </li>
        <li>
          <NavLink to={"/food/list"}>Food</NavLink>
        </li>

        {/*         
        <li>
          <NavLink to={"/food/11/111"}>Food #2</NavLink>
        </li> 
        */}

        {/* ↓ 호출은 About 컴포넌트가 호출됨 */}
        <li>
          <NavLink to={"/about/bitcamp"}>About #1</NavLink> {/* emp: bitcamp*/}
        </li>
        <li>
          <NavLink to={"/about/CGV"}>About #2</NavLink> {/* emp: CGV*/}
        </li>
        <li>
          <NavLink to={"/about/삼성전자"}>About #3</NavLink>
          {/* emp: 삼성전자*/}
        </li>

        {/* 문제 photo */}
        <li style={{ backgroundColor: "gray" }}>
          <NavLink to={"/photo/list/1"}>Photo #1</NavLink>
        </li>
        <li style={{ backgroundColor: "gray" }}>
          <NavLink to={"/photo/list/2"}>Photo #2</NavLink>
        </li>
      </ul>
    </div>
  );
}

export default Menu;
