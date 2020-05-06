/**
    Given a non-empty, singly linked list with head node head, return a middle node of linked list.

    If there are two middle nodes, return the second middle node.

    Example 1:

    Input: [1,2,3,4,5]
    Output: Node 3 from this list (Serialization: [3,4,5])
    The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
    Note that we returned a ListNode object ans, such that:
    ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

    Example 2:

    Input: [1,2,3,4,5,6]
    Output: Node 4 from this list (Serialization: [4,5,6])
    Since the list has two middle nodes with values 3 and 4, we return the second one.


    Note:

    The number of nodes in the given list will be between 1 and 100.

 */


package week2

fun main()
{
    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next?.next = ListNode(3)
    listNode.next?.next?.next = ListNode(4)
    listNode.next?.next?.next?.next = ListNode(5)
    listNode.next?.next?.next?.next?.next = ListNode(6)

    print(middleNode(listNode)?.`val`)
}

private fun middleNode(head: ListNode?): ListNode? {
    var firstPointer = head
    var secondPointer = head
    while (secondPointer?.next != null) {
        firstPointer = firstPointer?.next
        secondPointer = secondPointer.next?.next
    }
    return firstPointer
}

internal class ListNode(var `val`: Int) {
     var next: ListNode? = null
}