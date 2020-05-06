/**

    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

 */

package week1

fun main()
{
    val arr = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    print(maxSubArray(arr))
}

fun maxSubArray(nums: IntArray): Int {
    var sum = nums[0]
    var maxSum = nums[0]
    for (i in 1 until nums.size) {
        sum = Math.max(nums[i], sum + nums[i])
        maxSum = Math.max(maxSum, sum)
    }
    return maxSum
}