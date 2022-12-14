package Labs.L01WorkingWithAbstraction.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public void parseCommand(String[] args) {
        String name = args[1];
        if (args[0].equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!repository.containsKey(name)) {
                Student student = new Student(name, age, grade);
                repository.put(name, student);
            }
        } else {
            if (repository.containsKey(name)) {
                Student student = repository.get(name);
                String view = String.format("%s is %s years old.", student.getName(), student.getAge());
                view = checkGrades(student, view);
                System.out.println(view);
            }
        }
    }

    private String checkGrades(Student student, String view) {
        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }
        return view;
    }
}
