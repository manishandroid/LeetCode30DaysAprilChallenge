/**

    Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

    Example 1:

    Input: [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

    Example 2:

    Input: [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

    Note: The length of the given binary array will not exceed 50,000.

 */

package week2

import kotlin.math.max

fun main()
{
    val arr = intArrayOf(0,1,0)
    println(findMaxLength(arr))
}

fun findMaxLength(nums: IntArray): Int {
    val map: MutableMap<Int, Int?> = HashMap()
    map[0] = -1
    var maxLength = 0
    var count = 0
    for (i in nums.indices) {
        count += if (nums[i] == 1) 1 else -1
        if (map.containsKey(count)) {
            maxLength = max(maxLength, i - map[count]!!)
        } else {
            map[count] = i
        }
    }
    return maxLength
}