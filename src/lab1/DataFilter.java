
package lab1;

/**
 *
 * @author Zacharias
 */
public class DataFilter {

    public static String filter(String s) {
        String[] input = s.split(" ");
        String output = process(input);

        if (output == null) {
            output = "Invalid";
        }

        return output;
    }

    static String process(String[] s) {
        String output = null;
        if (s.length > 0) {
            output = "Function " + s[0] + " was called";
        }

        if (s.length > 1) {
            output += " with arguments ";
            for (int i = 1; i < s.length; i++) {
                if (s.length == 2) {
                    output += s[i];
                }
                if (s.length > 2) {
                    output += s[i];

                    if (i < s.length - 1) {
                        output += ", ";
                    } else {
                       // output += "and ";
                    }
                }
            }
        }

        return output;
    }
}
