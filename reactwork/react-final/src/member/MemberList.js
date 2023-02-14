import { DeleteForeverOutlined } from "@material-ui/icons";
import axios from "axios";
import React, { useEffect, useState } from "react";

function MemberList(props) {
  const [memberlist, setMemberList] = useState([]);

  //전체 목록 출력하는 함수
  const list = () => {
    // console.log("list 호출");

    let listUrl = localStorage.url + "/member/list";

    axios.get(listUrl).then((res) => {
      setMemberList(res.data);

      // console.log(res.data.length + " 개 목록");
    });
  };

  //처음 시작 시 list() 함수 호출 : useEffect
  useEffect(() => {
    list();
  }, []);

  //멤버 삭제 함수 (num 값을 받아야돼서 이벤트는 직접 주기로함)
  const deleteMember = (num) => {
    console.log(num);

    let deleteUrl = localStorage.url + "/member/delete?num=" + num;

    axios.delete(deleteUrl).then((res) => {
      list(); //삭제 후 목록 다시 가져와 출력하기
    });
  };

  return (
    <div style={{ margin: "30px 30px" }}>
      <h1>멤버 리스트</h1>
      <table className="table table-bordered" style={{ width: "500px" }}>
        <thead>
          <tr style={{ textAlign: "center", backgroundColor: "#ddd" }}>
            <th style={{ width: "50px" }}>번호</th>
            <th style={{ width: "200px" }}>아이디</th>
            <th style={{ width: "150px" }}>회원이름</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {memberlist.map((item, idx) => (
            <tr key={idx} style={{ textAlign: "center" }}>
              <td>{idx + 1}</td>
              <td>{item.myid}</td>
              <td>{item.myname}</td>
              <td>
                <DeleteForeverOutlined
                  style={{ cursor: "pointer", color: "red" }}
                  onClick={() => {
                    // deleteMember(item.num);
                    let ans = window.confirm("삭제하려면 [확인]을 눌러주세요");
                    if (ans) {
                      deleteMember(item.num);
                    }
                  }}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MemberList;
