//var : 함수형 변수
//let : 영역형 변수

var a=1;    //새로 생성
let b=2;    //새로 생성

function myFunc(){
    var a=3;    //외부의 a와 전혀 다른 변수임 (새로 생성)
    let b=4;    //새로 생성


    if(true){
        var a=5;    //myFunc 의 a에 덮어 쓰기
        let b=6;    //새로 생성


        console.log("a=%d, b=%d",a,b);  //5,6
    }

    console.log("a=%d, b=%d",a,b);  //5,4
}

//출력하기위한 함수myFunc 호출
myFunc();

console.log("a=%d, b=%d",a,b);  //1,2