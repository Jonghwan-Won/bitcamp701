// //함수 파라미터 기본값

// 방법 1
// function func1(x,y=100, z=200)
// {
//     console.log(x,y,z);
// }

// // 방법 2
// // 위 함수를 let으로 변경해보기 (결과는 같음)
// let func1=function(x,y=100, z=200)
// {
//     console.log(x,y,z);
// }

// 방법 3
let func1=(x,y=100,z=200)=>{
    console.log(x,y,z);
}




func1(4);   //4 100 200
func1(7,8); //7 8 200
func1(10,20,30);    //10 20 30
func1();    //undefined 100 200