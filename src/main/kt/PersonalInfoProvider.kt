package kt

/**
 * @author Weiyan Xiang on 2021/3/7
 */
interface PersonalInfoProvider {
    val providerInfo: String
    fun printInfo(person: Person) {
        println("Provider Info: $providerInfo")
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

class BasicInfoProvider : PersonalInfoProvider, SessionInfoProvider {
    override fun getSessionId(): String {
        return "Some session id"
    }

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Additionally print something")
    }

    override val providerInfo: String
        get() = "BasicInfoProvider"


}

