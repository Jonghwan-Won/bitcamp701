import React from "react";
import './mystyle.css';
import img1 from './03.png';

const TwoApp=()=>{
    let msg="오늘은 즐거운 금요일입니다";


    //render없고 그냥 바로 return 하면 됨
    return(
        <div style={{backgroundColor:'#ffc'}}>
            <h1 style={{fontFamily:'SDSamliphopangche_Outline'}}>TwoApp 컴포넌트입니다</h1>
            <br/>
            <img alt="" src={img1}
            style={{width:'100px', height:'100px',border:'5px inset groove'}}/>
        </div>
    )
}

export default TwoApp;