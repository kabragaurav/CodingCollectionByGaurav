/**
 * Given a string S of distinct character of size N and their
 * corresponding frequency f[] i.e. character S[i] has f[i] frequency.
 * Your task is to build the Huffman tree print all the huffman codes in preorder
 * traversal of the tree.
 * Note: If two elements have same frequency, then the element which occur at first
 * will be taken on the left of Binary Tree and other one to the right.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author gkabra
 * @since 31-01-2022 Mon
 **/

public class HuffmanEncoding {

    private static class HuffNode {
        char ch;
        int freq;
        HuffNode left;
        HuffNode right;

        HuffNode(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }


    private static void printable(HuffNode root, ArrayList<String> ls, String s) {
        if(root.left == null && root.right == null && Character.isLetter(root.ch)) {
            ls.add(new String(s));
            return;
        }
        printable(root.left, ls, s+"0");
        printable(root.right, ls, s+"1");
    }

    // TC : O(NlogN)
    // SC : O(N) due to priority queue
    private static ArrayList<String> huffmanCodes(String S, int f[]) {
        int N = S.length();
        PriorityQueue<HuffNode> pq = new PriorityQueue<>(N, (a, b) -> a.freq-b.freq);
        // populate pq
        for(int i=0; i<N; i++) {
            HuffNode node = new HuffNode(S.charAt(i), f[i]);
            pq.add(node);
        }

        // build huffman tree
        while(pq.size() > 1) {      // at least 2 nodes to be in tree
            HuffNode left = pq.poll();
            HuffNode right = pq.poll();

            HuffNode combine = new HuffNode('.', left.freq + right.freq);
            if(left.freq == right.freq) {           // if freq equal then as per question, first letter comes left
                if(S.indexOf(left.ch) < S.indexOf(right.ch)) {
                    combine.left = left;
                    combine.right = right;
                } else {
                    combine.left = right;
                    combine.right = left;
                }
            } else {
                combine.left = left;
                combine.right = right;
            }
            pq.add(combine);
        }
        ArrayList<String> ls = new ArrayList<>();
        printable(pq.peek(), ls, "");       // start preorder from root
        return ls;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(huffmanCodes("abcdef", new int[] {5, 9, 12, 13, 16, 45}));
    }

}
