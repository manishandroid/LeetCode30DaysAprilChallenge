/**

    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

    The cache is initialized with a positive capacity.

    Follow up:
    Could you do both operations in O(1) time complexity?

    Example:

    LRUCache cache = new LRUCache( 2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4

 */


package week4

fun main()
{
    val lruCache = LRUCache(2)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    println(lruCache[1])        // returns 1
    lruCache.put(3, 3)          // evicts key 2
    println(lruCache[2])        // returns -1 (not found)
    lruCache.put(4, 4)          // evicts key 1
    println(lruCache[1])        // returns -1 (not found)
    println(lruCache[3])        // returns 3
    println(lruCache[4])        // returns 4

}

internal class LRUCache(private var capacity: Int) {
    private val cache: MutableMap<Int, Node?> = HashMap()
    private val queue = LinkedList()
    operator fun get(key: Int): Int {
        if (cache.containsKey(key)) {
            val node = cache[key]
            queue.deleteNode(node)
            queue.add(node)
            return cache[key]!!.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        val node = Node(key, value)
        when {
            cache.containsKey(key) -> {
                queue.deleteNode(cache[key])
                cache[key] = node
                queue.add(node)
            }
            capacity > 0 -> {
                cache[key] = node
                queue.add(node)
                capacity--
            }
            else -> {
                cacheReSize()
                cache[key] = node
                queue.add(node)
            }
        }
    }

    private fun cacheReSize() {
        cache.remove(queue.head!!.key)
        queue.removeFromHead()
    }

    private inner class Node(var key: Int, var value: Int) {
        var next: Node? = null
        var previous: Node? = null

    }

    private inner class LinkedList {
        var head: Node? = null
            private set
        private var tail: Node? = null
        fun add(node: Node?) {
            if (head == null) {
                head = node
                tail = node
            } else {
                tail!!.next = node
                node!!.previous = tail
                tail = node
            }
        }

        fun deleteNode(node: Node?) {
            if (node === head) {
                removeFromHead()
                return
            }
            if (node === tail) {
                val previous = tail!!.previous
                previous!!.next = null
                tail = previous
                return
            }
            val nextNode = node!!.next
            val previousNode = node.previous
            previousNode!!.next = nextNode
            nextNode!!.previous = previousNode
        }

        fun removeFromHead() {
            if (head!!.next != null) {
                head = head!!.next
                head!!.previous = null
            } else {
                head = null
            }
        }

    }

}