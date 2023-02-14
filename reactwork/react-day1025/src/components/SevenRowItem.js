import { DeleteForeverOutlined } from "@material-ui/icons";
import React from "react";

// // 방법 1
// function SevenRowItem(props) {
//   return (
//     <tr>
//       <td>{props.idx + 1}</td>
//       <td>{props.row.irum}</td>
//       <td>{props.row.blood}형</td>
//       <td>{props.row.today.toLocaleDateString("ko-KR")}</td>
//       <td style={{ color: "red" }}>
//         <span
//           style={{
//             float: "right",
//             color: "gray",
//             cursor: "pointer",
//           }}
//           onClick={() => props.deleteData(props.idx)}
//         >
//           <DeleteForeverOutlined />
//         </span>
//       </td>
//     </tr>
//   );
// }

// 방법 2
// function SevenRowItem(props) {
//   const { idx, row, deleteData } = props;

//   return (
//     <tr>
//       <td>{idx + 1}</td>
//       <td>{row.irum}</td>
//       <td>{row.blood}형</td>
//       <td>{row.today.toLocaleDateString("ko-KR")}</td>
//       <td style={{ color: "red" }}>
//         <span
//           style={{
//             float: "right",
//             color: "gray",
//             cursor: "pointer",
//           }}
//           onClick={() => deleteData(idx)}
//         >
//           <DeleteForeverOutlined />
//         </span>
//       </td>
//     </tr>
//   );
// }

// 방법 3
function SevenRowItem({ row, idx, deleteData }) {
  return (
    <tr>
      <td>{idx + 1}</td>
      <td>{row.irum}</td>
      <td>{row.blood}형</td>
      <td>{row.today.toLocaleDateString("ko-KR")}</td>
      <td style={{ color: "red" }}>
        <span
          style={{
            float: "right",
            color: "gray",
            cursor: "pointer",
          }}
          onClick={() => deleteData(idx)}
        >
          <DeleteForeverOutlined />
        </span>
      </td>
    </tr>
  );
}

export default SevenRowItem;
