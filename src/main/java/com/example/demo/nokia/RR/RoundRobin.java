package com.example.demo.nokia.RR;


import java.util.ArrayList;

public class RoundRobin {

    int i = 0;
    int n;
    private ArrayList<String> list;


    public RoundRobin(ArrayList<String> list) {
        this.list = new ArrayList<String>();
        this.list.addAll(list);
        n = this.list.size();

    }

    public String next(int j) {
        //int temp = 0;
//        if(temp==1) {
//            i++;
//            i=i%n;
//            return list.get(0);
//        }
        j++;
        i = j % n;
        return list.get(i);


    }

    public static void main(String[] args) {
        int i, m = 0, flag = 0;
        int n = 2;//it is the number to be checked
        m = n / 2;
        if (n == 0 || n == 1) {
            System.out.print(n + "is not a prime number");
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    System.out.println(n + "is not prime number");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(n + "is prime number");
            }

        }

    }
}






// if we get to the end, start again

