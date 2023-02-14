// import React from "react";  //react라는 컴포넌트를 가져옴
import React,{Component} from "react";  //react라는 컴포넌트를 가져옴
import './mystyle.css';

//src의 이미지는 import 후 출력가능
import img1 from './02.png';
import img2 from './03.png';


//class 로 컴포넌트 구현해보기
// class OneApp extends React.Component
class OneApp extends Component
{
    render(){
        const imgStyle={
            borderRadius:'100px',
            border:'1px solid orange',
            width:'60px',
            height:'60px'
        }

        // 주석 1
        return(
            <div>
                {/* public 이미지는 직접 경로로 가능하지만 권장안함!! */}
                <img src="01.png" alt="사진없음"/>

                {/* import 이미지 출력하기 */}
                <img alt="" src={img1}/>
                <img alt="" src={img2} width="200" style={imgStyle}/>


                {/* 부모 엘리먼트는 한개만 return 가능 */}
                <h2 className="font1 border1">첫번째 컴포넌트 입니다</h2>

                {/* css를 직접 줄 경우 {{}} */}
                <div style={{fontFamily:'궁서체',color:'orange',width:'100px', height:'100px',
                 border:'3px solid pink'}}>Hello</div>
            </div>

        )
    }
}
// export default OneApp;   //default는 단 한번만 가능
export {OneApp} //여러번 가능(index.js 도 맞춰줘야됨)