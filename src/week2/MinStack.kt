/**

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.


    Example 1:

    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2


    Constraints:

    Methods pop, top and getMin operations will always be called on non-empty stacks.

 */

package week2

fun main()
{
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.min) // return -3
    minStack.pop()
    println(minStack.top())    // return 0
    println(minStack.min) // return -2
}

class MinStack
/** initialize your data structure here.  */
{
    private var top: Element? = null
    fun push(x: Int) {
        if (top == null) top = Element(x, x) else {
            val element = Element(x, Math.min(x, top!!.min))
            element.next = top
            top = element
        }
    }

    fun pop() {
        if (top == null) return
        val temp = top!!.next
        top!!.next = null
        top = temp
    }

    fun top(): Int {
        return if (top == null) -1 else top!!.value
    }

    val min: Int
        get() = if (top == null) -1 else top!!.min

    inner class Element(var value: Int, var min: Int) {
        var next: Element? = null

    }
}
