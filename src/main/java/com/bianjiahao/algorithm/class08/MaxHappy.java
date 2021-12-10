package com.bianjiahao.algorithm.class08;

import java.util.ArrayList;
import java.util.List;

/**
 * 排队的最大快乐值
 * @author BianJiaHao
 */
public class MaxHappy {

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
            this.nexts = new ArrayList<>();
        }
    }

    public static class Info {
        int yes;
        int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    public static int maxHappy(Employee boss) {
        if (boss == null){
            return 0;
        }
        Info all = getMaxHappy(boss);
        return Math.max(all.yes,all.no);
    }

    public static Info getMaxHappy(Employee x) {
        if (x.nexts.isEmpty()){
            return new Info(x.happy,0);
        }
        int yes = x.happy;
        int no = 0;
        for (Employee next : x.nexts) {
            Info nextInfo = getMaxHappy(next);
            yes += nextInfo.no;
            no += Math.max(nextInfo.yes,nextInfo.no);
        }
        return new Info(yes,no);
    }
}
