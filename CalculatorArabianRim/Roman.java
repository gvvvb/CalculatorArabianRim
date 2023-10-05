package CalculatorArabianRim;
import java.util.HashMap;
import java.util.Map;

public class Roman {
    private static final Map<Character, Integer> romanToArabic = new HashMap<>();

    static {
        romanToArabic.put('I', 1);
        romanToArabic.put('V', 5);
        romanToArabic.put('X', 10);
        romanToArabic.put('L', 50);
        romanToArabic.put('C', 100);
        romanToArabic.put('D', 500);
        romanToArabic.put('M', 1000);
    }

    public static int convert(String roman) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int value = romanToArabic.get(roman.charAt(i));

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }

        return result;
    }

    public static void main(String[] args) {
        String romanNumber = "XV"; // Замените на желаемое римское число
        int arabicNumber = convert(romanNumber);
        System.out.println("Римское число " + romanNumber + " равно " + arabicNumber + " в арабской нотации.");
    }
}