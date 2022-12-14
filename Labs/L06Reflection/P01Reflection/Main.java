package Labs.L06Reflection.P01Reflection;

import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflection = Reflection.class;
        System.out.println(reflection);

        Class superClass = Reflection.class.getSuperclass();
        System.out.println(superClass);

        Class[] interfaces = reflection.getInterfaces();
        for (Class element : interfaces) {
            System.out.println(element);
        }

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
    }
}
