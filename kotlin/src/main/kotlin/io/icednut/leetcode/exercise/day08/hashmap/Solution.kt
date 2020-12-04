package io.icednut.leetcode.exercise.day08.hashmap

/**
 * @author will.109
 * @date 2020/05/10
 **/
class MyHashMap() {

    /** Initialize your data structure here. */
    private val container = IntArray(10000000){-1}

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        container[key] = value
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        return container[key]
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        container[key] = -1
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */