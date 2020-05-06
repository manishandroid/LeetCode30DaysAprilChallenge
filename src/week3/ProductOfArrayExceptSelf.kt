/**

    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Example:

    Input:  [1,2,3,4]
    Output: [24,12,8,6]

    Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

 */

package week3

fun main()
{
    val arr = intArrayOf(1,2,3,4)
    println(productExceptSelf(arr)?.contentToString())
}

fun productExceptSelf(nums: IntArray?): IntArray? {
    if (nums == null || nums.size < 2) {
        return IntArray(0)
    }
    val result = IntArray(nums.size)
    result[0] = 1
    for (i in 1 until nums.size) {
        result[i] = result[i - 1] * nums[i - 1]
    }
    var after = 1
    for (i in nums.size - 2 downTo 0) {
        result[i] *= after * nums[i + 1]
        after *= nums[i + 1]
    }
    return result
}

