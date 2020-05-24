package com.DataStructureAndAlgorithms.Stacks;

import com.DataStructureAndAlgorithms.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

//Challenge #1: Determine whether the strings are palindromes using a stack data structure
public class Challenge1 {
    public static void main(String[] args) {
        System.out.println(palindromeOrNot("I did, did I?"));
        System.out.println(palindromeOrNot("Hello"));
        System.out.println(palindromeOrNot("Racecar"));
    }

    public static boolean palindromeOrNot(String gram) {
        StringBuilder sb = new StringBuilder(gram.toLowerCase());
        CharacterLinkedListStack stack = new CharacterLinkedListStack();

        for(int index = 0; index < sb.length(); index++)
            if(sb.charAt(index) < 'a' || sb.charAt(index) > 'z')
                sb.deleteCharAt(index);
        if(sb.length() % 2 == 1) sb.deleteCharAt(sb.length()/2);

        for(int index = 0; index <= sb.length()/2 + 1; index++) {
            stack.push(sb.charAt(0));
            sb.deleteCharAt(0);
        }

        StringBuilder chars = new StringBuilder("");
        while(!stack.isEmpty())
            chars.append(stack.pop());

        return chars.toString().equals(sb.toString());
    }

    static class CharacterLinkedListStack {
        private LinkedList<Character> stack;

        public CharacterLinkedListStack() {
            stack = new LinkedList<>();
        }

        public void push(Character c) {
            stack.push(c);
        }

        public Character pop() {
            return stack.pop();
        }

        public Character peek() {
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void printStack() {
            ListIterator<Character> iter = stack.listIterator();

            while(iter.hasNext())
                System.out.println(iter.next());
        }
    }
}
