package Inheritance._05RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<String> {

    private Random rnd;

    public Object getRandomElement(){

        int index = this.rnd.nextInt(super.size());

        return super.remove(index);
    }

}
