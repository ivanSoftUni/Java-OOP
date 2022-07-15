package Abstraction._04TrafficLights;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       List<String> colors =  Arrays.stream(scanner.nextLine().split(" "))
               .collect(Collectors.toList());
       List<TrafficLight> trafficLights = new ArrayList<>();
        for (String color : colors) {
            Color currentColor = Color.valueOf(color);
            TrafficLight currentTrafficLight = new TrafficLight(currentColor);
            trafficLights.add(currentTrafficLight);
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (TrafficLight light : trafficLights) {
                light.changeColor();
                System.out.print(light.getCurrentColor() + " ");
            }
            System.out.println();
        }



    }
}
