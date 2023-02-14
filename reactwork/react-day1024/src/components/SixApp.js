import { Alert } from "@material-ui/lab";
import React from "react";
import img1 from "../image2/01.png";
import img2 from "../image2/03.png";
import img3 from "../image2/06.png";
import img4 from "../image2/07.png";

function SixApp(props) {
  //import한 이미지들을 배열로 선언
  const imgdata = [img1, img2, img3, img4];

  const imageList1 = imgdata.map((imgname, idx) => (
    <img alt="" key={idx} src={imgname} width="130" />
  ));

  //반복하기 연습
  const imgArray = new Array(20); //선생님 방법 #1
  const publicimg = Array.from(Array(20).keys()); //지훈님 방법 #2

  return (
    <div>
      <Alert severity="success" style={{ fontSize: "1.5em" }}>
        map 반복문 #2
      </Alert>
      {imageList1}
      <hr />
      {/* 반복문 출력 #1 */}
      {imgdata.map((name, idx) => (
        <img key={idx} src={name} alt="" width="100" />
      ))}

      <hr />
      <h5>public 의 모든 image 출력하기 (1 - 20.jpg)</h5>
      {/* 모든 반복문 출력 #1 */}
      {[...imgArray].map((imgname, idx) => (
        <img alt="" width="70" src={`image/${idx + 1}.jpg`} key={idx} />
      ))}

      <hr />
      {/* 모든 반복문 출력 #1 - new Array 버전 */}
      {[...new Array(10)].map((imgname, idx) => (
        <img alt="" width="70" src={`image/${idx + 1}.jpg`} key={idx} />
      ))}

      <hr />
      {/* 모든 반복문 출력 #2 - 지훈님 버전 */}
      {publicimg.map((imgname2, idx2) => (
        <img
          alt={""}
          key={idx2}
          src={`image/${imgname2 + 1}.jpg`}
          width={"70"}
        />
      ))}
    </div>
  );
}

export default SixApp;
