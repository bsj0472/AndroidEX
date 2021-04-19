package com.mrhi2020.ex89hellokotlin

//name,age,major는 상속받았기에 주생성자의 파라미터 만들때 var키워드 또 쓰면 안됨
//constructor 키워드 생략 가능
class AlbaStudent(name:String, age:Int, major:String, var task:String): Student(name, age, major){
    init {
        println("create AlbaStudent instance")
    }

    override fun show() {
        //super.show()
        println("name: $name  age: $age  major: $major  task: $task")
    }
}