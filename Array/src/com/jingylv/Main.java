package com.jingylv;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(10);
        arr.addLast(30);
        arr.addFirst(1);
        for (int i = 0; i < arr.getSize(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println(arr);
    }
}
