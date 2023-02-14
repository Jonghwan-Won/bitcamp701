//js에서 모듈 사용하기 (module1, module2)
/*
    하나의 함수에서 모든 기능을 넣는것보다 기능별로 여러개의 함수로 만들어두면
    필요한 함수만 가져다 사용할 수 있고, 다른곳에서도 재사용할 수 있어서 효율적이다.
*/

//모듈의 장점은 재사용이 가능하다는것이다
//리액트에서는 이것을 컴포넌트라고 한다

var m1=require('./module1');    //exports 해놔야 다른곳에서 require로 가져올 수 있음
console.log("모듈1의 함수 호출 : "+m1.add(7,8)); 
var age=19;
console.log("%d 세는 %s 입니다.",age,m1.check(age));


var m2=require('./module2');
console.log("모듈2의 함수 호출 : "+m2.mul(6,7));
var score=98;
console.log("%d점은 %s학점입니다.",score,m2.grade(score));