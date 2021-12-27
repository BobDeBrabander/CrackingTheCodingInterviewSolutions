package chapter17

object Problem17GoogleDoc {
    private class TrieNode(val word: String) {
        var isWordEnding = false
        val adj = mutableMapOf<Char, TrieNode>()
    }

    //searches b for all strings in T, returns a set of all the strings that occurred in b
    fun multiSearch(b: String, T: List<String>): Set<String> {
        val trieTree = makeTrieTree(T)
        val foundWords = HashSet<String>()
        for (i in b.indices) {
            var curNode = trieTree
            for (j in i until b.length) {
                curNode = curNode.adj[b[j]] ?: break
                if (curNode.isWordEnding) foundWords.add(curNode.word)
            }
        }
        return foundWords
    }

    //Make a trie out of a list of words. Returns the root of the trie tree.
    private fun makeTrieTree(words: List<String>): TrieNode {
        val root = TrieNode("")
        words.forEach { word ->
            var curNode = root
            val sb = StringBuilder()
            word.forEach { c ->
                sb.append(c)
                curNode = curNode.adj.getOrPut(c) { TrieNode(sb.toString()) }
            }
            curNode.isWordEnding = true
        }
        return root
    }
}
