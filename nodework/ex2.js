//console 객체의 속성
/*
    dir(object): 자바스크립트 객체의 속성들을 출력
    time(id): 실행시간을 측정하기 위한 시작 시간 기록
    timeEnd(id): 실행시간을 측정하기 위한 끝 시간 기록
*/
var result=0;
console.time("sum_time");
for(var i=1;i<=1000;i++){
    result+=i;
}
console.timeEnd("sum_time");
console.log("1~1000까지의 합계:"+result);
console.log("현재 실행중인 파일: %s",__filename);
console.log("현재 실행중인 파일의 경로: %s",__dirname);

var person={name:"이진", age:23, hp:"010-2222-3333"};
console.log(person);