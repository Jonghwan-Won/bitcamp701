let a1="apple\nbanana\norange";
console.log(a1);

let a2=`apple
banana
orange
manggo`;
console.log(a2);

//a2에 'apple'이 포함되어있느냐
console.log(a2.includes("apple"));  //true

//a2가 'kiwi'로 시작하느냐
console.log(a2.startsWith("kiwi")); //false
console.log(a2.startsWith("apple")); //true

//manggo로 끝나느냐
console.log(a2.endsWith("manggo")); //true

let name="이효리";
let birth=1978;
let food='고구마';

let msg1="내 이름은 "+name+ "이고 나이는 "+(2022-birth)+"세 이며\n";
msg1+="좋아하는 음식은 "+food+"입니다.";
console.log(msg1);

let msg2=`내 이름은 ${name}이고 나이는 ${2022-birth}세 이며
좋아하는 음식은 ${food}입니다.`;
console.log(msg2);