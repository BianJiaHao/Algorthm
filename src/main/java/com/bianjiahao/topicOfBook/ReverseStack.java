package com.bianjiahao.topicOfBook;

import java.util.Stack;

/**
 * 仅使用递归函数和栈操作逆序一个栈
 * @Author Obito
 * @Date 2021/12/12 2:29 下午
 */
public class ReverseStack {

    /**
     * 将栈逆序
     * @param stack 需要逆序的栈
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 弹出并返回栈底的元素
     * @param stack 栈
     * @return 栈底的元素
     */
    public static int getAndRemoveLast(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }
    }
}
