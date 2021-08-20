package edu.school21.program.app;

import edu.school21.program.PrivateClass;
import edu.school21.program.ReflectionDao;
import edu.school21.program.reflectionDAO.CarReflectionDAO;
import edu.school21.program.reflectionDAO.UserReflectionDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Classes:\n" +
                "User\nCar\n" +
                "---------------------\nEnter class name:");
        String className = scanner.next();
        ReflectionDao dao;

        if (className.equals("Car")){
             dao = new CarReflectionDAO();
        } else {
            dao = new UserReflectionDAO();
        }


        dao.getDeclaredFields();
        dao.getDeclaredMethods();
    PrivateClass pclass =  dao.creatingObj(scanner);



        System.out.println("---------------------\nEnter name of the field for changing:");
        dao.changeField(scanner, pclass);
        System.out.println("---------------------\nEnter name of the method for call:");
        dao.callingMethod(scanner, pclass);
    }
}
