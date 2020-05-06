/**

    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example:

    Input:
    [
    [1,3,1],
    [1,5,1],
    [4,2,1]
    ]

    Output: 7

    Explanation: Because the path 1→3→1→1→1 minimizes the sum.

 */


package week3

fun main()
{
    val arr1 = intArrayOf(1,3,1)
    val arr2 = intArrayOf(1,5,1)
    val arr3 = intArrayOf(4,2,1)
    val arr = arrayOf(arr1, arr2, arr3)
    println(minPathSum(arr))
}

fun minPathSum(grid: Array<IntArray>?): Int {
    if (grid == null || grid.isEmpty())
        return 0

    val m = grid.size
    val n: Int = grid[0].size
    val dp = Array(m) { IntArray(n) }
    dp[0][0] = grid[0][0]
    // initialize top row
    for (i in 1 until n) {
        dp[0][i] = dp[0][i - 1] + grid[0][i]
    }
    // initialize left column
    for (j in 1 until m) {
        dp[j][0] = dp[j - 1][0] + grid[j][0]
    }
    // fill up the dp table
    for (i in 1 until m) {
        for (j in 1 until n) {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                dp[i][j] = dp[i][j - 1] + grid[i][j]
            } else {
                dp[i][j] = dp[i - 1][j] + grid[i][j]
            }
        }
    }
    return dp[m - 1][n - 1]
}

