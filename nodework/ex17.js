//ES6 에서 class 추가됨
//그동안은 function 이 곧 클래스를 의미했었음
class Student{
    constructor(name)   //생성자는 무조건 constructor
    {
        this.name=name;
    }
}

//클래스 생성
let s1=new Student("홍길동");
console.log(s1.name);

let s2=new Student("김길동");
console.log(s2.name);

console.log("=".repeat(50));

let Sawon=class{
    constructor(name,buseo)
    {
        this.name=name;
        this.buseo=buseo;
    }
}

//생성
let s3=new Sawon("이효리","교육부");
let s4=new Sawon("이승기","홍보부");
console.log(`${s3.name}님은 ${s3.buseo}입니다.`);
console.log(`${s4.name}님은 ${s4.buseo}입니다.`);