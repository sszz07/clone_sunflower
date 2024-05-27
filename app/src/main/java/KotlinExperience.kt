//package com.example.sunflower
//
//class KotlinExperience {
//
//
//}
//
//
////1.함수
////무엇을 리턴하든 fun을 작성한다
////Unit은 void형식이다
////리턴 타입 없으면 생략이 가능하다
//fun main() {
////    println(hellowWorld(1, 2))
////    checkNum(90)
//
//    forwhile()
//}
//
//
//fun hellowWorld(a: Int, b: Int): Int {
//    return a + b
//}
//
////2. val vs var
////val은 값 즉 상수값 변하지 않는 값이다
////var은 변할수 있는 값
//fun 변수() {
////    val a: Int = 20
////    a = 30
//////    var b:Int = 10
////    var c = 20
//}
//
////3. String 템플릿
//fun String템플릿() {
//    val answer = "kim"
//
//    //변수를 사용하고 싶으면 달러 표시를 해주면 된다
//    println("my name is $answer")
//}
//
////4, 조건식
//fun 조건식(a: Int, b: Int): Int {
//    if (a > b) {
//        return a
//    } else {
//        return b
//    }
//}
//
////실제로 많이 사용하는 방식
////실제로 삼항연산자를 많이 사용한다
//fun 조건식다른방식(a: Int, b: Int): Int = if (a > b) a else b
//
////when도 많이 사용함
//fun checkNum(score: Int) {
//    when (score) {
//        0 -> print("this is 0")
//        1 -> print("this is 1")
//        2 -> print("this is 2")
//        3, 4 -> print("this is 3,4")
//        else -> print("값이 없음")
//    }
//
//    //else가 없으면 기본적으로 에러가 생김
//    var b: Int = when (score) {
//        1 -> 1
//        2 -> 2
//        else -> 3
//    }
//
//    when (score) {
//        in 90..100 -> print("good")
//        in 80..90 -> print("not bad")
//    }
//}
//
////5.ArrayList vs List
////Array
////List 1.List 2.MutableList
//fun array() {
//    val array = arrayOf(1, 2, 3)
//    val list = listOf(1, 2, 3)
//
//    //애니 타입으로 지정이 됨 애니는 대략 모든 변수를 따로 설정을 안해도 된다는 의미
//    val array2 = arrayOf("1", "2", 10)
//    val list2 = listOf(1, "d", 11L)
//    array[0] = 3
//
//    //List는 읽기 전용임 MutableList은 읽기와 쓰기 둘다 됨
//    //List
//    var result = list.get(0)
//
//    var arralist = arrayListOf<Int>()
//    arralist.add(1)
//    arralist.add(2)
//    arralist.add(3)
//}
//
////6.for / while
//
//fun forwhile() {
//    val student = arrayListOf("kim", "park", "jack")
//
//    for (name: String in student) {
//        println("$name")
//    }
//
//    var sum = 0
//    //step은 2칸씩 띄워라
//    //downTo 10부터 내려간다
//    //i in 1 until 100 100은 제외하고 99까지 해라
//    for (i in 1..10 step 2) {
//        sum += i
//    }
//    print(sum)
//
//    for ((Index: Int, name: String) in student.withIndex()) {
//        print("${Index + 1}번째 학생:{$name}")
//    }
//}
//
////7. Nullable / NonNull
//fun nullcheck() {
//    var name: String? = null
//    println(name)
//}
//
//
//fun lam(){
//    //1.람다식은 마치 값 처럼 쓸수 있는 익명함수이다
//    //1)메소드의 파라미터로 넘겨줄수가 있다 fun maxBy(a:Int)
//    //2)return 값으로 사용할 수가 있다
//
//    //람다의 기본정의
//    //val lamdaName : Type = {argumentList-> codebody}
//
//    //말로 풀어보자
//    //val로 변수명은 lam이다 들어오는 값은 int이고 나온느값은 int이다
//    //number로 변환을 해주고 결과값은 number 곱해줘
//    val lam :(Int)->(Int) ={number -> number*number}
//    println(lam(10))
//
//    val lam2 = {number:Int -> number/number}
//    println(lam2(2))
//
//}
//
//
////코틀린은 기본적으로 기본값을 제공해주지 않는다 그래서 항상 널어블을 해줘야 하는데 ?를 자료형 오른쪽에 넣으면 널값을 허용해주는 npe가 적용이 된다
////그런데 엘비스널 이라는게 있는데 널이면 뭐 널이 아니면 뭐 값을 지정해주는것도 있다
////!!는 널이 절때 아니다
//
//
//
//
