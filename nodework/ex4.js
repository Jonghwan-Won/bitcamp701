/*
    ES6 는 ECMA에서 2015년에 채택한 자바스크립트 표준입니다. (에크마 스크립트6)
    ES6 에서 추가된 기능
        1. 블록범위 변수 let와 const
        2. 함수에서 기본 매개변수
        3. 템플릿 리터럴(Multiline Literal)
        4. 화살표 함수
        5. 프로미스 (Promise)
        6. 클래스, 상속 등등
        7. 모듈개념 추가
*/

//let : 영역형 변수
//var : 함수형 변수

var a=10;   //새로 생성
let b=20;   //새로 생성
console.log(a+","+b);   //10,20

if(true){
    var a=30;   //외부 변수 a에 덮어씌워짐
    let b=40;   //새로 생성
    console.log(a+","+b);   //30,40
}

console.log(a+","+b);   //30,20