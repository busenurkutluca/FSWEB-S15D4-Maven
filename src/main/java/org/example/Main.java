package org.example;

import java.util.Stack;

public class Main {

    public static boolean checkForPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder cleanInput = new StringBuilder();

        // String'i temizle: Noktalama işaretlerini ve boşlukları kaldır, tüm harfleri küçült
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleanInput.append(Character.toLowerCase(c));
            }
        }

        // String'in yarısını stack'e ekle
        int len = cleanInput.length();
        for (int i = 0; i < len / 2; i++) {
            stack.push(cleanInput.charAt(i));
        }

        // Orta karakteri atla (tek uzunluktaysa)
        int start = (len % 2 == 0) ? len / 2 : len / 2 + 1;

        // Stack'ten çıkararak geri kalan kısmı kontrol et
        for (int i = start; i < len; i++) {
            if (stack.isEmpty() || stack.pop() != cleanInput.charAt(i)) {
                return false;
            }
        }

        return true;
    }
    public static String convertDecimalToBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder binaryResult = new StringBuilder();

        while (num > 0) {
            stack.push(num % 2);
            num = num / 2;
        }

        // Stack'teki tüm değerleri çıkartıp binary stringini oluştur
        while (!stack.isEmpty()) {
            binaryResult.append(stack.pop());
        }

        return binaryResult.toString();
    }
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?")); // true
        System.out.println(checkForPalindrome("Racecar")); // true
        System.out.println(checkForPalindrome("hello")); // false
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?")); // true


        System.out.println(convertDecimalToBinary(5)); // 101
        System.out.println(convertDecimalToBinary(6)); // 110
        System.out.println(convertDecimalToBinary(13)); // 1101
    }

}
