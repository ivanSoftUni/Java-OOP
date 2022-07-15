package Abstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimestions[0];
        int cols = dimestions[1];

        int[][] galaxy = new int[rows][cols];

        fillInGalaxy(rows, cols, galaxy);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilPosition = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int currentEvilRow = evilPosition[0];
            int currentEvilCol = evilPosition[1];

            moveEvil(galaxy, currentEvilRow, currentEvilCol);

            int currentJediRow = jediPosition[0];
            int currentJediCol = jediPosition[1];

            sum = moveJedi(galaxy, sum, currentJediRow, currentJediCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long moveJedi(int[][] galaxy, long sum, int currentJediRow, int currentJediCol) {
        while (currentJediRow >= 0 && currentJediCol < galaxy[1].length) {
            if (currentJediRow >= 0 && currentJediRow < galaxy.length && currentJediCol >= 0 && currentJediCol < galaxy[0].length) {
                sum += galaxy[currentJediRow][currentJediCol];
            }

            currentJediCol++;
            currentJediRow--;
        }
        return sum;
    }

    private static void moveEvil(int[][] galaxy, int currentEvilRow, int currentEvilCol) {
        while (currentEvilRow >= 0 && currentEvilCol >= 0) {
            if (currentEvilRow < galaxy.length && currentEvilCol < galaxy[0].length) {
                galaxy[currentEvilRow][currentEvilCol] = 0;
            }
            currentEvilRow--;
            currentEvilCol--;
        }
    }

    private static void fillInGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                galaxy[i][j] = value++;
            }
        }
    }
}
