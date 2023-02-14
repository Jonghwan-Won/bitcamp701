exports.add=function(a,b){
    return a+b;
}

//add라는 함수명
//exports를 붙이면 다른곳에서 이걸 쓸 수 있음

exports.check=function(age){
    if(age>=20)
        return "성인";
    else
        return "미성년자";
}