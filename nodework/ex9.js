let [a,...b]=[1,2,3,4,5,6,7];
let [x,y,z]=[10,20,30];

console.log(a);
console.log(b);
console.log(x);
console.log(y);
console.log(z);

let [c,d,e]=[55,66];
console.log(c,d,e); //e는 undefine

let [a1,b1,c1=100]=[4,5];
console.log(a1,b1,c1);  //갯수가 안맞으면 c1은 초기값100으로 출력