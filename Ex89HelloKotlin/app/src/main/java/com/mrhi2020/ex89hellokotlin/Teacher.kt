package com.mrhi2020.ex89hellokotlin

import javax.security.auth.Subject

//보조 생성자를 사용하여 상속할때는 부모클래스명 옆에()를 붙이지 않음
class Teacher : Person {

    //Teacher클래스만의 property(멤버변수) : 보조생성자는 직접 프로퍼티를 만들 수 없어서
    var subject:String?= null

    //보조생성자 - 여기서 부모클래스의 생성자를 호출해 주어야 함.
    constructor(name:String, age:Int, subject: String):super(name, age){
        this.subject= subject
        println("create Teacher instance")
    }

    override fun show() {
        //super.show()
        println("name: $name   age: $age   subject: $subject")
    }
}