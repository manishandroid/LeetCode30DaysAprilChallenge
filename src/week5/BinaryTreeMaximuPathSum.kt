/**

    Given a non-empty binary tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

    Example 1:

    Input: [1,2,3]

        1
       / \
      2   3

    Output: 6
    Example 2:

    Input: [-10,9,20,null,null,15,7]

            -10
           /   \
          9     20
        /  \
       15   7

    Output: 42

 */


package week5

import kotlin.math.max

fun main()
{
    val treeNode = TreeNode()
    treeNode.`val` = 1
    treeNode.left = TreeNode(2)
    treeNode.right = TreeNode(3)
    println(maxPathSum(treeNode))
}

fun maxPathSum(root: TreeNode?): Int {
    val max = IntArray(1)
    max[0] = Int.MIN_VALUE
    calculateSum(root, max)
    return max[0]
}

fun calculateSum(root: TreeNode?, max: IntArray): Int {
    if (root == null) return 0
    val left = calculateSum(root.left, max)
    val right = calculateSum(root.right, max)
    val current = max(root.`val`, max(root.`val` + left, root.`val` + right))
    max[0] = max(max[0], max(current, left + root.`val` + right))
    return current
}


class TreeNode {
    var `val` = 0
    var left: TreeNode? = null
    var right: TreeNode? = null

    internal constructor() {}
    internal constructor(`val`: Int) {
        this.`val` = `val`
    }

    internal constructor(`val`: Int, left: TreeNode?, right: TreeNode?) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }
}

