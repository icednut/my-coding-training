package io.icednut.leetcode.exercise.day09.generics.contravariance1

import org.junit.jupiter.api.Test

internal class ContravarianceTest {

    @Test
    fun `반공변의 이해 - 예제1`() {
        val source: SourceWrapper<Vegetable> = SourceWrapper(Vegetable())

        // 성공
        val consumerOfEverythingThatBurns: Consumer<EnergySource> =
            object : Consumer<EnergySource> {
                override fun process(source: EnergySource) {
                }
            }
        source.getRidOf(consumerOfEverythingThatBurns)

        // 성공 2
        val consumerOfVegetable: Consumer<Vegetable> = object : Consumer<Vegetable> {
            override fun process(source: Vegetable) {
            }
        }
        source.getRidOf(consumerOfVegetable)

        // 실패
        val consumerOfBamboo: Consumer<Bamboo> = object : Consumer<Bamboo> {
            override fun process(source: Bamboo) {
            }
        }
//        source.getRidOf(consumerOfBamboo)
    }
}