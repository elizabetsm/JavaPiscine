package edu.school21.program.reflectionDAO;

import edu.school21.program.PrivateClass;
import edu.school21.program.ReflectionDao;
import edu.school21.program.models.Car;
import edu.school21.program.models.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class CarReflectionDAO implements ReflectionDao {
    Class<Car> carClass = Car.class;

    public void getDeclaredFields() {
        Field[] declaredFields = carClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    public void getDeclaredMethods() {
        System.out.println("-----------------------");
        System.out.println("Methods are:");

        Method[] methods = carClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    @Override
    public PrivateClass creatingObj(Scanner scanner) {
        System.out.println("Let's create an object.\nBrand:");
        String str = scanner.next();
        System.out.println("Color:");
        String str2 = scanner.next();
        System.out.println("Speed:");
        int i = scanner.nextInt();
        Car car = null;
        try {
            car = carClass.getConstructor(String.class, String.class, Integer.class).newInstance(str,
                    str2, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Object created: " + car);
        return car;
    }

    public void changeField(Scanner scanner, PrivateClass privateClass) {
        String field = scanner.next();
        System.out.println("Enter String value:");
        String value = scanner.next();
        Field fieldTochange;
        try {
            fieldTochange = privateClass.getClass().getDeclaredField(field);
            fieldTochange.setAccessible(true);
            fieldTochange.set(privateClass, value);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Object not updated");
            return;
        }
        System.out.println("Object updated: " + privateClass);
    }

    public void callingMethod(Scanner scanner, PrivateClass privateClass) {

        System.out.println("Enter name of the method for call:");
        String methodToCall = scanner.next();
        System.out.println("Enter int value:");
        int arg = scanner.nextInt();
        Method method = null;
        try {
            method = privateClass.getClass().getDeclaredMethod("increment", Integer.TYPE);
            method.setAccessible(true);
            Object ret = method.invoke(privateClass, arg);
            Integer retVal = (Integer) ret;
            System.out.println(retVal.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

