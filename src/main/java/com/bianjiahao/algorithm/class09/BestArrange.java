package com.bianjiahao.algorithm.class09;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最好的会议安排
 * @author Obito
 */
public class BestArrange {

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int violence(Program[] programs){
        if (programs == null || programs.length == 0){
            return 0;
        }
        return process(programs, 0, 0);
    }

    public static int process(Program[] programs, int done, int timeLine) {
        if (programs.length == 0) {
            return done;
        }
        int max = done;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeLine) {
                Program[] next = copyButExcept(programs, i);
                max = Math.max(max, process(next, done + 1, programs[i].end));
            }
        }
        return max;
    }

    public static Program[] copyButExcept(Program[] programs, int i) {
        Program[] ans = new Program[programs.length - 1];
        int index = 0;
        for (int k = 0; k < programs.length; k++) {
            if (k != i) {
                ans[index++] = programs[k];
            }
        }
        return ans;
    }

    public static class MyComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int greedArrange(Program[] programs){
        Arrays.sort(programs,new MyComparator());
        int timeLine = 0;
        int size = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timeLine <= programs[i].start){
                size++;
                timeLine = programs[i].end;
            }
        }
        return size;
    }
}
