/**
 * Asked in Startups, Airbnb
 * Design an in-memory file system to simulate the following functions:
 *
 * ls: Given a path in string format.
 *      If it is a file path, return a list that only contains this file's name.
 *      If it is a directory path, return the list of file and directory names in this directory.
 *      Your output (file and directory names together) should in lexicographic order.
 *
 * mkdir: Given a directory path that does not exist, you should make a new directory according to the path.
 *      If the middle directories in the path don't exist either, you should create them as well.
 *      This function has void return type.
 *
 * addContentToFile: Given a file path and file content in string format.
 *      If the file doesn't exist, you need to create that file containing given content.
 *      If the file already exists, you need to append given content to original content.
 *      This function has void return type.
 *
 * readContentFromFile: Given a file path, return its content in string format.
 *
 * Example:
 *
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 *
 * Output:
 * [null,[],null,null,["a"],"hello"]
 *
 * Notes:
 * You can assume all file or directory paths are absolute paths which begin with / and do not end with /
 * except that the path is just "/".
 * You can assume that all operations will be passed valid parameters and users will not attempt to
 * retrieve file content or list a directory or file that does not exist.
 * You can assume that all directory names and file names only contain lower-case letters, and same names
 * won't exist in the same directory.
 */
package Company;

import java.util.*;

/**
 * Nice video here : https://tinyurl.com/in-memory-file-system
 *
 * @author gauravkabra
 * @since 19/Mar/2022
 **/

public class InMemoryFileSystem {

    private class TrieNode {
        String content;
        Map<String, TrieNode> children = new TreeMap<>();       // since we don't have duplicates, use TreeMap
    }

    private TrieNode root;

    public InMemoryFileSystem() {
        root = new TrieNode();
    }

    // ls
    // TC : O(logN) for going to that node and get all children
    public List<String> ls(String path) {
        TrieNode node = root;
        if (! "/".equals(path)) {
            String[] dirs = path.split("/");
            String curr = null;
            for (int i=1; i<dirs.length; i++) {
                curr = dirs[i];
                node = node.children.get(curr);
            }
            if (node.content != null) {
                return Arrays.asList(curr);
            }
        }

        List<String> children = new ArrayList<>(node.children.keySet());
        // No need to sort since we are using TreeMap
        return children;
    }

    private TrieNode createDirectoryIfNotExists(String path) {
        TrieNode node = root;
        String[] dirs = path.split("/");
        String curr;

        for (int i=1; i<dirs.length; i++) {
            curr = dirs[i];
            if (! node.children.containsKey(curr)) {
                node.children.put(curr, new TrieNode());
            }
            node = node.children.get(curr);
        }

        return node;
    }
    // mkdir
    // TC : O(logN) for adding
    public void mkdir(String path) {
        this.createDirectoryIfNotExists(path);
    }

    // add content
    // TC : O(logN) for adding
    public void addContentToFile(String path, String content) {
        TrieNode lastNode = this.createDirectoryIfNotExists(path.substring(0, path.lastIndexOf("/")));
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        TrieNode fileNode = lastNode.children.get(fileName);
        if (fileNode == null) {
            lastNode.children.put(fileName, new TrieNode());
        }
        fileNode = lastNode.children.get(fileName);
        fileNode.content = fileNode.content == null ? content : fileNode.content + content;
    }

    // read content
    // TC : O(logN) for reaching that node
    public String readContentFromFile(String path) {
        TrieNode lastNode = this.createDirectoryIfNotExists(path);
        return lastNode.content;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        InMemoryFileSystem fs = new InMemoryFileSystem();
        System.out.println(fs.ls("/"));
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hey there!");
        System.out.println(fs.ls("/"));
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
        fs.addContentToFile("/a/b/c/d", "\n hey hi...");
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
        fs.mkdir("/kabra/gaurav");
        fs.mkdir("/kabra/keshav");
        System.out.println(fs.ls("/kabra"));
    }

}
