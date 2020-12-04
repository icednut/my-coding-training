package io.icednut.leetcode.exercise.day09.generics.contravariance1

interface EnergySource

open class Vegetable : EnergySource

class Bamboo : Vegetable()


interface Consumer<T> {
    fun process(source: T)
}


class SourceWrapper<T>(private val energySource: T) {

    fun getRidOf(consumer: Consumer<in T>) {
        consumer.process(energySource)
    }
}