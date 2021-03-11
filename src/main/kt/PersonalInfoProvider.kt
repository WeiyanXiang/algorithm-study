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

open class BasicInfoProvider : PersonalInfoProvider, SessionInfoProvider {

    override val providerInfo: String
        get() = "BasicInfoProvider"

    // protected to hide if from accessing publicly
    protected open val sessionPrefix = "Session"

    override fun getSessionId(): String {
        return sessionPrefix
    }

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Additionally print something")
    }

}

