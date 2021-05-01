package leetcode.clockIn;

import java.util.List;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/5/1 9:21
 */
public class Main690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }


    public int getImportance(List<Employee> employees, int id) {
        Employee e = new Employee();
        for (Employee emp:employees
             ) {
            if(emp.id==id){
                e=emp;
                break;
            }
        }
        Employee finalE = e;
        return employees.stream().filter(tmpEmp -> finalE.subordinates.contains(tmpEmp.id)).mapToInt(tmpEmp -> tmpEmp.importance).sum()+finalE.importance;
    }
}
