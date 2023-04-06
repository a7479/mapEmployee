package pro.sky.mapEmployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final Map <String,Employee> staff = new HashMap();


    public Employee addEmployee(String firstName, String lastName) {

        Employee temp = new Employee(firstName, lastName);
        if (staff.containsKey(temp.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }

        staff.put(temp.getFullName(), temp);
        return temp;


    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (staff.containsKey(temp.getFullName())) {
           return staff.remove(temp.getFullName());
        }

        throw new EmployeeAlreadyAddedException();


    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (staff.containsKey(temp.getFullName())) {
            return staff.get(temp.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(staff.values());
    }
}
