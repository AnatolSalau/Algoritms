import java.util.*;

public class FindNameTree {
      /**
       Find name of employee
       */
      public static void main(String[] args) {
            //testOne();
            testTwo();
      }

      String getPathToEmployeeInWidth(Employee root, String name) {
            StringBuilder path = new StringBuilder();

            Queue<Employee> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                  Employee curr = queue.poll();
                  String currName = curr.name;
                  path.append(currName + " -> ");

                  if (currName.equals(name)) return path.toString();

                  List<Employee> employees = curr.employees;

                  if (employees == null) continue;

                  for (Employee employee : employees) {
                        queue.add(employee);
                  }
            }

            return path.toString();
      }

      String getPathToEmployeeInDepth(Employee root, String name) {
            StringBuilder path = new StringBuilder();

            Stack<Employee> queue = new Stack<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                  Employee curr = queue.pop();
                  String currName = curr.name;
                  path.append(currName + " -> ");

                  if (currName.equals(name)) return path.toString();

                  List<Employee> employees = curr.employees;

                  if (employees == null) continue;

                  for (Employee employee : employees) {
                        queue.add(employee);
                  }
            }

            return path.toString();
      }
      static void testOne() {
            Employee employee1 = new Employee("employee1");
            Employee employee2 = new Employee("employee2");
            Employee employee3 = new Employee("employee3");

            Employee viceDirector1 = new Employee("viceDirector1", employee1,employee2,employee3);

            Employee employee4 = new Employee("employee4");
            Employee employee5 = new Employee("employee5");
            Employee employee6 = new Employee("employee6");

            Employee viceDirector2 = new Employee("viceDirector2", employee4, employee5, employee6);

            Employee director = new Employee("director", viceDirector1, viceDirector2);

            FindNameTree findNameTree = new FindNameTree();
            String path = findNameTree.getPathToEmployeeInWidth(director, "employee4");
            System.out.println(path);

      }

      static void testTwo() {
            Employee employee1 = new Employee("employee1");
            Employee employee2 = new Employee("employee2");
            Employee employee3 = new Employee("employee3");

            Employee viceDirector1 = new Employee("viceDirector1", employee1,employee2,employee3);

            Employee employee4 = new Employee("employee4");
            Employee employee5 = new Employee("employee5");
            Employee employee6 = new Employee("employee6");

            Employee viceDirector2 = new Employee("viceDirector2", employee4, employee5, employee6);

            Employee director = new Employee("director", viceDirector1, viceDirector2);

            FindNameTree findNameTree = new FindNameTree();
            String path = findNameTree.getPathToEmployeeInDepth(director, "employee4");
            System.out.println(path);

      }
      static class Employee {
            String name;
            List<Employee> employees;

            public Employee(String name) {
                  this.name = name;
                  this.employees = null;
            }

            public Employee(String name, Employee... employees) {
                  this.name = name;
                  this.employees = Arrays.asList(employees);
            }


            @Override
            public String toString() {
                  StringBuilder allEmployeeNames = new StringBuilder();
                  employees.forEach(
                        (employee -> {
                              allEmployeeNames.append(employee.name + " ");
                        })
                  );
                  return "Employee{" +
                        "name='" + name + '\'' +
                        ", employees=" + allEmployeeNames +
                        '}';
            }
      }
}
