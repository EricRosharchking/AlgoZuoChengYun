package lesson12;

import java.util.List;

public class MaxHappinessOfParty {

    public static int maxHappinessOfParty(Employee boss) {
        Info info = processEmployee(boss);
        return Math.max(info.absentMaxHappiness, info.presentMaxHappiness);
    }

    public static class Employee {
        public int happiness;
        public List<Employee> subordinates;
        public Employee(int happiness, List<Employee> subordinates) {
            this.happiness = happiness;
            this.subordinates = subordinates;
        }
    }

    public static class Info {
        public int presentMaxHappiness;
        public int absentMaxHappiness;
        public Info (int presentMaxHappiness, int absentMaxHappiness) {
            this.presentMaxHappiness = presentMaxHappiness;
            this.absentMaxHappiness = absentMaxHappiness;
        }
    }

    public static Info processEmployee (Employee head) {
        if(head.subordinates.isEmpty()) {
            return new Info(head.happiness, 0);
        }
        int presentMaxHappiness = head.happiness;
        int absentMaxHappiness = 0;
        for (Employee e: head.subordinates) {
            Info info = processEmployee(e);
            presentMaxHappiness += info.absentMaxHappiness;
            absentMaxHappiness += Math.max(info.presentMaxHappiness, info.absentMaxHappiness);
        }
        return new Info(presentMaxHappiness, absentMaxHappiness);
    }
}
