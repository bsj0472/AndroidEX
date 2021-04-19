package com.mrhi2020.ex89hellokotlin

fun main(){
    //코틀린의 상속
    val s= Second()
    s.a= 10
    s.b= 20
    s.show()
    println()

    //상속 마무리 연습 [ Person <- Student <- AlbaStudent ], [Person <-Teacher]
    var p= Person("sam", 20)
    p.show()
    println()

    var stu= Student("robin", 25, "kotlin android")
    stu.show()
    println()

    var alba= AlbaStudent("tom", 27, "java android", "PC Management")
    alba.show()
    println()

    var t= Teacher("lee", 50, "mobile optimization")
    t.show()
    println()


}

//상속을 해줄 부모클래스는 반드시 open키워드가 추가되어야 함.
//없으면 Java에서의 final class로 인지됨
open class First{
    var a:Int=10

    //이 메소드를 상속받는 클래스에서 오버라이드 할 수 있도록 허용하기위해
    //open 키워드 필요 - 안하면 final method가 됨
    open fun show(){
        println("a : $a")
    }
}

//상속의 문법 [ 클래스명 뒤에 : 후 부모클래스명() 작성 <- 부모클래스명 뒤에 주 생성자 호출()을 주의!!]
class Second : First(){
    //Second만의 고유 멤버 추가
    var b:Int=0

    //상속받은 show()메소드의 기능을 변경
    //override - 코틀린은 오버라이드를 하려면 반드시 override 키워드 명시
    override fun show(){
        super.show()
        println("b : $b")
    }
}