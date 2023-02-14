//객체 할당
let obj1={"name":"lee","age":23,"addr":"seoul"};

console.log(obj1.name);
console.log(obj1.age);
console.log(obj1.addr);

//오브젝트 통으로 대입
let obj2=obj1;
console.log(obj2.name);

//객체에서 멤버값을 각각 얻으려면
let name1=obj1.name;
let age1=obj1.age;
let addr1=obj1.addr;

console.log(name1,age1,addr1);

//ES6문법
//주의할 점 : 변수명은 반드시 멤버명과 같아야한다
let {name,age}=obj1; //obj1 객체에서 name,age 값 만 얻겠다
console.log(name,age);

//함수에서 매개변수를 객체타입으로 받는데, 초기값을 지정하고자 할 경우
func1=f1({name='수지',age=20}={});
{
    console.log("이름: "+name+", 나이: "+age);
}

f1();   //수지, 20
f1(obj1.name);  //수지, 20
f1(obj1);   //lee 23