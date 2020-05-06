/**

    Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.

    An empty string is also valid.

    Example 1:
    Input: "()"
    Output: True

    Example 2:
    Input: "(*)"
    Output: True

    Example 3:
    Input: "(*))"
    Output: True

    Note: The string size will be in the range [1, 100].

 */

package week3

import kotlin.math.max

fun main()
{
    println(checkValidString("(*))"))
}

fun checkValidString(s: String): Boolean {
    var lowNum = 0
    var highNum = 0
    for (c in s.toCharArray()) {
        lowNum += if (c == '(') 1 else -1
        highNum += if (c != ')') 1 else -1
        if (highNum < 0) break
        lowNum = max(lowNum, 0)
    }
    return lowNum == 0
}

