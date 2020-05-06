package week3

interface BinaryMatrix {
    operator fun get(x: Int, y: Int): Int
    fun dimensions() : List<Int>
}