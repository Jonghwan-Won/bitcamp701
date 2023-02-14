import { ImageList } from "@material-ui/core";
import {
  DeleteForeverOutlined,
  DeleteForeverRounded,
} from "@material-ui/icons";
import { Alert } from "@material-ui/lab";
import axios from "axios";
import React, { useEffect, useState } from "react";
import MyPhotoWriteForm from "./MyPhotoWriteForm";

function MyPhotoMain(props) {
  let [photolist, setPhotolist] = useState([]); //배열타입으로 선언

  //전체 목록 출력하는 함수
  const list = () => {
    console.log("list 호출");

    let listUrl = "http://localhost:9003/myphoto/list";
    //back 에서 list호출이 getmapping 이므로 똑같이 맞춰줘야됨

    axios.get(listUrl).then((res) => {
      setPhotolist(res.data);
      //console.log(photolist.length + " 개 목록"); //비동기 관련 순서대로 진행되지않는 이슈가 있어서 아래처럼 바꿔줌
      console.log(res.data.length + " 개 목록");
    });
  };

  //처음 시작 시 list() 함수 호출 : useEffect
  useEffect(() => {
    // ,[] 있으면 처음 시작할때 한번만 호출
    // ,[] 없으면 state가 변경될때마다 호출됨
    list();
  }, []);

  //저장 함수
  const onSave = ({ title, photo }) => {
    //사진은 이미 보냈으므로 title만 받기로 했는데....중간에 변경함 (컨트롤러에서 photo관련 처리하거나 프론트에서..)

    let insertUrl = "http://localhost:9003/myphoto/insert";

    axios //위 url로 보냄
      .post(insertUrl, { title, photo })
      //key값도 title, value 값도 title 이라서 한번만 써도됨
      //같지않을떄는
      //axios.post(insertUrl, "message":{ title }); 이런 식으로 함

      .then((res) => {
        list(); //목록 다시 출력
      })

      .catch((error) => {
        console.log("데이터 추가 에러 : " + error);
      });
  };

  // 삭제 함수  (num 값을 받아야돼서 이벤트는 직접 주기로함)
  const deletePhoto = (num) => {
    console.log(num);
    let deleteUrl = "http://localhost:9003/myphoto/delete?num=" + num;

    axios
      .delete(deleteUrl)

      // .then : 성공하면
      .then((res) => {
        list(); //삭제 후 목록 다시 가져와 출력하기
      });
  };

  let imageUrl = "http://localhost:9003/image/";

  return (
    <div>
      <Alert severity="info">
        <b style={{ fontSize: "25px" }}>axios 라이브러리 공부하기 - MyPhoto</b>
      </Alert>
      <br />
      <MyPhotoWriteForm onSave={onSave} />
      {/* onSave라는 이름으로 onSave를 보냄 */}
      <hr />

      <table className="table table-bordered" style={{ width: "800px" }}>
        <thead>
          <tr>
            <th style={{ width: "50px" }}>번호</th>
            <th style={{ width: "150px" }}>사진</th>
            <th style={{ width: "150px" }}>제목</th>
            <th style={{ width: "150px" }}>등록일</th>
            <th style={{ width: "50px" }}>삭제</th>
          </tr>
        </thead>
        <tbody>
          {photolist.map((item, idx) => (
            <tr key={idx}>
              <td>{idx + 1}</td>
              <td>
                <img
                  alt=""
                  src={imageUrl + item.photo}
                  width="130"
                  height={100}
                />
              </td>
              <td>{item.title}</td>
              <td>{item.writeday}</td>
              <td>
                <span
                  style={{ color: "gray", cursor: "pointer" }}
                  onClick={() => {
                    deletePhoto(item.num);
                  }}
                >
                  <DeleteForeverRounded />
                </span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MyPhotoMain;
