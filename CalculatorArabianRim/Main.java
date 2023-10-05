package CalculatorArabianRim;
import java.util.Scanner;
import static CalculatorArabianRim.NumberValidator.isRomanNumber;

public class Main {

        public static int result;
        public static String resultStr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите пример разделяя символы пробелом ");
        String primer = scan.nextLine();
        if (isValidInput(primer)) {
            calc(primer);
            System.out.println("Ответ: " + resultStr);
        } else {
            System.out.println("Ошибка: Неправильный формат ввода");
        }

        // Ждем, пока пользователь нажмет Enter
        System.out.println("Для завершения нажмите Enter...");
        scan.nextLine();
    }

        public static boolean isValidInput(String input) {
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                return false;
            }

            String firstNumber = parts[0];
            String secondNumber = parts[2];
            String operator = parts[1];

            if (!isNumberValid(firstNumber) || !isNumberValid(secondNumber) || !isOperatorValid(operator)) {
                return false;
            }

            int firstNumberCorp = Integer.parseInt(firstNumber);
            int secondNumberCorp = Integer.parseInt(secondNumber);

            return (1 <= firstNumberCorp && firstNumberCorp <= 10) && (1 <= secondNumberCorp && secondNumberCorp <= 10);
        }

        public static boolean isNumberValid(String number) {
            try {
                int arabic = Integer.parseInt(number);
                return arabic >= 1 && arabic <= 10;
            } catch (NumberFormatException e) {
                return isRomanNumber(number);
            }
        }

        public static boolean isOperatorValid(String operator) {
            return "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
        }

        public static void calc(String input) {
            String[] parts = input.split(" ");
            int firstNumberCorp = Integer.parseInt(parts[0]);
            int secondNumberCorp = Integer.parseInt(parts[2]);
            String operator = parts[1];

            switch (operator) {
                case "+":
                    result = firstNumberCorp + secondNumberCorp;
                    break;
                case "-":
                    result = firstNumberCorp - secondNumberCorp;
                    break;
                case "*":
                    result = firstNumberCorp * secondNumberCorp;
                    break;
                case "/":
                    if (secondNumberCorp == 0) {
                        throw new ArithmeticException("Деление на ноль");
                    }
                    result = firstNumberCorp / secondNumberCorp;
                    break;
            }

            if (firstNumberCorp >= 1 && firstNumberCorp <= 10) {
                resultStr = Integer.toString(result); // Преобразовать int в строку
            } else {
                resultStr = String.valueOf(result);
            }
        }

}
// Пожалуйста скажите где мыло