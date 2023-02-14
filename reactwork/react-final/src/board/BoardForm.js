import axios from "axios";
import React, { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import noimage from "../image/noimage.png";

function BoardForm(props) {
  const navi = useNavigate();

  const [subject, setSubject] = useState("");
  const [photo, setPhoto] = useState("");

  const contentRef = useRef(""); //content 는 내용이 길 수 있어서 Ref로

  const photoUrl = localStorage.url + "/image/";

  const uploadPhoto = (e) => {
    let uploadUrl = localStorage.url + "/board/upload";

    const uploadFile = new FormData();
    uploadFile.append("uploadFile", e.target.files[0]);

    axios({
      method: "post",
      url: uploadUrl,
      data: uploadFile,
      headers: { "Content-Type": "multipart/form-data" },
    }).then((res) => {
      setPhoto(res.data);
    });
  };

  const onSubmitEvent = (e) => {
    e.preventDefault();

    const myid = sessionStorage.myid;
    const myname = sessionStorage.myname;
    const content = contentRef.current.value; //state 변수가 아니라서 따로 얻어줘야됨

    let url = localStorage.url + "/board/insert";

    axios.post(url, { myid, myname, subject, content }).then((res) => {
      setSubject("");
      setPhoto("");
      contentRef.current.value = "";

      navi("/board/list");
    });
  };

  //사진이 없을 경우 이벤트
  const onErrorImg = (e) => {
    e.target.src = noimage;
  };

  return (
    <div style={{ marginLeft: "50px" }}>
      <img
        alt=""
        style={{
          position: "absolute",
          left: "620px",
          top: "140px",
          maxWidth: "300px",
        }}
        src={photoUrl + photo}
        onError={onErrorImg}
      />

      <form onSubmit={onSubmitEvent}>
        <table className="table table-bordered" style={{ width: "500px" }}>
          <caption align="top">
            <h5>게시판 글쓰기</h5>
          </caption>
          <tbody>
            <tr>
              <th style={{ width: "130px", backgroundColor: "#ddd" }}>제 목</th>
              <td>
                <input
                  type={"text"}
                  className="form-control"
                  value={subject}
                  onChange={(e) => setSubject(e.target.value)}
                  required
                />
              </td>
            </tr>

            <tr>
              <th style={{ width: "130px", backgroundColor: "#ddd" }}>사 진</th>
              <td>
                <input
                  type={"file"}
                  className="form-control"
                  required
                  onChange={uploadPhoto}
                />
              </td>
            </tr>

            <tr>
              <th style={{ width: "130px", backgroundColor: "#ddd" }}>내 용</th>
              <td>
                <textarea
                  style={{ width: "350px", height: "100px" }}
                  className="form-control"
                  ref={contentRef}
                  required
                ></textarea>
              </td>
            </tr>

            <tr>
              <td colSpan={2} align="center">
                <button type="submit" className="btn btn-secondary">
                  게시글 저장
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
}

export default BoardForm;
