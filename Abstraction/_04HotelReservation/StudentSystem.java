package Abstraction._04HotelReservation;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentStore;

    public StudentSystem() {
        this.studentStore = new HashMap<>();
    }

    public void commandData(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] args = scanner.nextLine().split(" ");
        String command = args[0];

        if (command.equals("Create")) {
            createStudent(args);

        } else if (command.equals("Show")) {
            showAndPrintStudent(args[1]);
        }
    }

    private void showAndPrintStudent(String arg) {
        if (studentStore.containsKey(arg)) {
            var student = studentStore.get(arg);
            String view = String.format("%s is %s years old.", student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                view += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view += " Average student.";
            } else {
                view += " Very nice person.";
            }

            System.out.println(view);
        }
    }

    private void createStudent(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        if (!studentStore.containsKey(name)) {
            var student = new Student(name, age, grade);
            studentStore.put(name, student);
        }
    }
}
