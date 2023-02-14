import logo from "./logo.svg";
import "./App.css";
import FoodMainApp from "./foodcomponents/FoodMainApp";
import Root from "./context/Root";
import MyPhotoWriteForm from "./myphoto/MyPhotoWriteForm";
import MyPhotoMain from "./myphoto/MyPhotoMain";

function App() {
  return (
    <div className="App" style={{ margin: "10px 10px" }}>
      {/* <FoodMainApp /> */}
      {/* <Root /> */}
      {/* <MyPhotoWriteForm /> */}
      <MyPhotoMain />
    </div>
  );
}

export default App;
