package com.bianjiahao.topicOfBook;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * @Author Obito
 * @Date 2021/12/8 8:49 下午
 */
public class TwoStasksQueue {
    /**
     * 用来压入数据的栈
     */
    public Stack<Integer> stackOfPush;

    /**
     * 用来弹出数据的栈
     */
    public Stack<Integer> stackOfPop;

    /**
     * 同步将压入的数据压到弹出的栈中
     */
    public void pushToPop() {
        if (stackOfPop.isEmpty()){
            while (!stackOfPush.isEmpty()){
                stackOfPop.push(stackOfPush.pop());
            }
        }
    }

    /**
     * 压入数据
     * @param pushInt 要压入的数据
     */
    public void add(Integer pushInt) {
        stackOfPush.push(pushInt);
    }

    /**
     * 弹出数据
     * @return 弹出的数据
     */
    public int pull(){
        if (stackOfPop.isEmpty() && stackOfPush.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackOfPop.pop();
    }

    /**
     * 返回第一个数据并不弹出
     * @return 返回的数据
     */
    public int peek(){
        if (stackOfPop.isEmpty() && stackOfPush.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackOfPop.peek();
    }

}
