/**

    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input:
    11110
    11010
    11000
    00000

    Output: 1

    Example 2:

    Input:
    11000
    11000
    00100
    00011

    Output: 3

 */

package week3

fun main()
{
    val charArray = charArrayOf('1','1','0','0','0','1','1','0','1','0','1','1','0','0','0','0','0','0','0','0')
    val arr = arrayOf(charArray)
    println(numIslands(arr))
}

fun numIslands(grid: Array<CharArray>?): Int {
    if (grid == null || grid.isEmpty() || grid[0].isEmpty()) return 0
    val m = grid.size
    val n: Int = grid[0].size
    var count = 0
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == '1') {
                count++
                merge(grid, i, j)
            }
        }
    }
    return count
}

fun merge(grid: Array<CharArray>, i: Int, j: Int) {
    val m = grid.size
    val n: Int = grid[0].size
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return
    grid[i][j] = 'X'
    merge(grid, i - 1, j)
    merge(grid, i + 1, j)
    merge(grid, i, j - 1)
    merge(grid, i, j + 1)
}