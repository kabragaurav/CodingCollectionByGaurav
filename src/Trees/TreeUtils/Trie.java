package Trees.TreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of Trie data structure
 * Domain:
 *  [a-z]
 * Supports:
 *  Insert
 *  Search
 *  Delete
 *
 * @author gkabra
 * @since 22-01-2022 Sat
 **/

public class Trie {

    private static final int SUPPORTED_SIZE = 26;   // a-z
    private boolean isValidWord;
    private List<Trie> children;

    public Trie() {
        this.isValidWord = false;
        /**
             public static <T> List<T> nCopies(int number, T object)

             where, number is the number of copies
             of object and object represents the
             element which will appear number times
             in the returned list. T represents generic type.

            E.g. List list = Collections.nCopies(4, "gauravkabra");
         */
        this.children = new ArrayList<>(
                Collections.nCopies(SUPPORTED_SIZE, null)
        );
    }

    public void insert(String word) {
        Trie currentNode = this;

        for(char ch : word.toCharArray()) {
            if(currentNode.children.get(ch-'a') == null) {
                currentNode.children.set(ch-'a', new Trie());
            }
            currentNode = currentNode.children.get(ch-'a');
        }
        // Any word that was inserted is valid whether it is leaf or not E.g. tech and techi both are valid as per insertion by main() method
        currentNode.isValidWord = true;
    }

    public boolean search(String word) {
        Trie currentNode = this;

        for(char ch : word.toCharArray()) {
            currentNode = currentNode.children.get(ch-'a');
            if(currentNode == null) {
                return false;
            }
        }
        return currentNode.isValidWord;
    }

    public boolean delete(String word) {
        Trie currentNode = this;

        for(char ch : word.toCharArray()) {
            currentNode = currentNode.children.get(ch-'a');
            if(currentNode == null) {
                return true;        // not present, so no need for deletion
            }
        }
        currentNode.isValidWord = false;
        return true;
    }

    /**

    // for testing only
    public static void main (String[] args) {
        // construct a new Trie node
        Trie head = new Trie();

        head.insert("techie");
        head.insert("techi");
        head.insert("tech");
        validate(head);

        head.insert("techiedelight");
        validate(head);

        head.delete("techi");
        validate(head);

        head.insert("techi");
        head.delete("techno");      // that does not exist
        validate(head);
        System.out.println(head.search("techno"));   // true

    }

    private static void validate(Trie head) {
        System.out.println(head.search("tech"));            // true
        System.out.println(head.search("techi"));           // true
        System.out.println(head.search("techie"));          // true
        System.out.println(head.search("techiedelight"));   // true
        System.out.println("--------------------------\n");
    }

    **/



}
