package dao;

import java.util.Scanner;

/**
 * @avthor yuan8
 * @Date 2023/1/5
 */
public class Random {
    public static String random(String[] people) {
        int i = (int)(Math.random()*(people.length-1));
        System.out.println(people[i]);
        return people[i];
    }
}
