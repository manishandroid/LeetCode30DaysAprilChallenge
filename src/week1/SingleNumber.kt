/**

   Given a non-empty array of integers, every element appears twice except for one. Find that single one.

   Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,1]
    Output: 1

   Example 2:

    Input: [4,1,2,1,2]
    Output: 4

 */


package week1

fun main()
{
    val arr = intArrayOf(4,1,2,1,2)
    print(singleNumber(arr))
}

fun singleNumber(nums: IntArray): Int {
    var singleNum = nums[0]
    for (i in 1 until nums.size) {
        singleNum = singleNum xor nums[i]
    }
    return singleNum
}
