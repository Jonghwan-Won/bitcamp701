import { ImageList, ImageListItem } from "@material-ui/core";
import { CloseOutlined, DeleteForeverRounded } from "@material-ui/icons";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function MyPhotoList(props) {
  const { num } = useParams(); //emp사용하기 위함

  let [photolist, setPhotolist] = useState([]); //배열타입으로 선언

  // .env의 환경변수를 사용하려면 앞에 process.env. 붙여준다
  const COOMON_URL = process.env.REACT_APP_BACK_URL;

  //로컬 스토리지에 저장하는 법 -> 계속 const COOMON_URL 선언하기 귀찮아서
  //맨 처음에 list조회하면 localStorage에 저장됨
  localStorage.url = COOMON_URL;

  //전체 목록 출력하는 함수
  const list = () => {
    console.log("list 호출");

    let listUrl = COOMON_URL + "/myphoto/list"; //COOMONURL 활용
    // let listUrl = "http://localhost:9003/myphoto/list";  //직접 입력한 경우
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

  let imageUrl = COOMON_URL + "/image/";
  // let imageUrl = "http://localhost:9003/image/";

  // 삭제 함수  (num 값을 받아야돼서 이벤트는 직접 주기로함)
  const deletePhoto = (num) => {
    console.log(num);
    let deleteUrl = COOMON_URL + "/myphoto/delete?num=" + num;
    // let deleteUrl = "http://localhost:9003/myphoto/delete?num=" + num;

    axios
      .delete(deleteUrl)

      // .then : 성공하면
      .then((res) => {
        list(); //삭제 후 목록 다시 가져와 출력하기
      });
  };

  const navi = useNavigate();

  return (
    <div>
      <button
        type="button"
        className="btn btn-dark"
        onClick={() => navi("/photo/write")}
        style={{ marginLeft: "50px" }}
      >
        사진 등록
      </button>
      <h1 style={{ marginLeft: "50px" }}>MyPhotoList</h1>

      {num == "1" ? (
        // Number(emp)===1?
        <div style={{ width: "1000px", margin: "50px 50px" }}>
          <h3>출력 #1</h3>
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
                      style={{ cursor: "pointer" }}
                      onClick={() => navi(`/photo/detail/${item.num}`)} //리터럴(백틱)
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
      ) : (
        <div style={{ width: "1300px", margin: "50px 50px" }}>
          <h3>출력 #2</h3>
          <ImageList rowHeight={200} className={list.photolist} cols={5}>
            {photolist.map((item, i) => (
              <ImageListItem key={item.img} cols={item.cols || 1}>
                <div
                  style={{
                    border: "2px solid lightgray",
                    borderRadius: "10px",
                    textAlign: "center",
                    marginRight: "5px",
                  }}
                >
                  <img
                    src={imageUrl + item.photo}
                    alt={item.title}
                    style={{
                      width: "180px",
                      height: "120px",
                      cursor: "pointer",
                    }}
                    onClick={() => navi(`/photo/detail/${item.num}`)} //리터럴(백틱)
                  />
                  <span
                    style={{ color: "gray", cursor: "pointer" }}
                    onClick={() => {
                      deletePhoto(item.num);
                    }}
                  >
                    <CloseOutlined />
                  </span>
                  <br />
                  <span>{item.title}</span>
                  <br />
                  <span>{item.writeday}</span>
                </div>
              </ImageListItem>
            ))}
          </ImageList>
        </div>
      )}
    </div>
  );
}

export default MyPhotoList;
