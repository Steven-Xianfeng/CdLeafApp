package com.cdleaf.temp;

import java.util.ArrayList;
import java.util.List;

public class Learning {

    public static void main(String[] args) {

        List<Integer> taskQueue = new ArrayList<Integer>();

        int MAX_CAPACITY = 5;

        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");

        tProducer.start();
        tConsumer.start();

    }

    static void print(int i) {
        System.out.println(i);
    }

    static void print(String s) {
        System.out.println(s);
    }
}
