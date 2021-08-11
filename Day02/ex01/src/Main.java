import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputFilesHandler inputFilesHandler = new InputFilesHandler();
        Similarity similarity = new Similarity();

        List<String> list = new ArrayList<>();

        list.add(args[0]);
        list.add(args[1]);
        inputFilesHandler.readFile(list);
        inputFilesHandler.createVector(inputFilesHandler.createDictionary());

        System.out.println(inputFilesHandler.getListOfVectors());
    }
}