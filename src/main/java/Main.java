import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String regularExp = "\\s*([-+]?\\d+(\\.\\d+)?|\\d*\\.\\d+)\\s*([-+*/])\\s*([-+]?\\d+(\\.\\d+)?|\\d*\\.\\d+)\\s*";
        Pattern pattern = Pattern.compile(regularExp);

        while (true) {
            System.out.println("Enter expression:");
            String expression = scanner.nextLine();

            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                String operator = matcher.group(3);
                String firstNum = matcher.group(1);
                String secondNum = matcher.group(4);
                float result = 0;
                switch (operator) {
                    case "+" -> {
                        result = Calculator.Sum(Float.parseFloat(firstNum), Float.parseFloat(secondNum));
                    }
                    case "-" -> {
                        result = Calculator.Sub(Float.parseFloat(firstNum), Float.parseFloat(secondNum));
                    }
                    case "*" -> {
                        result = Calculator.Mul(Float.parseFloat(firstNum), Float.parseFloat(secondNum));
                    }
                    case "/" -> {
                        result = Calculator.Div(Float.parseFloat(firstNum), Float.parseFloat(secondNum));
                    }
                    default -> {
                        return;
                    }
                }
                System.out.println("Result:" + result);

            } else {
                if(expression.toLowerCase().trim().equals("exit")){
                    return;
                }
                System.out.println("Not a valid expression");
                //throw new Exception("Not a valid expression");
            }
        }
    }
}
