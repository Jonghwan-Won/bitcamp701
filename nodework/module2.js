var calc={};
calc.mul=function(a,b){
    return a*b;
}

calc.grade=function(score){
    return score>=90?"A":score>=80?"B":score>=70?"C":
    score>=60?"D":"F";
}

module.exports=calc;

//calc 라는 객체를 포함한 함수로 선언됨