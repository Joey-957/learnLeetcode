package Stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * -----------------------------------------------------------------
 * switch(case){
 * case 1 :
 * statement;
 * case 2:
 * statement;
 * }
 * 如果statement相同，则写法可以合并
 */
public class ValiadParents_20 {
    private boolean isValid(String s) {
        boolean flag = false;
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            char c1;
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    continue;
                case ')':
                    if (!stack.empty()) {
                        c1 = stack.pop();
                        if (c1 != '(') {
                            return flag;
                        } else {
                            continue;
                        }
                    } else {
                        return flag;
                    }
                case ']':
                    if (!stack.empty()) {
                        c1 = stack.pop();
                        if (c1 != '[') {
                            return flag;
                        } else {
                            continue;
                        }
                    } else {
                        return flag;
                    }
                case '}':
                    if (!stack.empty()) {
                        c1 = stack.pop();
                        if (c1 != '{') {
                            return flag;
                        }
                    } else {
                        return flag;
                    }
            }
        }
        if (stack.empty()) {
            flag = true;
        }
        return flag;
    }


    public static void main(String[] argus) {
        ValiadParents_20 one = new ValiadParents_20();
        String s = "()[]{";
        System.out.println(one.isValid(s));
    }
}
