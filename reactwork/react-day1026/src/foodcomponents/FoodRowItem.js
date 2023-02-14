import React from "react";

function FoodRowItem(props) {
  const { menu, idx, onDelete } = props; //props로부터 onDelete도 받기

  //삭제 이벤트
  const deleteEvent = () => {
    onDelete(idx);
  };

  return (
    <tr>
      <td>{idx + 1}</td>
      <td style={{ textAlign: "left" }}>
        <img
          alt=""
          className="foodphoto"
          src={require(`../food/${menu.foodphoto}`)}
        />
        <b>{menu.foodname}</b>
      </td>
      <td>{menu.foodcount}개</td>
      <td>{menu.foodprice}원</td>
      <td>{menu.foodprice * menu.foodcount}원</td>
      <td>
        <button
          type="button"
          className="btn btn-outline-danger btn-sm"
          onClick={deleteEvent}
        >
          삭제
        </button>
      </td>
    </tr>
  );
}

export default FoodRowItem;
