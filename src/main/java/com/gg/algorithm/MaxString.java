package com.gg.algorithm;

/**
 * 最大回文字符串
 */
public class MaxString {

    public static String maxStr = null;

    public static void main(String[] args) {
        String str = "dwweabbafee";
        System.out.println(maxStringByCenter(str));
    }

    /**
     * 最长回文字符串，中心扩散法
     * 考虑 aba、abba 两种情况
     * @param str
     * @return
     */
    public static String maxStringByCenter(String str){
        if(str.isEmpty()){
            return null;
        }
        int start = 0, end = 0, max = 0;
        char[] ss = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int len1 = findStrByCenter(ss, i, i); // aba
            int len2 = findStrByCenter(ss, i, i+1); // abba
            int len = Math.max(len1, len2);
            if(len > max) {
                max = len;
                start = i - (len -1)/2;
                end = start + max;
            }
        }
        return str.substring(start, end);
    }

    /**
     * 向两边扩散
     * @param ss
     * @param left
     * @param right
     * @return
     */
    private static int findStrByCenter( char[] ss, int left, int right) {
        while (left>=0 && right<ss.length && ss[left] == ss[right]){
            left--;
            right++;
        }
        return right - left - 1;
    }

}
