package com.smhrd.kotlinstudy


// 추상클래스로 처리를 한 경우

//커피가 들어간 메뉴는 다음과 같다.
//open class => 그대로 사용이 가능함
//abstract class => 반드시 구현해야함
abstract class CoffeeMenu1 : Menu {

    //Menu interface // 이름과 가격은 메뉴의 종류별로 다르게 나타남
    abstract override var price: Int
    abstract override val name: String

    //해당 메서드는 모든 메뉴가 동일하게 제공됨
    override fun getMenu() {
        println( "$temperature $name 나왔습니다. 가격은 ${price}원 입니다" )
    }

    abstract var temperature : Temperature
    // enum class

    //커피 관련 음료는 핫/아이스 옵션 선택이 가능 하다.
    enum class Temperature{
        Hot, Ice
    }
}


enum class CoffeeOption1 {
    Vanilla, Almond, None
}

class Latte1() : CoffeeMenu1(){
    override var price: Int
        get() = 4000
        set(value) {}
    override val name: String
        get() = "카페 라떼"

    override var temperature : Temperature = Temperature.Hot
//    override var coffeeOption: Option = Option.None

}

class Americano1() : CoffeeMenu1() {

    override var price: Int = 4000
    override val name: String = "아메리카노"
    // coffeMenu라면 반드시 입력되어야 하는 정보

    override var temperature: Temperature = Temperature.Hot  // 온도 설정에 기본 값

    var coffeeOption : CoffeeOption = CoffeeOption.None

}


//메뉴의 공통 요소 ( 전 메뉴 )
interface Menu{
    var price : Int
    val name : String
    fun getMenu()
}

// 모든 프로퍼티가 다형성을 가지고 있음 => 추상은 부모클래스의 요소를 가져다 쓰는게 있을때 더 어울림
