import logo from "./logo.svg";
import "./App.css";
import OneApp from "./components/OneApp";
import TwoApp from "./components/TwoApp";
import ThreeApp from "./components/ThreeApp";
import FourApp from "./components/FourApp";
import FiveApp from "./components/FiveApp";
import SixParentApp from "./components/SixParentApp";
import SevenApp from "./components/SevenApp";

function App() {
  return (
    <div className="App" style={{ margin: "10px 10px" }}>
      {/* <OneApp />
      <TwoApp />
      <ThreeApp />
      <FourApp />
      <FiveApp />
      <SixParentApp /> */}
      <SevenApp />
    </div>
  );
}

export default App;
