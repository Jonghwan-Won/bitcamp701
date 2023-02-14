//const : 상수
const PI=3.141592;  //상수 선언
let r=3;    //반지름

let area=r*r*PI;

console.log("반지름이 %d인 원의 넓이 : %f",r,area); 
//PI=3.5555;//에러 발생, 값 변경 안됨


//객체선언 시 const 로 선언(값 변경 X)
const pp={
    "name":"홍길동",
    "addr":"서울"
}

console.log("이름:"+pp.name);
console.log("주소:"+pp.addr);

//값 변경해보고 다시 출력하기
pp.name="이진";
console.log("이름:"+pp.name);

pp={
    "name":"김상준",
    "addr":"미국"
}   //객체 전체 변경 시 오류발생

//객체 전체를 변경하는건 안됨