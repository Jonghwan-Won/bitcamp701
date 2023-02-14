//json 에 대한 함수
let jdata={
    "name":"lee",
    "age":12,
    "addr":"seoul"
};

console.log(typeof(jdata)); //object
console.log("json 데이터 출력");
console.log("Name:"+jdata.name);
console.log("Age:"+jdata.age);
console.log("Addr:"+jdata.addr);

//json 데이터를 문자열로 변환
let s=JSON.stringify(jdata);    //json -> string
console.log(typeof(s)); //string
console.log(s); //{"name":"lee","age":12,"addr":"seoul"}

//string(json 형식)을 json 데이터로 변환
let jdata2=JSON.parse(s);
console.log("json 데이터 출력");
console.log("Name:"+jdata2.name);
console.log("Age:"+jdata2.age);
console.log("Addr:"+jdata2.addr);