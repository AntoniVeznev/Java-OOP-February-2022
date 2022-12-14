package Labs.L06Reflection.P02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Reflection.class.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(getters).forEach(e -> System.out.printf("%s will return class %s%n", e.getName(), e.getReturnType().getName()));
        Method[] setters = Arrays.stream(methods)
                .filter(g -> g.getName().startsWith("set") && g.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(setters).forEach(e -> System.out.printf("%s and will set field of class %s%n", e.getName(), e.getParameterTypes()[0].getName()));
    }
}