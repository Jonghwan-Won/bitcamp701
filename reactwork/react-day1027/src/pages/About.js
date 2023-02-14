import React from "react";
import { useParams } from "react-router-dom";

function About(props) {
  const { emp } = useParams();
  console.log({ emp }); //emp:"bitcamp"
  console.log({ emp }.emp);
  return (
    <div>
      {emp == null ? (
        <h1>회사 퇴직</h1>
      ) : (
        <div>
          <h2>
            저희 회사 <b style={{ color: "orange" }}>{emp}</b> 를 소개합니다
          </h2>
        </div>
      )}
      <br />
      <iframe
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25325.276619810484!2d127.02928809527748!3d37.49235896588977!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca15aee9ab0cb%3A0x31793fc63e0cf9d3!2z67mE7Yq47Lqg7ZSE!5e0!3m2!1sko!2skr!4v1666847567654!5m2!1sko!2skr"
        width="600"
        height="450"
        style={{ border: 0 }}
        allowfullscreen=""
        loading="lazy"
        referrerpolicy="no-referrer-when-downgrade"
      ></iframe>
    </div>
  );
}

export default About;
