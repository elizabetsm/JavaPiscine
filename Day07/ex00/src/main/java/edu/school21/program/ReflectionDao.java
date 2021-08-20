package edu.school21.program;

import java.util.Scanner;

public interface ReflectionDao {
    void getDeclaredFields();
    void getDeclaredMethods();
    PrivateClass creatingObj(Scanner scanner);
    void changeField(Scanner scanner, PrivateClass privateClass);
    void callingMethod(Scanner scanner, PrivateClass privateClass);
}
