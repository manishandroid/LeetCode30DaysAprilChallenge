/**

    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

    Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2

    Note:
    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 */


package week4

fun main()
{
    val arr = intArrayOf(1,1,1)
    println(subArraySum(arr, 2))
}

fun subArraySum(nums: IntArray, k: Int): Int {
    val prevSum = HashMap<Int, Int?>()
    var result = 0
    var currentSum = 0
    for (i in nums.indices) {
        currentSum += nums[i]
        if (currentSum == k) result++
        if (prevSum.containsKey(currentSum - k)) {
            result += prevSum[currentSum - k]!!
        }
        val count = prevSum[currentSum]
        if (count == null)
            prevSum[currentSum] = 1
        else
            prevSum[currentSum] = count + 1
    }
    return result
}