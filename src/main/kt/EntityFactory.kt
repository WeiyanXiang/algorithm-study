package kt

import java.util.*

/**
 * @author Weiyan Xiang on 2021/3/11
 */
enum class EntityType {
    EASY, MEDIUM, HARD, HELP;

    fun getFormattedName() = name.toLowerCase()
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


sealed class Entity {
    object Help : Entity() {
        val name = "Help"
    }

    // data class generating hashing automatically
    data class Easy(val id: String, val name: String) : Entity()

    data class Medium(val id: String, val name: String) : Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float) : Entity()
}

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
}