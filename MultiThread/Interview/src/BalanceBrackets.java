import java.util.Stack;

public class BalanceBrackets {


    public static void main(String[] args) {
        System.out.println(isBracketsBalanced("[}]"));
    }

    public static String isBracketsBalanced(String brackets) {
        if (brackets == null || brackets.length() == 0)	return "Balanced";

        Stack<Character> stack = new Stack<>();
        for (Character bracket : brackets.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else if (!stack.isEmpty() && bracket == ')' && stack.peek() == '(') {
                stack.pop();
            }  else if (!stack.isEmpty() && bracket == '}' && stack.peek() == '{') {
            stack.pop();
            }  else if (!stack.isEmpty() && bracket == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                    return "Not Balanced";
                }
    }

	if (stack.isEmpty()) {
        return "Balanced";
    } else {
        return "Not Balanced";
    }
}

}
