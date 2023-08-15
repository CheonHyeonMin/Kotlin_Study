package com.smhrd.kotlinstudy

fun main(){
    val americano = Americano().apply {
        setTemperature(Temperature.Hot)
        setVanilliaCream(CoffeeOption.Vanilla)

    }

    val latte = Latte().apply {
        setTemperature(Temperature.Ice)
        setVanilliaCream(CoffeeOption.None)
    }

    val vanillalatte = VanillaLatte().run {
        setTemperature(Temperature.Ice)
        setVanilliaCream(CoffeeOption.None)
        this
    }

    americano.getMenu() // 4000원 Vanilla Hot 아메리카노 나왔습니다!
    latte.getMenu()
    vanillalatte.getMenu()

}



interface Coffee{
    val price : Int
    val name : String

    fun getMenu()
}



enum class Temperature{
    Hot , Ice
}
enum class CoffeeOption{
    Vanilla, Almond, None
}




abstract class CoffeeMenu :Coffee{

    var selectTem : Temperature = Temperature.Hot
    var selectOption : CoffeeOption = CoffeeOption.Vanilla

    open fun setTemperature(tem : Temperature) {
        selectTem = tem
    }

    open fun setVanilliaCream(option : CoffeeOption){
        selectOption = option
    }

    override fun getMenu() {
        println("${price}원 ${selectOption} ${selectTem}${name}나왔습니다!")
    }

}




class Americano() : CoffeeMenu() {
    override val name : String = "아메리카노"
    override val price : Int = 4000
}

class Latte() : CoffeeMenu() {
    override val name : String = "카페 라뗴"
    override val price : Int = 4000
}

class VanillaLatte() : CoffeeMenu(){
    override val name : String = "바닐라 라떼"
    override val price : Int = 4000
}



