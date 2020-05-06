/**

    Write an algorithm to determine if a number n is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

    Return True if n is a happy number, and False if not.

    Example:

    Input: 19
    Output: true

    Explanation:
    (1*1) + (9*9) = 82
    (8*8) + (2*2) = 68
    (6*6) + (8*8) = 100
    (1*1) + (0*0) + (0*0) = 1


 */


package week1

fun main()
{
    print(isHappy(19))
}

fun isHappy(n: Int): Boolean {
    var n = n
    while (true) {
        n = digitSum(n)
        if (n == 1) return true else if (n == 4) return false
    }
}

private fun digitSum(n: Int): Int {
    var n = n
    var remainder = 0
    var sum = 0
    while (n > 0) {
        remainder = n % 10
        sum += remainder * remainder
        n /= 10
    }
    return sum
}