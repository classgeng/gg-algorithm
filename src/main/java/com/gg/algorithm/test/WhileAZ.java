package com.gg.algorithm.test;

import java.util.List;

public class WhileAZ {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(2e2);
        System.out.println(1e9);

        char cc = 'X';
        while(true){
            System.out.print(cc);
            if(cc == 'Z'){
                cc = 'A';
                System.out.println();
            }else {
                cc++;
            }
            Thread.sleep(100);
        }

      /*  for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println(c);
        }*/

    }
}
