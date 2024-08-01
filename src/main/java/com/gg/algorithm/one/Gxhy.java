package com.gg.algorithm.one;

/**
 * 高效货运
 */
public class Gxhy {

    public static void main(String[] args) {

        int sum = 0;

        int wa = 10, wb = 8, wt = 36, pa = 15, pb = 7;

        for(int i = 1; i<wt; i++){
            int waa = wa * i;
            if(waa > wt){
                break;
            }
            if((wt - waa) % wb == 0){
                int j = (wt - waa) / wb;
                sum = i*pa + j*pb;
                break;
            }
        }
        System.out.println(sum);

    }

}
