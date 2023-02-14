import React from "react";
import { useLocation, useSearchParams } from "react-router-dom";

function useQuery() {
  return new URLSearchParams(useLocation().search);
}
//url의 쿼리스트링값을 얻는 두가지 방법
//useParams 처럼 라우트에 등록 안해도된다

function QueryComp(props) {
  let query = useQuery();
  const [query2, setQuery2] = useSearchParams();

  const color = query.get("color");
  const name = query.get("name");
  const addr = query.get("addr");

  return (
    <div style={{ color }}>
      useLocation().search={useLocation().search}
      <h1>Name:{query2.get("name")}</h1>
      <h1>Addr:{query2.get("addr")}</h1>
      <hr />
      <h3>이름:{name}</h3>
      <h3>주소:{addr}</h3>
    </div>
  );
}

export default QueryComp;
