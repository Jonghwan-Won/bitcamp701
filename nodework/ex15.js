//컬렉션 set : 중복허용안함, 비순차적
let set1=new Set("abcdabcdabcd");
console.log("set1의 갯수: "+set1.size);

set1.add(12);   //추가
console.log("set1의 갯수: "+set1.size);
console.log(...set1);   //펼침 연산자 -> a b c d 12

set1.delete(12);    //삭제
console.log("set1의 갯수: "+set1.size);
console.log(...set1);   //펼침 연산자 -> a b c d

set1.clear();   //모두 삭제
console.log(set1.size); // 0

console.log('*'.repeat(30));

//Map-key, value 형태로 저장
let map1=new Map();
let a={n:1};

map1.set(a,"A");    //key:json 형태, value:"A"
map1.set("2",9);
map1.set("name","김태희");
console.log(map1.size);
console.log(...map1);

map1.set("name","이효리");  //기존 name값을 덮어쓴다
console.log(...map1);
console.log(map1.has("2")); //"2"라는 key값이 포함되어있느냐? //true

map1.delete("name");    //key name 삭제
console.log(...map1);

map1.clear(); //전체삭제
console.log(map1.size); //0