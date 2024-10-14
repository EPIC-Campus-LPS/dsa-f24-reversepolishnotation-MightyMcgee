public class ReversePolishNotation {

    static int evaluatePostfix(String input){
        String[] s = input.split(" ");
        Stack stack = new Stack();
        String[] operators = {"+","-","*","/"};
        for (int i=0; i<s.length; i++){
            stack.push(s[i]);
            for (int j=0; j<operators.length; j++){
                if (s[i].equals(operators[j])) {
                    String op = stack.pop();
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    if (op.equals("+")){
                        int output = a + b;
                        stack.push(String.valueOf(output));
                    }
                    if (op.equals("-")){
                        int output = a - b;
                        stack.push(String.valueOf(output));
                    }
                    if (op.equals("*")){
                        int output = a * b;
                        stack.push(String.valueOf(output));
                    }
                    if (op.equals("/")){
                        int output = a / b;
                        stack.push(String.valueOf(output));
                    }
                }
            }
        }
        int finalValue = Integer.parseInt(stack.pop());
        System.out.print(finalValue);
        return finalValue;
    }
    public static int precedence(String operators){
        if (operators.equals("+") || operators.equals("-")){
            return 1;
        }
        if (operators.equals("*") || operators.equals("/")){
            return 2;
        }
        if (operators.equals("^")){
            return 3;
        }
        if (operators.equals("(")){
            return 4;
        }
        if (operators.equals(")")){
            return 0;
        }
        else {
            return -1;
        }
    }
    static String infixToPostfix(String input){
        String[] s = input.split(" ");
        Stack stack = new Stack();
        String[] operators = {"+","-","*","/","(",")","^"};
        String output = "";

        for (int i=0; i<s.length; i++){
            boolean op = false;
            for (int j=0; j<operators.length; j++){
                if (s[i].equals(operators[j])){
                    op = true;
                }
            }
            if (op){
                if (stack.isEmpty()){
                    stack.push(s[i]);
                }
                else if (precedence(s[i]) <= precedence(stack.peek())){
                    if (stack.peek().equals("(") || stack.peek().equals(")")){
                        stack.pop();
                    }
                    else {
                        output += stack.pop();
                        stack.push(s[i]);
                    }

                }
                else if (precedence(s[i]) > precedence(stack.peek())){
                    stack.push(s[i]);
                }
            }
            if (!op){
                output += s[i];
            }
        }
        for (int i=stack.size(); i>0; i--){
            if (stack.peek().equals(")")){
                stack.pop();
            }
            else {
                output += stack.pop();
            }
        }
        System.out.print(output+"\n");
        return output;
    }
}