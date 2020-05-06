/**

    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    Example:

    Input:

    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0

    Output: 4

 */


package week4

import kotlin.math.max
import kotlin.math.min

fun main()
{
    val charArray1 = charArrayOf('1', '0', '1', '0', '0')
    val charArray2 = charArrayOf('1', '0', '1', '1', '1')
    val charArray3 = charArrayOf('1', '1', '1', '1', '1')
    val charArray4 = charArrayOf('1', '0', '0', '1', '0')
    val inputCharArray = arrayOf(charArray1, charArray2, charArray3, charArray4)
    println(maximalSquare(inputCharArray))
}

fun maximalSquare(matrix: Array<CharArray>?): Int {
    if (matrix == null || matrix.isEmpty()) {
        return 0
    }
    var result = 0
    val dp = Array(matrix.size) { IntArray(matrix[0].size) }
    for (i in matrix.indices) {
        dp[i][0] = matrix[i][0] - '0'
        result = max(result, dp[i][0])
    }
    for (j in matrix[0].indices) {
        dp[0][j] = matrix[0][j] - '0'
        result = max(result, dp[0][j])
    }
    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[0].size) {
            if (matrix[i][j] == '1') {
                var min = min(dp[i - 1][j], dp[i][j - 1])
                min = min(min, dp[i - 1][j - 1])
                dp[i][j] = min + 1
                result = max(result, min + 1)
            } else {
                dp[i][j] = 0
            }
        }
    }
    return result * result
}