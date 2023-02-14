import { Button } from "@material-ui/core";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function BoardSelect() {
  const { num } = useParams();
  console.log("BoardSelect num=" + num);
  const navi = useNavigate();
  const [selectData, setSelectData] = useState("");

  const onSelectData = (num) => {
    let url = localStorage.url + "/board/select?num=" + num;
    axios.get(url).then((res) => {
      console.log(res.data);
      setSelectData(res.data);
    });
  };
  useEffect(() => {
    console.log("BoardSelect useEffect");
    onSelectData(num);
  }, []);

  const photoUrl = localStorage.url + "/image/";

  return (
    <div>
      <table style={{ width: "500px" }} className="table">
        <caption align="top">
          <h3>
            <b>{selectData.subject}</b>
          </h3>
        </caption>
        <tbody>
          <tr>
            <td>
              <h5 style={{ fontFamily: "Gamja Flower" }}>
                작성자 : {selectData.myname}(
                {selectData.myid && selectData.myid.substring(0, 3)}***)
              </h5>
              <span style={{ color: "gray", fontSize: "14px" }}>
                {selectData.writeday}
                &nbsp;&nbsp;&nbsp;&nbsp; 조회 : {selectData.readcount}
              </span>
            </td>
          </tr>
          <tr>
            <td>
              <img
                alt=""
                src={photoUrl + selectData.photo}
                style={{ maxWidth: "300px", border: "3px groove gray" }}
              />
              <br />
              <br />
              <pre
                style={{
                  fontFamily: "Gamja Flower",
                  fontWeight: "bold",
                  fontSize: "20px",
                }}
              >
                {selectData.content}
              </pre>
            </td>
          </tr>
          <tr>
            <td>
              <Button variant="outlined" onClick={() => navi("/board/list")}>
                목록
              </Button>
              <Button variant="outlined" onClick={() => navi("/board/form")}>
                글쓰기
              </Button>
              {sessionStorage.loginok != null &&
              sessionStorage.myid === selectData.myid ? (
                <>
                  <Button variant="outlined">수정</Button>
                  <Button variant="outlined">삭제</Button>
                </>
              ) : (
                ""
              )}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default BoardSelect;
