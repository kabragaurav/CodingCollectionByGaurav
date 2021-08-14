/**
 * Microsoft
 * Implement a trie class that supports insertion and search functionalities.
 * Assume only lowercase alphabetical characters will add to your trie.
 *
 * More read here: https://tinyurl.com/trie-trees
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 14 August 2021
 */

public class ImplementTrie {

    private static class Trie {
        private static final int DOMAIN_SIZE = 26;
        private boolean isEndOfWord;
        private Trie[] children;

        public Trie() {
            isEndOfWord = false;
            children = new Trie[DOMAIN_SIZE];
        }
    }

    private static Trie root = new Trie();

    private static void insert(String key) {
        int len = key.length();
        Trie crawler = root;

        for(int i=0; i<len; i++) {
            int index = key.charAt(i) - 'a';
            if(crawler.children[index] == null) {
                crawler.children[index] = new Trie();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }
    private static boolean search(String key) {
        int len = key.length();
        Trie crawler = root;

        for(int i=0; i<len; i++) {
            int index = key.charAt(i) - 'a';
            if(crawler.children[index] == null) {
                return false;
            }
            crawler = crawler.children[index];
        }
        return crawler.isEndOfWord;
    }

    public static void main(String[] args) {
        String keys[] = {"this", "is", "a", "simple", "trie"};

        for(String key : keys) {
            insert(key);
        }
        System.out.println(search("an"));
        System.out.println(search("simple"));
        System.out.println(search("simpl"));
        System.out.println(search("simpler"));
    }
}
