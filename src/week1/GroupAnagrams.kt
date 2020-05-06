/**

    Given an array of strings, group anagrams together.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
    ]

 */


package week1

fun main()
{
    val arr = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    print(groupAnagrams(arr).toString())
}

    fun groupAnagrams(strings: Array<String>): List<List<String>>? {
        val map =  hashMapOf<String, ArrayList<String>>()
        for (i in strings.indices) {
            val str = strings[i]
            val chars = str.toCharArray()
            chars.sort()
            val mapKey = String(chars)
            if (map.containsKey(mapKey)) {
                val list = map[mapKey]
                list!!.add(str)
                map[mapKey] = list
            } else {
                val list = ArrayList<String>()
                list.add(str)
                map[mapKey] = list
            }
        }
        val list: MutableList<ArrayList<String>> = ArrayList()
        list.addAll(map.values)
        return list
    }