import { ImageOutlined, ListAltOutlined } from "@material-ui/icons";
import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ImageList from "./ImageList";
import SubjectList from "./SubjectList";

function BoardList(props) {
  const navi = useNavigate();
  const [show, setShow] = useState(1);

  const { currentPage } = useParams();
  console.log("currentPage=" + currentPage);

  return (
    <div>
      {sessionStorage.loginok != null ? (
        <div>
          <button
            type="button"
            className="btn btn-outline-success"
            onClick={() => {
              navi("/board/form"); //글쓰기 폼으로 이동
            }}
          >
            글쓰기
          </button>
        </div>
      ) : (
        <></>
      )}

      <br />
      <br />
      <div style={{ marginLeft: "200px" }}>
        <ListAltOutlined
          style={{
            fontSize: "2em",
            color: show === 1 ? "red" : "gray",
            cursor: "pointer",
          }}
          onClick={() => {
            setShow(1);
          }}
        />
        <ImageOutlined
          style={{
            fontSize: "2em",
            color: show === 2 ? "red" : "gray",
            cursor: "pointer",
          }}
          onClick={() => {
            setShow(2);
          }}
        />
      </div>
      <br />
      <br />
      {show === 1 ? (
        <SubjectList currentPage={currentPage == null ? 1 : currentPage} />
      ) : (
        <ImageList />
      )}
    </div>
  );
}

export default BoardList;
