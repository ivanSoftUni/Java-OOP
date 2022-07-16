package Encapsulation._02AnimalFarm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggs = 0;
        if (age < 6) {
            eggs = 2;
        } else if (age < 12) {
            eggs = 1;
        } else if (age <= 15) {
            eggs = 0.75;
        }
        return eggs;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }
}
