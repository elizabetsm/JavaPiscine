package edu.school21.program.reflectionDAO;

import edu.school21.program.PrivateClass;
import edu.school21.program.ReflectionDao;
import edu.school21.program.models.Car;
import edu.school21.program.models.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class UserReflectionDAO implements ReflectionDao {

    Class<User> usrClass = User.class;

    @Override
    public void getDeclaredFields() {
        Field[] declaredFields = usrClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    @Override
    public void getDeclaredMethods() {
        System.out.println("-----------------------");
        System.out.println("Methods are:");

        Method[] methods = usrClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }

    @Override
    public PrivateClass creatingObj(Scanner scanner) {
        User usr = null;
        System.out.println("Let's create an object.\nName:");
        String str = scanner.next();
        System.out.println("lastName:");
        String str2 = scanner.next();
        System.out.println("height:");
        int i = scanner.nextInt();
        try {
            usr = usrClass.getConstructor(String.class, String.class, Integer.class).newInstance(str,
                    str2, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Object created: " + usr);
        return usr;
    }

    @Override
    public void changeField(Scanner scanner, PrivateClass privateClass) {
        String field = scanner.next();
        System.out.println("Enter String value:");
        String value = scanner.next();
        Field fieldTochange = null;
        try {
            fieldTochange = privateClass.getClass().getDeclaredField(field);
            fieldTochange.setAccessible(true);
            fieldTochange.set(privateClass, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Object updated: " + privateClass);
    }

    @Override
    public void callingMethod(Scanner scanner, PrivateClass privateClass) {

    }
}
