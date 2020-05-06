/**

    Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.

    We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

    Example 1:

    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
    Output: true
    Explanation:
    The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
    Other valid sequences are:
    0 -> 1 -> 1 -> 0
    0 -> 0 -> 0

    Example 2:

    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
    Output: false
    Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.

    Example 3:

    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
    Output: false
    Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.


    Constraints:

    1 <= arr.length <= 5000
    0 <= arr[i] <= 9
    Each node's value is between [0 - 9].

 */


package week5

fun main()
{
    val treeNode  = TreeNodes()
    treeNode.`val` =  0
    treeNode.left = TreeNodes(1)
    treeNode.right = TreeNodes(0)
    treeNode.left?.left = TreeNodes(0)
    treeNode.left?.right = TreeNodes(1)
    treeNode.left?.left?.right = TreeNodes(1)
    treeNode.left?.right?.left = TreeNodes(0)
    treeNode.left?.right?.right = TreeNodes(0)

    val path = intArrayOf(0,1,0,1)

    println(isValidSequence(treeNode,  path))


}

fun isValidSequence(root: TreeNodes?, arr: IntArray?): Boolean {
    return helper(root, arr!!, 0)
}

fun helper(root: TreeNodes?, arr: IntArray, index: Int): Boolean {
    if (root == null)
        return false
    if (arr[index] != root.`val`)
        return false
    return if ((index + 1) == arr.size) root.left == null && root.right == null else helper(
        root.left,
        arr,
        index + 1
    ) || helper(root.right, arr, index + 1)
}


class TreeNodes {
    var `val` = 0
    var left: TreeNodes? = null
    var right: TreeNodes? = null

    internal constructor() {}
    internal constructor(`val`: Int) {
        this.`val` = `val`
    }

    internal constructor(`val`: Int, left: TreeNodes?, right: TreeNodes?) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }
}