package io.icednut.leetcode.exercise.day08.hashmap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/05/10
 */
internal class MyHashMapTest {

    @Test
    fun `HashMap을 구현할 수 있어야 한다`() {
        val hashMap = MyHashMap()

        hashMap.put(1, 1);
        hashMap.put(2, 2);
        assertEquals(1, hashMap.get(1))            // returns 1
        assertEquals(-1, hashMap.get(3))            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        assertEquals(1, hashMap.get(2))            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        assertEquals(-1, hashMap.get(2))            // returns -1 (not found)
    }
}