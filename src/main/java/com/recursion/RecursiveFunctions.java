package com.recursion;

import java.util.List;

public class RecursiveFunctions {

    public static int recursiveIndexOf(List<String> list, String target) {
        if (list.isEmpty()) {return -1;}
        if (list.get(0).equals(target)) {return 0;}

        int indexInRest = recursiveIndexOf(list.subList(1, list.size()), target);

        if (indexInRest == -1) {
            return -1;
        }

        return 1 + indexInRest;
    }

    public static int recursiveIndexOfByIndex(List<String> list, String target, int index) {
        if (index >= list.size()) {
            return -1;
        }
        if (list.get(index).equals(target)) {
            return index;
        }
        return recursiveIndexOfByIndex(list, target, index + 1);
    }

    public static int recursiveIndexOfEmpty(List<String> list) {
        if (list.isEmpty()) {return -1;}
        if (list.get(0).equals("")) {return 0;}
        int indexInRest = recursiveIndexOfEmpty(list.subList(1, list.size()));
        return (indexInRest == -1) ? -1 : indexInRest + 1;

    }

    public static int recursivePut(String target, List<String> list) {
        if (list.isEmpty()) {return -1;}
        if (list.get(0).equals("")) {
            list.set(0, target);
            return 0;
        }
        int indexInRest = recursiveIndexOfEmpty(list.subList(1, list.size()));
        return (indexInRest == -1) ? -1 : indexInRest + 1;
    }

    public static int recursiveRemove(List<String> list, String target) {
        if (list.isEmpty()) {return 0;}

        int eliminations = 0;

        if (list.get(0).equals(target)) {
            list.remove(0);
            eliminations = 1;
            eliminations += recursiveRemove(list, target);
        }
        else {
            eliminations += recursiveRemove(list.subList(1, list.size()), target);
        }

        return eliminations;
    }

    public static int recursiveSum(List<Integer> list) {
        if (list.isEmpty()){
            return 0;
        }
        return list.get(0) + recursiveSum(list.subList(1, list.size()));
    }

    public static int recursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * recursiveFactorial(n - 1);
    }

    public static int recursivePow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        return base * recursivePow(base, exponent - 1);
    }

    public static int recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static boolean recursivePalindrome(String word) {

        if (word.length() <= 1) {
            return true;
        }

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        return recursivePalindrome(word.substring(1, word.length() - 1));
    }


}