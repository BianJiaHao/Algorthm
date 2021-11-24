package com.bianjiahao.algorithm.class06;

import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * 给定一个数，将单链表中小于这个数的放在单链表的左边，等于的放在中间，大于的放在右边
 * @author BianJiaHao
 */
public class SmallerEuqalBigger {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node listPartition1(Node head,int pivot){
        if (head == null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodes.length ; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodes,pivot);
        for(i = 1;i != nodes.length; i++){
            nodes[i - 1].next = nodes[i];
        }
        nodes[i - 1].next = null;
        return nodes[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static Node listPartition2 (Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if (head.value == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if (mH == null){
                    mH = head;
                    mT = head;
                }else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        if (sH != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null){
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }

}
