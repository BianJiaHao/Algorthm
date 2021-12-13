package com.bianjiahao.algorithm.class09;

/**
 * 路灯点亮问题
 * @author Obito
 */
public class Light {

    public static int greedProcess(String road){
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length){
            if (str[index] == 'X'){
                index++;
            }else {
                light++;
                if (index + 1 == str.length){
                    break;
                }else {
                    if (str[index + 1] == 'X'){
                        index = index + 2;
                    }else {
                        index = index + 3;
                    }
                }
            }
        }
        return light;
    }
}
