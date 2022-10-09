package Medium.Stacks_and_Queues;

/*
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 *
 *
 *
 * Example 1:
 *
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 *
 * Example 2:
 *
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 *
 * Example 3:
 *
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */
import java.util.Arrays;
import java.util.Stack;

public class Simplify_Path {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[]x = path.split("/");
        System.out.println(Arrays.toString(x));
        for (int i = 0; i < x.length; i++){
            if(x[i].equals("") || x[i].equals("."))
                continue;
            if(x[i].equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
                if(!stack.isEmpty())
                    stack.pop();
            }
            else {
                stack.push("/");
                stack.push(x[i]);
            }
        }

        String result = "";
        if(stack.isEmpty())
            return "/";
        while (!stack.isEmpty())
            result = stack.pop() + result;

        return result;
    }

    public static void main(String[] args) {
        String path = "/../";
        String s = simplifyPath(path);
        System.out.println(s);
    }
}
