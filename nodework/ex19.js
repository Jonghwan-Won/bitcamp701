//클래스 상속 개념
class AA{
    constructor(){
        console.log("AA 생성자");
    }
}

//BB가 AA를 상속
class BB extends AA{

}

let b=new BB(); //BB에 생성자가 없어도 AA(부모) 생성자 자동 호출

//CC도 AA를 상속
class CC extends AA{
    constructor(){
        super();    //자바처럼 생략 안됨
        console.log("CC 생성자 호출");
    }
}

let c=new CC();