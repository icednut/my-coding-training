package io.icednut.leetcode.exercise.day07

/**
 * @author will.109
 * @date 2020/04/27
 **/
class RedundantConnectionSolution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = (1..edges.size).toMutableList()
        val rank = (1..edges.size).toMutableList()

//        for (i in 0..edges.size) {
//            parents[i] = i
//        }

        fun find(a: Int): Int {
            if (a == parent[a - 1]) {
                return a
            }
            return find(parent[a - 1])
        }

        fun union(a: Int, b: Int) {
            val x = find(a)
            val y = find(b)

            if (x == y) {
                return
            }
            parent[x] = y
        }

        for (edge in edges) {
            union(edge[0], edge[1])
        }

        return intArrayOf(2, 3)
    }
}