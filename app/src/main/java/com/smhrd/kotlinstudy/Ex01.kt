package com.smhrd.kotlinstudy

fun main(){
    val americano = Americano().apply {
        setTemperature(Temperature.Hot)
        setVanilliaCream(CoffeeOption.Vanilla)
    }

    val latte = Latte(4000, "바닐라라떼").apply {
        setTemperature(Temperature.Ice)
        setVanilliaCream(CoffeeOption.None)

    }

    americano.getMenu() // 4000원 Vanilla Hot 아메리카노 나왔습니다!
    latte.getMenu()
}



interface Coffee{
    var price : Int
    var name : String

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

        selectTem = when(selectTem){
            Temperature.Hot -> Temperature.Hot
            Temperature.Ice -> Temperature.Ice
        }

        selectOption = when(selectOption){
            CoffeeOption.Vanilla -> CoffeeOption.Vanilla
            CoffeeOption.Almond -> CoffeeOption.Almond
            CoffeeOption.None -> CoffeeOption.None
        }

        println("${price}원 ${selectOption} ${selectTem}${name}나왔습니다!")
    }

}




class Americano() : CoffeeMenu() {

    override var price: Int
        get() = 4000
        set(value) {

        }
    override var name: String
        get() = "아메리카노"
        set(value) {

        }

}

class Latte(override var price: Int, override var name: String) : CoffeeMenu() {

}

