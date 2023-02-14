// import {} from "@material-ui/core";
// import axios from "axios";
// import React, { useEffect, useState } from "react";
// import { useNavigate } from "react-router-dom";
// import noimage from "../image/noimage.png";

// function ImageList({ currentPage }) {
//   //사진이 없을 경우 이벤트
//   const onErrorImg = (e) => {
//     e.target.src = noimage;
//   };

//   const navi = useNavigate();
//   const [data, setData] = useState("");

//   const photoUrl = localStorage.url + "/image/";

//   const getImageList = () => {
//     let url = localStorage.url + "/board/imagelist";

//     axios.get(url).then((res) => {
//       setData(res.data);
//     });
//   };

//   useEffect(() => {
//     getImageList();
//   }, []); //currentPage값이 변경될때마다 함수를 다시 호출

//   return (
//     <div>
//       <h1 className="alert alert-secondary">이미지 위주 게시판 목록</h1>

//       <div
//         style={{
//           display: "flex",
//           flexWrap: "wrap",
//           justifyContent: "flex-start",
//           // justifyContent: "center",
//         }}
//       >
//         {data &&
//           data.map((item, idx) => (
//             <div
//               className="card"
//               style={{
//                 width: "200px",
//                 height: "240px",
//                 textAlign: "center",
//                 marginRight: "50px",
//                 marginBottom: "20px",
//                 borderRadius: "10px",
//               }}
//               key={idx}
//             >
//               <img
//                 alt=""
//                 src={photoUrl + item.photo}
//                 onError={onErrorImg}
//                 style={{
//                   width: "198px",
//                   height: "160px",
//                   borderRadius: "10px",
//                   cursor: "pointer",
//                 }}
//               />
//               <br />
//               <b>{item.subject}</b>
//               {/* <b>{item.myname}</b> */}
//               <b>{item.writeday.substring(0, 10)}</b>
//             </div>
//           ))}
//       </div>
//     </div>
//   );
// }

// export default ImageList;

import { Button } from "@material-ui/core";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import { styled } from "@mui/material/styles";
import Dialog from "@mui/material/Dialog";
import DialogTitle from "@mui/material/DialogTitle";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import IconButton from "@mui/material/IconButton";
import CloseIcon from "@mui/icons-material/Close";
import Typography from "@mui/material/Typography";

//다이얼로그에 필요한 코드들
const BootstrapDialog = styled(Dialog)(({ theme }) => ({
  "& .MuiDialogContent-root": {
    padding: theme.spacing(2),
  },
  "& .MuiDialogActions-root": {
    padding: theme.spacing(1),
  },
}));

export interface DialogTitleProps {
  id: string;
  children?: React.ReactNode;
  onClose: () => void;
}

function BootstrapDialogTitle(props: DialogTitleProps) {
  const { children, onClose, ...other } = props;

  return (
    <DialogTitle sx={{ m: 0, p: 2 }} {...other}>
      {children}
      {onClose ? (
        <IconButton
          aria-label="close"
          onClick={onClose}
          sx={{
            position: "absolute",
            right: 8,
            top: 8,
            color: (theme) => theme.palette.grey[500],
          }}
        >
          <CloseIcon />
        </IconButton>
      ) : null}
    </DialogTitle>
  );
}

function ImageList(props) {
  const navi = useNavigate();
  const [list, setList] = useState([]);
  //클릭시 다이얼로그 띄울때 필요한 데이타
  const [selectData, setSelectData] = useState("");
  const [open, setOpen] = React.useState(false);

  const photoUrl = localStorage.url + "/image/";

  const getImageList = () => {
    let url = localStorage.url + "/board/imagelist";

    axios.get(url).then((res) => {
      setList(res.data);
    });
  };

  const onSelectData = (num) => {
    let url = localStorage.url + "/board/select?num=" + num;
    axios.get(url).then((res) => {
      setSelectData(res.data);
    });
  };
  useEffect(() => {
    getImageList();
  }, []);

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <h4 className="alert alert-danger" style={{ width: "630px" }}>
        총 {list.length} 개의 게시글이 있습니다
      </h4>
      {list &&
        list.map((row, idx) => (
          <>
            {idx % 4 === 0 ? (
              <hr style={{ clear: "both", width: "620px" }} />
            ) : (
              ""
            )}
            <figure
              style={{ float: "left", marginBottom: "10px", cursor: "pointer" }}
            >
              <img
                alt=""
                className="largephoto"
                src={photoUrl + row.photo}
                onClick={() => {
                  setOpen(true);
                  onSelectData(row.num);
                }}
              />
              <figcaption style={{ textAlign: "center", fontSize: "15px" }}>
                <b>{row.subject}</b>
                <br />
                <b style={{ color: "gray" }}>{row.myname}</b>
              </figcaption>
            </figure>
          </>
        ))}

      {/* 다이얼로그 */}
      <BootstrapDialog
        onClose={handleClose}
        aria-labelledby="customized-dialog-title"
        open={open}
      >
        <BootstrapDialogTitle
          id="customized-dialog-title"
          onClose={handleClose}
        >
          <h4 style={{ color: "darkgreen" }}>{selectData.subject}</h4>
          <h6 style={{ fontFamily: "Gamja Flower" }}>
            작성자 : {selectData.myname}(
            {selectData.myid && selectData.myid.substring(0, 3)}***)
          </h6>
          <span style={{ color: "gray", fontSize: "12px" }}>
            {selectData.writeday}
            &nbsp;&nbsp;&nbsp;&nbsp; 조회 : {selectData.readcount}
          </span>
        </BootstrapDialogTitle>
        <DialogContent dividers>
          <Typography gutterBottom>
            <pre
              style={{
                fontFamily: "Gamja Flower",
                fontWeight: "bold",
                fontSize: "20px",
              }}
            >
              {selectData.content}
            </pre>
          </Typography>
          <Typography gutterBottom>
            <img
              alt=""
              src={photoUrl + selectData.photo}
              style={{ maxWidth: "300px", border: "3px groove orange" }}
            />
          </Typography>
        </DialogContent>
        <DialogActions>
          <Button autoFocus onClick={handleClose}>
            Close
          </Button>
        </DialogActions>
      </BootstrapDialog>
    </div>
  );
}

export default ImageList;
