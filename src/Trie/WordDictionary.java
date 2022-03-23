package Trie;

/**
 * For TC and SC, see {@link ImplementTrie#insert(String)} etc.
 *
 * @author gauravkabra
 * @since 23/Mar/2022
 **/

public class WordDictionary {

    private TrieNode root;

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.children[ch-'a'] == null) {
                temp.children[ch-'a'] = new TrieNode();
            }
            temp = temp.children[ch-'a'];
        }
        temp.isEnd = true;
    }

    private boolean helper(TrieNode root, String word) {
        TrieNode temp = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (ch != '.' && temp.children[ch-'a'] == null) {
                return false;
            } else if (ch == '.') {
                boolean isWord = false;
                for (int j=0; j<26; j++) {
                    if (temp.children[j] != null) {
                        isWord = isWord || helper(temp.children[j], word.substring(i+1));
                    }
                    if (isWord) {
                        return true;
                    }
                }
                if (!isWord) {
                    return false;
                }
            }
            temp = temp.children[ch-'a'];
        }
        return temp.isEnd;
    }

    public boolean search(String word) {
        return helper(root, word);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("apple");
        wordDictionary.addWord("app");
        System.out.println(wordDictionary.search("apps"));
        System.out.println(wordDictionary.search("app"));
        System.out.println(wordDictionary.search("appl"));
        System.out.println(wordDictionary.search("apple"));
    }

}
