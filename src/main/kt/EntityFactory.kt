package kt

import java.util.*

/**
 * @author Weiyan Xiang on 2021/3/11
 */
enum class EntityType {
    EASY, MEDIUM, HARD, HELP;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType): Entity {
        val id = UUID.randomUUID().toString()
//        val name = type.getFormattedName()
        val name = when (type) {
            EntityType.EASY -> type.getFormattedName()
            EntityType.MEDIUM -> type.name
            EntityType.HARD -> type.name
            EntityType.HELP -> type.getFormattedName()
        }
        return when (type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}

// sealed class:
/**
 * Sealed Classes allow us to fix type hierarchies and forbid developers from creating new subclasses.
They are useful when you have a very strict inheritance hierarchy, with a specific set of possible subclasses and no
others. The compiler guarantees that only classes defined in the same source file as the sealed class are able to
inherit from it.
 */
sealed class Entity {
    object Help : Entity() {
        val name = "Help"
    }

    // data class generating eauls,hashcode automatically
    data class Easy(val id: String, val name: String) : Entity()

    data class Medium(val id: String, val name: String) : Entity()
    // difference in sealed class VS enum here is you can overload the method with different params,
    // compiler will do smart casting
    data class Hard(val id: String, val name: String, val multiplier: Float) : Entity()
}

// extension method
fun Entity.Medium.printInfo() {
    println("Medium class: $id, $info")
}

// extension var
val Entity.Medium.info: String
    get() = "some medium info"

fun main(args: Array<String>) {
//    val entity = Entity.Factory.create()
    val entity = EntityFactory.create(EntityType.EASY)
    println(entity)
    val anotherEntity = Entity.Easy("id", "name")
    println(anotherEntity)


    val testEntity = EntityFactory.create(EntityType.HELP)
    val msg = when (testEntity) {
        Entity.Help -> "help class"
        is Entity.Easy -> "easy class"
        is Entity.Medium -> "medium class"
        is Entity.Hard -> "hard class"
    }

    println(msg)

    val entity01 = Entity.Easy("id", "name")
    val entity02 = Entity.Easy("id", "name")

    if (entity01 == entity02) {
        println("$entity01 and $entity02 are equal")
    }
    if (entity01 === entity01) {
        println("$entity01 and $entity01 are equal with ref equal too")
    }

    val mediumEntity = Entity.Medium("id", "medium name")
    val mediumEntityFromFactory = EntityFactory.create(EntityType.MEDIUM)
    mediumEntity.printInfo()
    mediumEntity.info

    if (mediumEntityFromFactory is Entity.Medium) {
        mediumEntityFromFactory.printInfo()
    }


}