package com.example.kotlin_grammer

fun main() {
//println(nameage("Jemma", 30))
//    println(score(30))
//    println(pizza("고구마"))
//    println(calGrade(97))
    val ticketA = Ticket("Jemma", "2022-08-15", 13)
    // companion Object
    val book = Book.create()

    // object class : singleton pattern
    val car1 : Car = CarFactory.makeCar(10)
    val car2 : Car = CarFactory.makeCar(200)
    println(

//        invokeLamda { it > 3.22 }
//        ticketA,
        // object class =
    car1

    )
}

// 1. 람다 : value 처럼 다룰 수 있는 익명함수
// 1) 메소드에 파라미터로 넘겨줄 수 있다. fun mayBy(fun val)
// 2) return 값으로 사용할 수가 있다.
// 람다의 기본 정의
// val 이름 : Type = {argumentList -> codeBody}

val score : (Int) -> (Int) = {number : Int -> number * number}

val nameage = {name: String, age: Int -> {
    "my name is $name and I'm $age years old"
}}

// 1-2. 람다와 확장함수

val pizza : String.() -> String = {
    this + "Pizza is the best"
}

fun extendString(name: String, age: Int) : String {
    val Introduce : String.(Int) -> String = {
        // this : 확장함수를 call 하는 오브젝트
        // it : 파라미터가 하나일 경우 파라미터
        "I am ${this} and ${it} years old"
    }
    return name.Introduce(age)
}


// 1-3. 람다의 리턴
val calGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 1-4. 람다를 표현하는 여러가지 방법
// 마지막 파라미터가 람다식일 때 소괄호를 생략해줄 수 있음
fun invokeLamda (lamda : (Double) -> Boolean) : Boolean {
    return lamda(1.234)
}

// 1-5. 익명 내부함수
// 코틀린 인터페이스가 아닌 자바 인터페이스일 때, 하나의 메소드만 가져야 한다 -> 람다식 사용 가능



// 2. Data class
// Pojo class : Model이 되는 클래스 -> 이런 보일러플레이트를 줄이기 위해서 쓰는 data class
// 컨스트럭트를 따로 만들어줄 필요가 없음
data class Ticket(val name: String, val date: String, val seat: Int)


// 3. Companion Object
// 자바의 Static Method와 비슷한 것
// Factory 함수

class Book private constructor(val id: Int, val name: String) {
    // 인터페이스를 상속받을 수도 있음
    companion object BookFactory : IdProvider {
        override fun getId(): Int {
            return 123
        }
        fun create() = Book(getId(), "animal")
    }
}

interface IdProvider {
    fun getId() : Int
}

// 4. Object Class
object CarFactory {
    val Cars : MutableList<Car> = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car{
        val car = Car(horsePower)
        Cars.add(car)
        return car
    }
}
data class Car(val horsePower: Int)