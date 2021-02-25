package com.october.strings;

import com.october.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class PrettyJson {

    public static void main(String[] args) {

        PrettyJson obj = new PrettyJson();
        ArrayUtils.printArray(obj.prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}"));
    }

    public String[] prettyJSON(String A) {
        List<String> op = new ArrayList<>();


        int i = 0;
        int indentations = 0;
        while (i < A.length()) {

            switch (A.charAt(i)) {
                case '[':
                case '{':
                    op.add(getIndentations(indentations++) + A.charAt(i));
                    break;
                case ']':
                case '}':
                    op.add(getIndentations(--indentations) + A.charAt(i));
                    break;
                case ',':
                    // appending comma to previous string
                    op.set(op.size() - 1, op.get(op.size() - 1) + ',');
                    break;
                default:

                    // until a '[' or ']' or '{' or '}' or ','
                    // is found, keep appending to the current index's string
                    StringBuilder sb = new StringBuilder();
                    while (i < A.length() && !isBracketOrComma(A.charAt(i))) {
                        sb.append(A.charAt(i));
                        i++;
                    }

                    op.add(getIndentations(indentations) + sb.toString());
                    // since ++ outside switch
                    i--;
            }
            i++;
        }

        return op.toArray(new String[0]);
    }

    // returns string with given count of indentations
    private String getIndentations(int count) {
        if (count < 1) return "";
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            sb.append('\t');
            count--;
        }
        return sb.toString();
    }

    private boolean isBracketOrComma(char c) {
        return c == '[' || c == ']' || c == '{' || c == '}' || c == ',';
    }
}
