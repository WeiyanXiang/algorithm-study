package kt

/**
 * @author Weiyan Xiang on 2021/3/11
 */
// class needs to be open in order for inheritance
class FancyInfoProvider : BasicInfoProvider() {
    override val providerInfo: String
        get() = "Fancy Info provider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("fancy info")
    }

    override val sessionPrefix: String
        get() = "fancy session"
}