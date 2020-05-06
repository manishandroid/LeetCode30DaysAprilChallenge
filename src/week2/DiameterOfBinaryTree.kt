/**

    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    Example:
    Given a binary tree

         1
        / \
       2   3
      / \
     4   5

    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.

 */

package week2

import kotlin.math.max

fun main()
{
    val treeNode = TreeNode(1)
    treeNode.left = TreeNode(2)
    treeNode.right = TreeNode(3)
    treeNode.left?.left = TreeNode(4)
    treeNode.left?.right = TreeNode(5)

    println(diameterOfBinaryTree(treeNode))
}

var diameter = 0
fun diameterOfBinaryTree(root: TreeNode?): Int {
    heightOfBinaryTree(root)
    return diameter
}

fun heightOfBinaryTree(root: TreeNode?): Int {
    if (root == null) return 0
    val leftNode = heightOfBinaryTree(root.left)
    val rightNode = heightOfBinaryTree(root.right)
    diameter = max(leftNode + rightNode, diameter)
    return max(leftNode, rightNode) + 1
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

}