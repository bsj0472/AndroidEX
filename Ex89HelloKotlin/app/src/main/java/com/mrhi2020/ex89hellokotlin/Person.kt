package com.mrhi2020.ex89hellokotlin

//주 생성자에 var키워드로 property를 직접 생성
open class Person constructor(var name:String, var age:Int){
    init {
        println("create Person instance")
    }

    open fun show(){
        println("name: $name   age: $age")
    }
}