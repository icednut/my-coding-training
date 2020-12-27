package io.icednut.algorithm_exercise.leetcode.q146

import scala.collection.mutable
import scala.util.Try

class LRUCache(_capacity: Int) {

  val queue = new mutable.Queue[Int]
  val cache = mutable.Map[Int, Int]()

  def get(key: Int): Int = {
    val value = Try(cache(key)).getOrElse(-1)

    if (value != -1) {
      queue.removeFirst(_ == key)
      queue.enqueue(key)
    }
    value
  }

  def put(key: Int, value: Int): Unit = {
    if (queue.contains(key)) {
      val deleteTargetKey = queue.dequeueFirst(_ == key).getOrElse(-1)
      cache += (deleteTargetKey -> -1)

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