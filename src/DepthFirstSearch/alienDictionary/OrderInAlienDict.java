/**
 * Microsoft
 * There is a new alien language which uses the english alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically
 * by the rules of this new language. Derive the order of letters in this language.
 */
package DepthFirstSearch.alienDictionary;

import java.util.*;

/**
 * @author gaurav kabra
 * @since 29 Oct 2021
 **/

public class OrderInAlienDict {

    /**
     * Logic:
     * - build a set of all characters in words
     * - each pair of adjacent words (might) give a relation between two characters
     *   - build a directed graph from these relations: x comes before y --> there is a directed graph from x to y
     * - use topological sorting to order the graph nodes
     *   - run DFS on the graph. when we're done with a node add it to the beginning of a list
     *   - the order of characters in the list is the alphabetical order
     *     - note that nodes in this list will only have edges pointing "forward"
     */

    public static List<Character> getAlphabet(String[] sortedWords) {
        Set<Character> nodes = new HashSet<>();
        for(String sortedWord : sortedWords) {
            for(char ch : sortedWord.toCharArray()) {
                nodes.add(ch);
            }
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        for(int i=0; i<sortedWords.length-1; i++) {
            char[] relation = getRelation(sortedWords[i], sortedWords[i+1]);
            if(null != relation) {
                addEdge(graph, relation[0], relation[1]);
            }
        }

        return topologicalSort(nodes, graph);
    }

    private static List<Character> topologicalSort(Set<Character> nodes, Map<Character, Set<Character>> graph) {
        LinkedList<Character> ans = new LinkedList<>();
        Set<Character> visitedNodes = new HashSet<>();

        for(char node : nodes) {
            if(!visitedNodes.contains(node)) {
                dfs(node, graph, ans, visitedNodes);
            }
        }
        return ans;
    }

    private static void dfs(Character node, Map<Character, Set<Character>> graph, LinkedList<Character> ans, Set<Character> visitedNodes) {
        visitedNodes.add(node);
        for(char neighbor : graph.getOrDefault(node, Collections.emptySet())) {
            if(!visitedNodes.contains(neighbor)) {
                dfs(neighbor, graph, ans, visitedNodes);
            }
        }
        ans.addFirst(node);
    }

    private static void addEdge(Map<Character, Set<Character>> graph, char from, char to) {
        Set<Character> neighbors = graph.getOrDefault(from, new HashSet<>());
        neighbors.add(to);
        graph.put(from, neighbors);
    }

    private static char[] getRelation(String sortedWord1, String sortedWord2) {
        int len = Math.min(sortedWord1.length(), sortedWord2.length());
        for(int i=0; i<len; i++) {
            if(sortedWord1.charAt(i) != sortedWord2.charAt(i)) {
                return new char[] {sortedWord1.charAt(i), sortedWord2.charAt(i)};
            }
        }
        return null;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        String[] sortedWords = new String[] {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        getAlphabet(sortedWords).stream().forEach(x -> System.out.print(x + " "));
    }
}
