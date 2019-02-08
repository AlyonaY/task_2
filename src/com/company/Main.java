package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n =3;
        System.out.println("введите " + n + " числа");
        Scanner scanner = new Scanner(System.in);
        int[] len = new int[n];
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            Integer ter = scanner.nextInt();
            mas[i] = ter;
            len[i] = String.valueOf(Math.abs(ter)).length();
        }
        max_min_leng(n, len, mas);
        order(n, len, mas);
        aver_leng(n, len, mas);
    }

    //3
    private static void aver_leng(int n, int[] len, int[] mas) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += len[i];
        }
        sum /= n;
        System.out.println("Числа, длина которых меньше средней: ");
        for (int i = 0; i < n; i++) {
            if (len[i] < sum) {
                System.out.println("Число - " + mas[i] + " и его длина - " + len[i]);
            }
        }
        System.out.println();
        System.out.println("Числа, длина которых больше средней: ");
        for (int i = 0; i < n; i++) {
            if (len[i] > sum) {
                System.out.println("Число - " + mas[i] + " и его длина - " + len[i]);
            }
        }
    }

    //2
    private static void order(int n, int[] len, int[] mas) {
        for (int i = 0; i < n-1; i++) {
            if (len[i] > len[i + 1]) {
                int tmp = mas[i];
                mas[i] = mas[i + 1];
                mas[i + 1] = tmp;
            }
        }
        for (int x:mas) {
            System.out.print(x + " ");
        }
        System.out.println(" ");
        for (int i = n-1; i >= 0; i--) {
            System.out.print(mas[i] + " ");
        }
    }

    //1
    private static void max_min_leng(int n, int[] len, int[] mas) {
        int max = 0;
        int maxn = 0;
        int min = 0;
        int minn = 0;
        for (int i = 0; i < n-1; i++) {
            if (len[i] < len[i + 1]) {
                min = len[i];
                minn = mas[i];
                max = len[i + 1];
                maxn = mas[i + 1];
            } else if (len[i] > len[i+1]) {
                max = len[i];
                maxn = mas[i];
                min = len[i + 1];
                minn = mas[i + 1];
            }
        }
        System.out.println("Самое длинное число: " + maxn + ". Его длина - " + max + " символов");
        System.out.println("Самое короткое число: " + minn + ". Его длина - " + min + " символов");
    }
}
