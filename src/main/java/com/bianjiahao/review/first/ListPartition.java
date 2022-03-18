package com.bianjiahao.review.first;

/**
 * @author admin
 */
public class ListPartition {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartitionUseArray(Node head,int pivot) {
        if (head == null) {
            return null;
        }
        int size = 0;
        Node cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        Node[] nodes = new Node[size];
        cur = head;
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodes,pivot);
        int i;
        for (i = 1; i <= nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        nodes[i - 1].next = null;
        return nodes[0];
    }

    public static void arrPartition(Node[] nodes,int pivot) {
        int small = -1;
        int big = nodes.length;
        int index = 0;
        while (index != big) {
            if (nodes[index].value > pivot) {
                swap(nodes,--big,index);
            }else if (nodes[index].value == pivot) {
                index++;
            }else {
                swap(nodes,++small,index);
            }
        }
    }

    public static void swap(Node[] nodes,int i,int j) {
        Node tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;
    }

    public static Node listPartitionOptimalSolution(Node head,int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                }else {
                    sT.next = head;
                }
                sT = head;
            }else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                }else {
                    eT.next = head;
                }
                eT = head;
            }else {
                if (mH == null) {
                    mH = head;
                }else {
                    mT.next = head;
                }
                mT = head;
            }

            head = next;
        }
        if (sH != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eH != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);

    }

}
