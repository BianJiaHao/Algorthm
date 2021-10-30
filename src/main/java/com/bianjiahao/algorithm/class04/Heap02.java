package com.bianjiahao.algorithm.class04;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Author Obito
 * @Date 2021/10/30 5:19 下午
 * 手写堆结构，用于在改变了已经添加到堆中对象的属性后，能够依然保持堆的结构
 */
public class Heap02 {
    public static class MyHeap<T>{
        // 定义一个可变容量的堆
        private ArrayList<T> heap;
        // 定义一个用于保存堆中对象下标的map
        private HashMap<T,Integer> indexMap;
        // 定义堆的大小
        private Integer heapSize;
        // 自定义比较器
        private Comparator<? super T> comparator;

        // 构造器
        public MyHeap(Comparator<? super T> comparator) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            this.comparator = comparator;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public int size() {
            return heapSize;
        }

        public boolean contains(T key) {
            return indexMap.containsKey(key);
        }

        // 往堆中添加元素
        public void push(T value){
            heap.add(value);
            indexMap.put(value,heapSize);
            heapInsert(heapSize++);
        }

        // 弹出堆中的元素
        public T pop(){
            T ans = heap.get(0);
            int endindex = heapSize - 1;
            swap(0,endindex);
            heap.remove(endindex);
            indexMap.remove(ans);
            heapify(0,--heapSize);
            return ans;
        }

        // 改变了堆中元素的值后依然保持堆的机构
        public void resign(T value){
            Integer index = indexMap.get(value);
            heapify(index,heapSize);
            heapInsert(index);
        }

        private void heapInsert(int index) {
            while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && (comparator.compare(heap.get(left + 1), heap.get(left)) < 0)
                        ? left + 1
                        : left;
                largest = comparator.compare(heap.get(largest), heap.get(index)) < 0 ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void swap(int i, int j) {
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            heap.set(i, o2);
            heap.set(j, o1);
            indexMap.put(o1, j);
            indexMap.put(o2, i);
        }
    }
}
