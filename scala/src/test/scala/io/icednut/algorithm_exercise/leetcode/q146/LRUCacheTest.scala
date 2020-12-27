package io.icednut.algorithm_exercise.leetcode.q146

import org.scalatest.funsuite.AnyFunSuite

class LRUCacheTest extends AnyFunSuite {

  test("case 01") {
    val lRUCache = new LRUCache(2)
    lRUCache.put(1, 1) // cache is {1=1}
    lRUCache.put(2, 2) // cache is {1=1, 2=2}
    assert(lRUCache.get(1) == 1) // return 1
    lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    assert(lRUCache.get(2) == -1) // returns -1 (not found)
    lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    assert(lRUCache.get(1) == -1) // return -1 (not found)
    assert(lRUCache.get(3) == 3) // return 3
    assert(lRUCache.get(4) == 4) // return 4
  }

  test("case 02") {
    val lRUCache = new LRUCache(1)
    assert(lRUCache.get(0) == -1) // return 1
  }

  /**
   * ["LRUCache","get","put","get","put","put","get","get"]
   * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
   */
  test("case 03") {
    val lRUCache = new LRUCache(2)
    assert(lRUCache.get(2) == -1) // return 1
    lRUCache.put(2, 6)
    assert(lRUCache.get(1) == -1) // return 1
    lRUCache.put(1, 5)
    lRUCache.put(1, 2)
    assert(lRUCache.get(1) == 2) // return 1
    assert(lRUCache.get(2) == 6) // return 1
  }

  /**
   * ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
   * [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
   */
  test("case 04") {
    val lRUCache = new LRUCache(10)
    lRUCache.put(10, 13)
    lRUCache.put(3, 17)
    lRUCache.put(6, 11)
    lRUCache.put(10, 5)
    lRUCache.put(9, 10)
    assert(lRUCache.get(13) == -1)
    lRUCache.put(2, 19)
    assert(lRUCache.get(2) == 19)
    assert(lRUCache.get(3) == 17)
    lRUCache.put(5, 25)
    assert(lRUCache.get(8) == -1)
    lRUCache.put(9, 22)
    lRUCache.put(5, 5)
    lRUCache.put(1, 30)
    assert(lRUCache.get(11) == -1)
    lRUCache.put(9, 12)
    assert(lRUCache.get(7) == -1)
    assert(lRUCache.get(5) == 5)
    assert(lRUCache.get(8) == -1)
    assert(lRUCache.get(9) == 12)
    lRUCache.put(4, 30)
    lRUCache.put(9, 3)
    assert(lRUCache.get(9) == 3)
    assert(lRUCache.get(10) == 5)
    assert(lRUCache.get(10) == 5)
  }
}
