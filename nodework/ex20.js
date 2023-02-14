//ES5 의 function 과 ES6 의 class 를 섞어서 구현해도 됨
function A(a){
    this.a=a;
}

//클래스 A의 멤버 메서드
A.prototype.printA=function(){
    console.log("A:"+this.a);
}

class B extends A{
    constructor(a,b){
        super(a);   //부모한테 a를 넘김
        this.b=b;
    }

    printB(){
        console.log("B:"+this.b);
    }

    static sayHello()
    {
        console.log("B:Hello");
    }
}

class C extends B{
    constructor(a,b,c)  //파라미터 3개를 받아
    {
        super(a,b); //B클래스에 a,b를 넘김
        this.c=c;
    }

    printC()
    {
        console.log("C:"+this.c);
    }

    printAll()
    {
        console.log("** 상속받는 메서드 모두 호출 **");
        this.printA();
        this.printB();
        this.printC();

        //static 도 호출
        B.sayHello();
    }
}

let c=new C(4,6,8);
c.printAll();   //변수c
C.sayHello();   //클래스C
