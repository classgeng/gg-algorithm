package com.gg.algorithm.one;

/**
 * 输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。判定S是否是L的有效字串。
 *
 * 判定规则：S中的每个字符在L中都能找到（可以不连续），且S在Ｌ中字符的前后顺序与S中顺序要保持一致。
 * （例如，S="ace"是L="abcde"的一个子序列且有效字符是a、c、e，而"aec"不是有效子序列，且有效字符只有a、e）
 */
public class StringOperate {

    public static void main(String[] args) {
        String S = "ace";
        String L = "abghcde";
        System.out.println(isCheck(S,L));
    }

    /**
     *
     * @param S
     * @param L
     * @return
     */
    public static boolean isCheck(String S, String L){
        if(S.length() > 100 || L.length() > 500000){
            return false;
        }
        int index = 0;
        char[] ss = S.toCharArray();
        for (int i=0; i<S.length(); i++){
            String str = String.valueOf(ss[i]);
            int currIndex = L.indexOf(str);
            if (currIndex < index) {
                return false;
            }
            index = currIndex;
        }
        return true;
    }

}
