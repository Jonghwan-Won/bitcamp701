import { DateRange } from "@material-ui/icons";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function SubjectList({ currentPage }) {
  const navi = useNavigate();
  const [data, setData] = useState("");

  const photoUrl = localStorage.url + "/image/";

  const getPageList = () => {
    let url = localStorage.url + "/board/pagelist?currentPage=" + currentPage;

    axios.get(url).then((res) => {
      setData(res.data);
    });
  };

  //currentPage 값이 변경될때마다 함수 다시 호출
  useEffect(() => {
    getPageList();
  }, [currentPage]);

  console.log("SubjectList=" + currentPage);
  return (
    <div>
      <h4 className="alert alert-info" style={{ width: "630px" }}>
        총 {data.totalCount} 개의 게시글이 있습니다
      </h4>
      <table className="table table-bordered board" style={{ width: "630px" }}>
        <thead>
          <tr style={{ backgroundColor: "#ddd" }}>
            <th style={{ width: "60px" }}>번호</th>
            <th style={{ width: "280px" }}>제목</th>
            <th style={{ width: "100px" }}>작성자</th>
            <th style={{ width: "60px" }}>조회</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          {data.list &&
            data.list.map((row, idx) => (
              <tr key={idx}>
                <td align="center">{data.no - idx}</td>
                <td>
                  <Link
                    to={`/board/select/${row.num}`}
                    style={{ textDecoration: "none", color: "black" }}
                  >
                    <img
                      alt=""
                      className="smallphoto"
                      src={photoUrl + row.photo}
                    />
                    {row.subject}
                  </Link>
                </td>
                <td align="center">{row.myname}</td>
                <td align="center">{row.readcount}</td>
                <td align="center">{row.writeday.substring(0, 10)}</td>
              </tr>
            ))}
        </tbody>
      </table>
      <div style={{ width: "630px", textAlign: "center" }}>
        {/* 이전으로 이동  */}
        {data.startPage > 1 ? (
          <Link to={`/board/list/${data.startPage - 1}`} className="pagenum">
            <b style={{ color: "black" }}>이전</b>
          </Link>
        ) : (
          ""
        )}
        {data.parr &&
          data.parr.map((n, i) => (
            <Link to={`/board/list/${n}`} className="pagenum">
              <b style={{ color: n == currentPage ? "red" : "black" }}>{n}</b>
            </Link>
          ))}
        {/* 다음으로 이동  */}
        {data.endPage < data.totalPage ? (
          <Link to={`/board/list/${data.endPage + 1}`} className="pagenum">
            <b style={{ color: "black" }}>다음</b>
          </Link>
        ) : (
          ""
        )}
      </div>
    </div>
  );
}

export default SubjectList;
