package CalculatorArabianRim;

public class NumberValidator {
    public static boolean isNumberValid(String number) {
        return isArabicNumber(number) || isRomanNumber(number);
    }

    public static boolean isArabicNumber(String number) {
        try {
            int arabic = Integer.parseInt(number);
            return arabic >= 1 && arabic <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isRomanNumber(String number) {
        return number.matches("^[IVXLCDM]*$");
    }
}