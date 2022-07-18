package Encapsulation._03ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();

        String[] personData = scanner.nextLine().split(";");
        for (String person : personData) {
            String[] info = person.split("=");
            try {
                Person person1 = new Person(info[0], Double.parseDouble(info[1]));
                people.put(info[0], person1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String[] productData = scanner.nextLine().split(";");

        for (String p : productData) {
            String[] productInfo = p.split("=");
            try {
                Product product = new Product(productInfo[0], Double.parseDouble(productInfo[1]));
                productMap.put(productInfo[0], product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] commandParts = command.split(" ");
            String personName = commandParts[0];
            String productName = commandParts[1];
            try {
                people.get(personName).buyProduct(productMap.get(productName));
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            command = scanner.nextLine();
        }
        for (Map.Entry<String, Person> entry : people.entrySet()) {
            if (entry.getValue().getProducts().size() > 0) {
                System.out.println(entry.getValue());
            } else {
                System.out.println("Nothing bought");
            }
        }
    }
}
