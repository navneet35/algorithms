package com.algorithms.tree;

import java.util.Arrays;
import java.util.List;

/**
 * @author - navsinn
 * Asked in: Google Telephonic
 * There is a hierarchy of employees in a company e.g.
 *                   CEO
 *                |   |       |
 *              CTO  CMO    CFO
 *              |||   ||     |
 *              EM's  AMO's  AFO's
 * There is a max response time associated to every employee in which he would send the email from his manager to his
 * direct reporteesexcept CEO and the employees who have no direct reportees. What would be the max time in which the
 * email from CEO would be received by every employee in the company. Assume CEO has 0 time.
 * Design a data structure for the same.
 */
public class MaxCommunicationTimeToEveryEmployee {
    //Data Structure for the problem
    class Employee {
        String empId;
        int timeUnit;
        List<Employee> reportees;
        Employee(String empId, int timeUnit, List<Employee> reportees) {
            this.empId = empId;
            this.timeUnit = timeUnit;
            this.reportees = reportees;
        }
    }

    class MaxTime {
        int maxTime;
        MaxTime(int maxTime) {
            this.maxTime = maxTime;
        }
    }

    public static void main(String[] args) {
        MaxCommunicationTimeToEveryEmployee maxCommunicationTimeToEveryEmployee = new MaxCommunicationTimeToEveryEmployee();
        maxCommunicationTimeToEveryEmployee.start();
    }

    public void start() {
        Employee ceo = createOrg();
        MaxTime maxTime = new MaxTime(0);
        maxTimeForEmailReachTime(ceo, maxTime, 0);
        System.out.println(maxTime.maxTime);
    }

    private Employee createOrg() {
        Employee sde1_1 = new Employee("sde1_1", 0, null);
        Employee em_1 = new Employee("em_1", 5, Arrays.asList(sde1_1));

        Employee sde2_1 = new Employee("sde2_1", 0, null);
        Employee tl_2 = new Employee("tl_2", 5, Arrays.asList(sde2_1));
        Employee em_2 = new Employee("em_2", 3, Arrays.asList(tl_2));
        Employee cto_1 = new Employee("cto_1", 2, Arrays.asList(em_1, em_2));

        Employee smo_1 = new Employee("smo_1", 0, null);
        Employee amo_1 = new Employee("amo_1", 8, Arrays.asList(smo_1));
        Employee cmo_1 = new Employee("cmo_1", 3, Arrays.asList(amo_1));

        Employee sfo_1 = new Employee("sfo_1", 0, null);
        Employee afo_1 = new Employee("afo_1", 4, Arrays.asList(sfo_1));

        Employee afo_2 = new Employee("afo_2", 0, null);

        Employee sfo_3 = new Employee("sfo_3", 0, null);
        Employee afo_3 = new Employee("afo_3", 11, Arrays.asList(sfo_3));
        Employee cfo_1 = new Employee("cfo_1", 1, Arrays.asList(afo_1, afo_2, afo_3));

        Employee ceo = new Employee("ceo", 0, Arrays.asList(cto_1, cmo_1, cfo_1));
        return ceo;
    }

    private void maxTimeForEmailReachTime(Employee e, MaxTime maxTime, int sumTime) {
        if(e == null) {
            return;
        }
        sumTime += e.timeUnit;
        if(e.reportees == null || e.reportees.size() == 0){
            if(maxTime.maxTime < sumTime) {
                maxTime.maxTime = sumTime;
            }
            return;
        }

        for(Employee r : e.reportees) {
            maxTimeForEmailReachTime(r, maxTime, sumTime);
        }
    }
}
