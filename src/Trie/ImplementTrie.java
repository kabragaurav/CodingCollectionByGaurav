/*
A trie or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset
of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
    and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has
    the prefix prefix, and false otherwise.

word and prefix consist only of lowercase English letters.

 */
package Trie;

/**
 * Trie is also knows as Prefix Tree
 *
 * @author gauravkabra
 * @since 23/Mar/2022
 **/

public class ImplementTrie {

    private TrieNode root;

    // SC of Trie : O(N*word.length*26) where N = number of words in Trie (Worst case, each word non-overlapping)
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public ImplementTrie() {
        root = new TrieNode();
    }

    // TC of Insert : O(word.length)
    public void insert(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {    // apple
            if (temp.children[ch-'a'] == null) {
                temp.children[ch-'a'] = new TrieNode();
            }
            temp = temp.children[ch-'a'];
        }
        temp.isEnd = true;
    }

    // TC of Search : O(word.length)
    public boolean search(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.children[ch-'a'] == null) {
                return false;
            }
            temp = temp.children[ch-'a'];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (char ch : prefix.toCharArray()) {
            if (temp.children[ch-'a'] == null) {
                return false;
            }
            temp = temp.children[ch-'a'];
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ImplementTrie implementTrie = new ImplementTrie();
        implementTrie.insert("apple");
        implementTrie.insert("app");
        System.out.println(implementTrie.search("apps"));
        System.out.println(implementTrie.search("app"));
        System.out.println(implementTrie.startsWith("appl"));
    }

}
