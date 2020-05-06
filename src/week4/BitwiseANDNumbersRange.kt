/**

    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

    Example 1:

    Input: [5,7]
    Output: 4

    Example 2:

    Input: [0,1]
    Output: 0

 */


package week4

fun main()
{
    println(rangeBitwiseAnd(5,7))
}

fun rangeBitwiseAnd(m: Int, n: Int): Int {
    var n = n
    while (n > m) {
        n = n and n - 1
    }
    return m and n
}