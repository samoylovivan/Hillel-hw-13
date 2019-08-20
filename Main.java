package ivan.samoylov;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass(123, "abcd");
        int number = someClass.getNumber();
        String name = null;
        System.out.println(number + name);
        try {
            Field field = someClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(someClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(number + name);
        printData(someClass);
    }

    public static void printData(Object myClass){
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
