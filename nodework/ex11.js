//화살표 함수
//일반 함수와의 차이점: new로 생성 안됨

let f1=function(a,b)
{
    return a+b;
}

let s1=f1(5,6);
console.log(s1);    //11

//위의 함수를 화살표 함수로 만들어보자
//리턴 한줄만 코드로 있을 경우 {} 생략, return 생략
let f2=(a,b)=>a+b;
console.log(f2(6,8));   //14

let f3=()=>console.log("ES6 어려워요!!");
f3();