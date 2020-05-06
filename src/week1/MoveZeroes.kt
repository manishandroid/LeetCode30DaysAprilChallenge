/**

    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

 */


package week1

fun main()
{
    val arr = intArrayOf(0,1,0,3,12)
    moveZeroes(arr)
}

fun moveZeroes(nums: IntArray) {
    var i = 0
    var j = 0
    while (i < nums.size) {
        if (nums[i] != 0) {
            nums[j] = nums[i]
            j++
        }
        i++
    }
    while (j < nums.size) {
        nums[j] = 0
        j++
    }

    print(nums.contentToString())
}