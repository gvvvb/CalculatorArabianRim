package CalculatorArabianRim;

import java.util.Scanner;

public class Main {

    public static int result;
    public static String resultStr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите пример разделяя символы пробелом: ");
        String input = scan.nextLine();

        String output = calc(input);

        if (output != null) {
            System.out.println("Ответ: " + output);
        } else {
            System.out.println("Ошибка: Неправильный формат ввода |_|");
        }

        // Ждем, пока пользователь нажмет Enter
        System.out.println("Для завершения нажмите Enter...");
        scan.nextLine();
    }

    public static String calc(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            return null;
        }

        String firstNumber = parts[0];
        String operator = parts[1];
        String secondNumber = parts[2];

        if (!isValidInput(firstNumber, operator, secondNumber)) {
            return null;
        }

        int firstNumberCorp = isRomanNumber(firstNumber) ? Roman.convert(firstNumber) : Integer.parseInt(firstNumber);
        int secondNumberCorp = isRomanNumber(secondNumber) ? Roman.convert(secondNumber) : Integer.parseInt(secondNumber);

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
                    return "Ошибка: Деление на ноль";
                }
                result = firstNumberCorp / secondNumberCorp;
                break;
        }

        if (isRomanNumber(firstNumber) || isRomanNumber(secondNumber)) {
            if (result <= 0) {
                return "Ошибка: Результат должен быть положительным римским числом.";
            }
            return Roman.toRoman(result);
        } else {
            return Integer.toString(result);
        }
    }

    public static boolean isValidInput(String firstNumber, String operator, String secondNumber) {
        return (isNumberValid(firstNumber) && isNumberValid(secondNumber) && isOperatorValid(operator));
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

    public static boolean isRomanNumber(String number) {
        return number.matches("^[IVXLCDM]*$");
    }
}

// Пожалуйста, скажите где мыло
