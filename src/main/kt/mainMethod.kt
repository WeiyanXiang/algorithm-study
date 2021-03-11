package kt

/**
 * @author Weiyan Xiang on 2021/3/7
 */

fun main(args: Array<String>) {
    /*
    testCollections()

    val person = Person("wy", "x")
    person.firstName
    person.lastName
    person.nickname = "nickName1"
    person.nickname = "new nick name"
    person.nickname
    person.printInfo()

    */
    val me = Person("Weiyan", "X")
//    val provider = BasicInfoProvider()
    val provider = FancyInfoProvider()


    // object expression / anonymous class
    val anotherProvier = object : PersonalInfoProvider {
        override val providerInfo: String
            get() = "New info provider"

        fun getSessionId() = "id"
    }
    // companion objects
    provider.printInfo(me)
}

fun checkTypes(infoProvider: PersonalInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("not SessionInfoProvider")
    } else {
        // (infoProvider as SessionInfoProvider).getSessionId()
        infoProvider.getSessionId() // smart cast
    }
}
