import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import noimage from "../image/noimage.png";

function FoodRowItem(props) {
  const { row, idx } = props;
  const [photo, setPhoto] = useState("");
  const navi = useNavigate();

  console.log(row.fphoto.split(",")[0]); // ,로 연결된 사진 중 첫번째만 얻기

  // 처음 시작 시 , 로 된 사진이름에서 첫번째만 얻기
  useEffect(() => {
    setPhoto(row.fphoto.split(",")[0]);
  }, []);

  let photoUrl = localStorage.url + "/image";

  return (
    <tr>
      <td>{idx + 1}</td>
      <td>
        <b
          style={{ cursor: "pointer" }}
          onClick={() => navi(`/food/detail/${row.num}`)}
        >
          {row.fname}
        </b>
      </td>
      <td>
        {row.fphoto === "no" ? (
          <img alt="" src={noimage} width="100" height="100" />
        ) : (
          <img alt="" src={`${photoUrl}/${photo}`} width="100" height="100" />
        )}
      </td>
      <td>{row.bookingday}</td>
    </tr>
  );
}

export default FoodRowItem;
