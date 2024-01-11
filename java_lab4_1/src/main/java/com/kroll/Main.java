package com.kroll;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println(isTextPalindrome("ABOBA"));
        System.out.println(isTextPalindrome("Абоба"));
        System.out.println(isTextPalindrome("Не паліндром"));
        System.out.println(isTextPalindrome("Уму мінімуму"));
        System.out.println(isTextPalindrome("І розморозь зором зорі"));
        System.out.println(isTextPalindrome("Три психи пили Пилипихи спирт"));


        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Введіть слово або речення для перевірки на паліндром:");
            String inputText = scanner.nextLine();

            boolean isPalindrome = isTextPalindrome(inputText);

            if (isPalindrome) {
                System.out.println("Введений текст є паліндромом.");
            } else {
                System.out.println("Введений текст не є паліндромом.");
            }
        }
}

    public static boolean isTextPalindrome(String text) {
        if (text == null) {
            return false;
        }

        var chars = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
        var left = 0;
        var right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

