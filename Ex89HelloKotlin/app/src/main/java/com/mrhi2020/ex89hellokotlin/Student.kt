package com.mrhi2020.ex89hellokotlin

open class Student constructor(name:String, age:Int, var major:String): Person(name, age) {
    init {
        println("create Student instance")
    }

    //override 키워드를 붙이면 자동 open method로 지정됨
    override fun show() {
        //super.show()
        println("name: $name   age: $age   major: $major")
    }
}