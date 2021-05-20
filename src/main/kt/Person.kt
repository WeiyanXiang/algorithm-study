package kt

/**
 * @author Weiyan Xiang on 2021/3/7
 */
// public - by default/ internal / private
class Person(val firstName: String = "defaultFN", val lastName: String = "defaultLN") {
    // modifier:
    // internal - same package
    // protected - same class subclass
    // private - same class
    var nickname: String? = null
        set(value) {
            field = value
            println("setting new nickname: $value")
        }
        get() {
            val nickNameToPrint = field ?: "no nickname"
            println("getting new nickname: $nickNameToPrint")
            return nickNameToPrint
        }

    constructor() : this("", "")

    fun printInfo() {
        val nickNameToPrice = nickname ?: "no nickname" // it means if nickname is null then "no nickname"
        println("$firstName ($nickNameToPrice) $lastName")
    }
}
