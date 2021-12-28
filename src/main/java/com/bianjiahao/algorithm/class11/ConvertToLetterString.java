package com.bianjiahao.algorithm.class11;

/**
 * 将对应的数字字符串转化为字母字符串
 * @author Obito
 */
public class ConvertToLetterString {

    public static int convertNumberToChar(String str) {
        if (str == null){
            return 0;
        }
        return process(str.toCharArray(),0);
    }

    public static int process(char[] chars, int index) {
        if (index == chars.length){
            return 1;
        }
        if (chars[index] == '0'){
            return 0;
        }
        if (chars[index] == '1'){
            int res = process(chars, index + 1);
            if (index + 1 < chars.length){
                res += process(chars,index + 2);
            }
            return res;
        }
        if (chars[index] == '2'){
            int res = process(chars, index + 1);
            if (index + 1 < chars.length && chars[index + 1] >= '0' && chars[index + 1] <= '6'){
                res += process(chars,index + 2);
            }
            return res;
        }
        return process(chars,index + 1);
    }

}
