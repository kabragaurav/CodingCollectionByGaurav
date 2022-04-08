/*
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in
a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to
the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

    The path starts with a single slash '/'.
    Any two directories are separated by a single slash '/'.
    The path does not end with a trailing '/'.
    The path only contains the directories on the path from the root directory to the target file or directory
    (i.e., no period '.' or double period '..')

Return the simplified canonical path.
 */
package Company.Microsoft;

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class SimplifyUnixPaths {

    private static String simplifyPath(String A) {
        Stack<String> stk = new Stack<>();
        String[] s = A.split("\\/");

        for (String cmd : s) {
            if (cmd.equals(".")) {
                continue;
            } else if (cmd.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else if (!cmd.equals("")) {
                stk.push(cmd);
            }
        }

        String ans = "/";
        for (String x : stk) {
            ans += x + "/";
        }
        String fin = ans.substring(0, ans.length()-1);
        return fin.equals("") ? "/" : fin;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(simplifyPath("/"));
        System.out.println(simplifyPath("/usr//bin/"));
        System.out.println(simplifyPath("/usr"));
        System.out.println(simplifyPath("/../"));
    }

}
