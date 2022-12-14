package Labs.L03Inheritance.P04RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random random;

    public Object getRandomElement() {
        int index = this.random.nextInt(super.size());
        Object element = super.get(index);
        super.remove(index);
        return element;
    }
}
