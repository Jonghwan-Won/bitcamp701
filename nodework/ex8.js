//배열, ... 펼침 연산자
let arr=[3,5,7];

let f1=(a,b,c)=>{

    console.log(a,b,c);
}

//함수 호출
f1(arr[0],arr[1]);
f1(arr[0],arr[2]);
f1(...arr); //펼침 연산자를 이용해서 배열값 보내기(앞 2개의 값이 펼쳐서 넘어간다)

let arr1=[1,2];
let arr2=[33,44,55];
let arr3=[5,6,...arr1,10,20,...arr2];

console.log("arr3의 갯수: "+arr3.length);
console.log(arr3);

//배열값 합계
let sum1=0;
for(let a in arr3){
    // console.log(a); //in : index 0,1,2, ... 8

    sum1+=arr3[a];
}
console.log("sum="+sum1);

let sum2=0;
for(let a of arr3){
    // console.log(a); //a는 값

    sum2+=a;
}
console.log("sum="+sum2);