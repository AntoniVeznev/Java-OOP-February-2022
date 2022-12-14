package Labs.L03Inheritance.P05StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings(List<String> data) {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if (!data.isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        }
        return null;
    }

    public String peek() {
        if (!data.isEmpty()) {
            return this.data.get(this.data.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        if (data.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
