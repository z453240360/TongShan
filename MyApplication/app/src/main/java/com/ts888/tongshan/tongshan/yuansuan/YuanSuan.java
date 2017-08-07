package com.ts888.tongshan.tongshan.yuansuan;

import java.util.ArrayList;

/**
 * Created by dongdong on 2017/8/5.
 */

public class YuanSuan {


    public static ArrayList<Integer> getNumber(int s) {

        switch (s) {
            case 30:
                ArrayList<Integer> integers30 = new ArrayList<>();

                integers30.add(2);
                integers30.add(4);
                integers30.add(8);
                integers30.add(16);
                return integers30;

            case 28:
                ArrayList<Integer> integers28 = new ArrayList<>();

                integers28.add(4);
                integers28.add(8);
                integers28.add(16);
                return integers28;
            case 26:
                ArrayList<Integer> integers26 = new ArrayList<>();
                integers26.add(2);
                integers26.add(8);
                integers26.add(16);
                return integers26;
            case 24:
                ArrayList<Integer> integers24 = new ArrayList<>();

                integers24.add(8);
                integers24.add(16);
                return integers24;
            case 22:
                ArrayList<Integer> integers22 = new ArrayList<>();

                integers22.add(2);
                integers22.add(4);
                integers22.add(16);
                return integers22;
            case 20:
                ArrayList<Integer> integers20 = new ArrayList<>();

                integers20.add(4);
                integers20.add(16);
                return integers20;
            case 18:
                ArrayList<Integer> integers18 = new ArrayList<>();

                integers18.add(2);
                integers18.add(16);
                return integers18;
            case 16:
                ArrayList<Integer> integers16 = new ArrayList<>();
                integers16.add(16);
                return integers16;
            case 14:
                ArrayList<Integer> integers14 = new ArrayList<>();

                integers14.add(2);
                integers14.add(4);
                integers14.add(8);
                return integers14;
            case 12:
                ArrayList<Integer> integers = new ArrayList<>();

                integers.add(4);
                integers.add(8);
                return integers;
            case 10:
                ArrayList<Integer> integers10 = new ArrayList<>();

                integers10.add(2);
                integers10.add(8);
                return integers10;
            case 8:
                ArrayList<Integer> integers8 = new ArrayList<>();

                integers8.add(8);
                return integers8;
            case 6:
                ArrayList<Integer> integers6 = new ArrayList<>();

                integers6.add(2);
                integers6.add(4);
                return integers6;
            case 4:
                ArrayList<Integer> integers4 = new ArrayList<>();

                integers4.add(4);
                return integers4;
            case 2:
                ArrayList<Integer> integers2 = new ArrayList<>();

                integers2.add(2);
                return integers2;
            case 1:
                ArrayList<Integer> integers1 = new ArrayList<>();
                integers1.add(2);
                integers1.add(4);
                integers1.add(8);
                integers1.add(16);
                return integers1;
            case 0:
                ArrayList<Integer> integers0 = new ArrayList<>();
                integers0.add(888);
                return integers0;

        }
        return null;
    }
}

