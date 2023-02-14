import React from "react";

function Home(props) {
  // sessionStorage.url = process.env.REACT_APP_URL;
  localStorage.url = process.env.REACT_APP_URL;
  return (
    <div style={{ margin: "50px 50px" }}>
      <h1>HOME</h1>
    </div>
  );
}

export default Home;
