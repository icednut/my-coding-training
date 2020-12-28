package io.icednut.algorithm_exercise.leetcode.q146

import scala.collection.mutable
import scala.util.Try

class LRUCache(_capacity: Int) {

  val queue = mutable.Queue[Int]()
  val cache = mutable.Map[Int, Int]()

  def get(key: Int): Int = {
    val value = Try(cache(key)).getOrElse(-1)

    if (value != -1) {
      queue.dequeueFirst(_ == key)
      queue += key
    }
    value
  }

  def put(key: Int, value: Int): Unit = {
    val savedKey = queue.indexOf(key)
    if (savedKey >= 0) {
      queue.remove(savedKey)
    } else if (queue.size == _capacity) {
      val deleteTargetKey = queue.dequeue()
      cache += (deleteTargetKey -> -1)
    }
    cache += (key -> value)
    queue += key
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */