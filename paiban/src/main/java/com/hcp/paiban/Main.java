package com.hcp.paiban;

import java.util.Calendar;
import java.util.Locale;

import com.hcp.paiban.model.EngineerGroup;
import com.hcp.paiban.service.EngineerGroupService;

/**
 * Hello world!
 * 
 */
public class Main {

    public static void main(String[] args) {

        EngineerGroup engineerGroupA = new EngineerGroupService().findEngineerGroup("A");

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        // 设置9月份
        calendar.set(Calendar.YEAR, 2013);
        calendar.set(Calendar.MONTH, 8);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.getTime().toString());

        // 循环这个月的每一天，如果是周末则设置人员
        int maxday = calendar.getActualMaximum(Calendar.DATE);
        System.out.println(maxday);
        for (int i = 0; i < maxday; i++) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == 1 || dayOfWeek == 7) {
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + ":");
                System.out.println(engineerGroupA.getEngineers().removeFirst().getName());
            }
            calendar.add(Calendar.DATE, 1);

        }

    }
}
