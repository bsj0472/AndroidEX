package com.mrhi2020.ex89hellokotlin

//무조건 main함수 필요
fun main(){
    println("Hello Kotlin OOP\n")

    //1. 클래스의 선언 및 객체 생성
    //객체 생성 [ 특이한 점 : new 키워드 없음 ]
    var obj= MyClass()
    obj.show()

    //1-1. 별도의 .kt 문서에 class만들기
    var obj2:MyKotlinClass = MyKotlinClass()
    obj2.show()

    //2. 생성자 [ 많이 당황스러울 수도 있음 ]
    //코틀린의 생성자는 2종류가 있음, [주 생성자, 보조 생성자]
    //2-1. 주생성자
    var s= Simple()

    //2-2. 주생성자에 값 전달 [ 주생성자는 오버로딩이 불가함 ]
    var s2= Simple2(100, 200)
    s2.show()

    //2-3. 보조생성자 [ 오버로딩을 하고자 만들어진 보조 생성자 ]
    var s3= Simple3()
    var s4= Simple3(300)

    //2-4. 주생성자와 보조생성자 동시 사용
    var s5= Simple4()  //주생성자 호출
    var s6= Simple4("450") //overloading 보조생성자 호출

    //2-5. 주생성자의 constructor 키워드 생략가능
    var s7= Simple5(500)
    println( s7.num )


}

//2. 생성자 테스트
//2-1. 주 생성자 [class명 옆에 constructor()키워드로 정의]
class Simple constructor(){
    //근데 생성자가 별도의 메소드형태가 아니어서..
    //코드작성할 곳이 없음.
    //그래서 존재하는 초기화 블럭 키워드
    init{
        println("Simple primary constructor")
        println()
    }
}

//2-2. 주 생성자에 파라미터 전달
//아주 특이하게 주 생성자의 파라미터를 만들때 var, val을 사용하면
//곧바로 클래스의 프로퍼티(멤버변수)가 됨
class Simple2 constructor(var num:Int, num2:Int){
    //var키워드가 있는 num변수는 이미 멤버변수(property)임
    //num2는 var키워드가 없기에 생성자함수의 매개변수임- 멤버변수 아님
    fun show(){
        println("프로퍼티 num : $num" )
        //println("num2 : $num2")//ERROR
        println()
    }
}

//2-3. 보조생성자 [ 오버로딩을 하고자 만들어진 보조 생성자 ]
// 다른 언어처럼 클래스의 {}안에 생성자를 선언
class Simple3{
    //초기화 블럭은 보조생성자때도 역시 발동함
    init {
        println("이 영역은 항상 객체생성시 초기화를 위해 처음에 실행됨")
    }

    //보조 생성자
    constructor(){
        println("Simple3 secondary 생성자")
        println()
    }

    //보조 생성자는 Overloading 이 가능함
    //보조생성자 파라미터에 var 키워드로 프로퍼티를 직접 만드는 작업이 불가함
    constructor(num: Int){
        println("Simple3 Overloading secondary 생성자 : $num ")
        println()
    }
}

//2-4. 주 생성자와 보조 생성자를 동시에 사용 [주 생성자를 오버로딩하는 목적으로]
class Simple4 constructor(){
    init {
        println("Simple4 init")
    }

    //보조생성자 추가 -  overloading
    //[# 중요 # ] 주생성자와 함께 사용하때는 반드시 주생성자를 보조생성자에서 호출해야함
    //[보조생성자 명 뒤에 : this() ]
    constructor(num:String) :this(){
        println("Simple4 secondary constructor!!")
        println()
    }

}

//2-5. 참고로 constructor 키워드를 생략한 주 생성자 가능함 - 자주 사용하지는 않음
class Simple5(var num:Int){ //멤버변수 num을 가지는
}





//1. 클래스 선언
class MyClass{
    //멤버변수[Property:프로퍼티]- 반드시 초기화 필요
    var a:Int=10

    //메소드 : Method
    fun show(){
        println("show : $a ")
        println()
    }
}