package com.example.demo.nokia.RR;


import java.util.ArrayList;

public class RoundRobin {

    int i = 0;
    int n;
    private ArrayList<String> list;


    public RoundRobin(ArrayList<String> list) {
        this.list = new ArrayList<String>();
        this.list.addAll(list);
        n=this.list.size();

    }

    public String next(int j) {
        //int temp = 0;
//        if(temp==1) {
//            i++;
//            i=i%n;
//            return list.get(0);
//        }
         j++;
         i=j%n;
        return list.get(i);


    }

    public static void main(String[] args) {

        String hey="i am mutturaj deval timeout";
        if(hey.contains("i am mutturaj deval timeout")) {
            System.out.println(true);
        }
        ArrayList<String> ls=new ArrayList<>();
        ls.add("111");
        ls.add("222");
        ls.add("333");
        RoundRobin r=new RoundRobin(ls);
        for (int i=0;i<=10;i++) {


        }


    }
}
// if we get to the end, start again

