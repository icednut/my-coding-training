package io.icednut.leetcode.exercise.day09.generics.common

open class Animal {
    fun feed() {
    }
}

@Suppress("UNCHECKED_CAST")
class Herd<out T : Animal> {
    private val herd: MutableList<Any> = mutableListOf()
    val size: Int get() = herd.size
    operator fun get(i: Int): T {
        return herd[i] as T
    }
}

class Cat: Animal() {
    fun cleanLitter() {
        println("call cleanLitter")
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }
    feedAll(cats)
}