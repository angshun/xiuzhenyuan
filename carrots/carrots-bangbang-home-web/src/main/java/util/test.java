package util;

import sun.rmi.runtime.Log;

import java.sql.Array;
import java.sql.Time;
import java.util.TimeZone;

/**
 * Created by shun 2017.08.17.17 17:30
 */
public class test {
    public static void main(String[] args) {


        String[] str = {"hello", "word"};



        int[] i = {1, 2, 3, 4};

        System.out.println(str.length);
        System.out.println(str.clone());
        System.out.println(str.toString());
        System.out.println(i);

        for (String s : str) {
//            System.out.println(s);
            System.out.println(s.toString());

        }


        for (int i1 : i) {
            System.out.println(i1);
            System.out.println();
        }
        System.out.println(i.length);
        System.out.println(i.toString());
        System.out.println(i.clone());
        System.out.println(i.toString());

    }
}
