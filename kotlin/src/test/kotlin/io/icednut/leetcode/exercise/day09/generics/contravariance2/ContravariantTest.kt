package io.icednut.leetcode.exercise.day09.generics.contravariance2

import org.junit.jupiter.api.Test

interface Animal {
    fun sound(): String
}

open class Bird : Animal {

    override fun sound(): String {
        return "call"
    }
}

class Chicken : Bird() {

    override fun sound(): String {
        return "cluck"
    }
}

class Duck : Bird() {

    override fun sound(): String {
        return "cluck"
    }
}


internal class ContravariantTest {

    @Test
    fun `반공변의 이해 - 예제2`() {
        val bar: (Chicken) -> String = { c: Chicken -> c.sound() }
        val baz: (Bird) -> String = { b: Bird -> b.sound() }
        val quz: (Animal) -> String = { a: Animal -> a.sound() }

        foo(baz)
        foo(quz)
//        foo(bar) // 컴파일 오류남.
    }

    fun foo(tweet: (Bird) -> String) {
        tweet(Bird())
        tweet(Duck())
    }
}