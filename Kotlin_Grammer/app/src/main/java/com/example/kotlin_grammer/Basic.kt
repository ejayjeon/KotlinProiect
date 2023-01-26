package com.example.kotlin_grammer

fun main() {
//    println(intType(10, 8))
//    StringTemplate()
//    score(78)
//    forwhile()
//    InterableList()
//    downto()
//    whileTest()
//    println(toUpperCase("hello My Name Is Jemma"))
//    elvis("Jeon")
//    letFun("jemma@gmail.com")
    // class : Java 와는 달리 new 쓸 필요 없음
//    val Human = Human(30)
//    Human.isName("Jemma")
//    println(Human.age)
//    Student("Jemma")
// 1-1. Void 함수
fun voidType() : Unit {
    println("void Type")
}

// 1-2. 반환형이 있는 함수 : fun 변수명 (파라미터) : 리턴타입 {}
fun intType(a : Int, b : Int) : Int {
    return a + b
}

// 2. val vs var
fun test1 () {
    val a : Int = 10
//    a = 12 -> 이 경우에는 에러
    var b : Int = 10
//    b = 12 -> 변수는 재선언이 가능하다
}

// 3. String template
fun StringTemplate() {
    val name : String = "Jemma"
    val age = "30"
    println("my name is ${name} and my age is ${age}")

    // $표시를 쓰고싶다 ? escape
    println("\$300")
}

// 4. 조건식
// 4-1. 두 수 중에 어떤 수가 더 큰지? 일반
fun maxBy(a : Int, b : Int) : Int {
    if(a > b) {
        return a
    } else {
        return b
    }
}

// 4-2. 두 수 중에 어떤 수가 더 큰지? 삼항 연산자 대신 간단하게
fun maxBy2(a : Int, b: Int) : Int = if(a > b) a else b


// 4-3. case when
fun caseWhen (score : Int) {
    when(score) {
        0 -> println("0")
        1 -> println("1")
        2,3 -> println("2, 3")
//        else -> println("nothing") -> else가 없어도 된다
    }

    // 변수에 담고 싶을 때? else를 무조건 써준다 : expression으로 사용됨
    var b : Unit = when(score) {
        0 -> println("0")
        1 -> println("1")
        2,3 -> println("2, 3")
        else -> println("nothing")
    }
}

fun score (score: Int) : Unit {
    when(score) {
        in 91..100 -> println(100)
        in 81..90 -> println(90)
        in 70..80 -> println(80)
        else -> println(0)
    }
}

// Expression vs Statement
// when ? 받은 값을 실행하도록 하는 구문 -> Statement
// a + b ? 받은 값을 가공해서 값으로 받는 구문 -> Expression
// 하지만 코틀린의 모든 식은 Expression -> when으로 받은 구문 조차 Unit을 리턴하기 때문


// 5. Array vs. List
// 5-1. Array : 정해진 길이, 할당된 길이가 있음

fun arr () {
    // array 만드는 법 - 초기화
    val arr : Array<Int> = arrayOf(1, 2, 3)
    val arr2 = arrayOf(1, "a", 1.1) // 타입이 comparable

    arr[0] = 4 // array의 경우 인덱스를 사용하여 내용을 변경하는 것이 가능하다

}
// 5-2. List : List, MutableList
fun list () {
    val list : List<Int> = listOf(1, 2, 3)

    // List : 값을 변경할 수 없는 읽기전용
//    list[0] = 3 -> 불가능, list는 인터페이스.
    var listval = list.get(0) // 가능. get 메소드로 리스트를 가져올 수 만 있음


    // Mutablelist : 값을 변경할 수 있는 리스트, add, remove, set 모두 가능
    // Mutablelist 중 대표적인 것이 바로 Arraylist

    val arrList : ArrayList<Int> = arrayListOf()
    arrList.add(10)
    arrList.add(20)
    arrList.set(0, 30)
}

// 6. 반복문 : for / while

fun forwhile() {
    val students : ArrayList<String> = arrayListOf("Jemma", "James", "Selly")

    for (name: String in students) {
        println("학생 이름: $name")
    }
}

fun InterableList() {
    // 1부터 10까지 모든 숫자가 다 나옴
    var sum: Int = 0
//    for(i : Int in 1..10) {
//        sum += i
//    }

    // 1..100 Vs 1 until 100
    // 1 until 100은 100이 포함되지 않는다 즉 1..99
    for(i : Int in 1 until 100) {
        sum += i
    }
    println(sum)
}

fun downto() {
    // 반대로 10, 9, 8, 7 ... 1
    for (i in 10 downTo 1) {
        println(i)
    }
}

fun whileTest() {
    var index = 0
    while(index < 10) {
        println("current Index: $index")
        index++
    }
}

// 7 NonNull vs. Nullable
// Null pointer Exception : 컴파일 시점에서는 잡을 수 없고 런타임 시점에서만 잡을 수 있다
// 코틀린에서는 컴파일 시점에서 null을 찾을 수 있게 ? 을 쓸 수 있다

fun nullcheck() {
    var name : String = "Jemma" // null을 넣을 수 없음
    var nullName : String? = null // nullable
}

fun toUpperCase(name: String?) : String {
    // Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    return name!!.uppercase() // null이면 uppercase를 사용할 수 없기 때문에, !!를 사용해서 null이 아님을 보증
}

// 7-2. 엘비스 연산자 ?:
// 삼항연산자를 생각하면 됨. ? 아니면 : 로 대신하라
fun elvis (lastName: String?) {
    val name : String = "Jemma"
//    val lastName : String? = null
    val fullName = name + (lastName?: "No Last Name")
    println(fullName)
}

// 7-3. !! Null이 아니라는 걸 보증할게
// 확실하지 않은이상 쓰는 걸 지양하기

fun ignoreNull (str : String?) {
    val notnull : String = str!! // 절대로 null이 아니야
    notnull.uppercase()
}


// 8. let
// let : 자신의 receiver 객체를 람다식 내부로 옮겨서 실행하는 구문
// let 구문을 사용하면 receiver 객체를 it으로 받을 수 있다
fun letFun (email: String?) {
//    val email : String? = "jemma@gmail.com"
    // 여기서는 email 객체를 람다식 내부로 옮겨줌.
    email?.let{
//        println("my Email is $email")
        print("my Email is $it")
    }
}

// 9. class
// Java와 다른점 : 클래스 이름이랑 파일 이름이랑 달라도 됨
// 여러 클래스를 한 파일안에서 생성할 수 있음
// 기본적으로 class는 final : 상속을 하기 위해서는 open 해 주어야 한다.
// constructor 생략 가능
// 생성자로 들어갈 값을 파라미터에서 초기화 가능함, Default 값
open class Human constructor(val age: Int = 25) {
    fun isName(name: String) {
        println("my name is $name")
    }

    // 생성자(Constructor) 이용하기
//    val age = age

    open fun Sing() {
        print("lalala~~")
    }
}


// 10. Constructor : 부 생성자 만들기

class Student (val name: String = "") {

    init {}
    val ban : Int = 3
    // 부 생성자는 상위 클래스의 위임을 this로 받아와야 한다.
    constructor(name: String, ban: Int) : this(name) {
        println("학생 ${name}의 반은 ${ban}입니다")
    }

}

// 11. 상속
// 기본적으로 모든 class는 final 클래스이기 떄문에, 상속을 하기 위해서는 상속할 부모 클래스를
// open 해 주어야 한다. 상속은 한 개 밖에 할 수 없다
class Korean : Human() {
    // override : 클래스와 마찬가지로 final 객체이기 때문에 오버라이드 받을 객체를 open 해주어야 한다
    override fun Sing() {
        super.Sing()
        print("라라라")
    }
}
}