//package com.example.sunflower
//
////클래스 생성함
//
///*
//class Car (var name :String)와 class Car (name :String)의 차이점을 공부했다
//class Car (var name :String)는 프로퍼티함과 동시에 초기화를 설정한것
//class Car (name :String)는 프로퍼티만 한것
//주 생성자에 변수를 초기화 및 동시에 값이 할당 되어있지 않으면 보조 생성자에 this파라미터에 접근이 안됨
//
//왜 안되는걸까?
//constructor(name :String,age :Int,year:Int):this(name,age) {
//
//    }
//파라미터에 들어있는 this(name)에 있는 값이 name :String에 값이 할당 되는것이다 즉 보조 생성자는 기존에 있던 생성자에 다른 형태로 만드는 오버로딩을 한것이기에
//기존에 있던 주 생성자를 가져와야 만들어진다
//
// */
//open class Car { // 주 생성자를 만듬
//    //자바 처럼 인스턴스 변수 설정이 안되는구나
//    //무조건 초기화 설정을 해줘야 되는구나
//
//
//    //보조 생성자
//    constructor(name :String,age :Int) {
//
//    }
//
//    /*
//    * 초기화 블록 특징은 코드 실행시 가장 먼저 실행이 되면서 주 생성자의 매개변수를 사용할수 있다
//    * */
//    init {
//
//    }
//
//    fun 소개() {
//        println("안녕하세요 현대차 입니다")
//    }
//}
//
//class Sonata : Car() {
//
//}
//
//
//interface Human {
//    fun walking() {
//        println("사람이 걷고 있습니다")
//    }
//
//    fun standing() {
//        println("걷기를 멈춤")
//    }
//}
//
//interface Monster {
//    fun not() {
//        println("몬스터가 아닙니다")
//    }
//
//    fun correct() {
//        println("몬스터 입니다")
//    }
//}
//
//class man : Human,Monster {
//    override fun standing() {
//        super.standing()
//    }
//
//    override fun walking() {
//        super.walking()
//
//    }
//
//    override fun correct() {
//        super.correct()
//    }
//
//    override fun not() {
//        super.not()
//    }
//}
//
//fun main() {
////    val car = Car("쏘나타", 2000) //객체 생성하고 객체에 속성값을 넣어줌
//
//    var ram = (Int):(Int)->{}
//    val kim = man()
//    println(kim.walking())
//    println(kim.not())
//
//}
//
//
