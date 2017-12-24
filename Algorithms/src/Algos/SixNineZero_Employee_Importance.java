package Algos;

import java.util.*;

public class SixNineZero_Employee_Importance {

    // Employee info
    private static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {

        if (employees == null || employees.size() == 0) {
            return 0;
        }

        Map<Integer, Employee> mp = new HashMap<>();

        // store all the employees into a map <id, employee>
        for (Employee emp : employees) {
            mp.put(emp.id, emp);
        }

        Queue<Employee> que = new LinkedList<>();

        int ret = 0;

        if (!mp.containsKey(id)) {
            return 0;
        }

        Employee e = mp.get(id);

        que.offer(e);
        // bfs
        while (!que.isEmpty()) {
            Employee ee = que.poll();
            ret += ee.importance;
            if (ee.subordinates.size() > 0) {
                for (Integer i : ee.subordinates) {
                    que.offer(mp.get(i));
                }
            }
        }

        return ret;
    }
}

