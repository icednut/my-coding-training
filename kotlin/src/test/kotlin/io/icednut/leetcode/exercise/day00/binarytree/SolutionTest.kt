package io.icednut.leetcode.exercise.day00.binarytree

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/04/16
 */
internal class SolutionTest {

    @Test
    fun `binary tree에 대해 Inorder 순회를 할 수 있어야 한다`() {
        val solution = Solution()
        val root = TreeNode(1)
        val right = TreeNode(2)
        right.left = TreeNode(3)
        root.right = right

        val result = solution.inorderTraversal(root)

        assertArrayEquals(result.toIntArray(), intArrayOf(1, 3, 2))
    }
}