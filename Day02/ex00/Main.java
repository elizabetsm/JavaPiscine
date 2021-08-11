import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main{
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        String s = null;
        FileHandler fileHandler = new FileHandler();
        BytesHandler bytesHandler = new BytesHandler();

        try (FileInputStream fileInputStream = new FileInputStream("signatures.txt")){
           int bytes = fileInputStream.available();
           byte[] arr = new byte[bytes];
           if (fileInputStream.read(arr) > 0){
              s = new String(arr, StandardCharsets.UTF_8);
           }
        } catch (Exception e){
            e.printStackTrace();
        }

//        Map<String, String> signatures = null;
        if (s != null) {
            fileHandler.splitLine(s);
        } else {
            System.out.println("File signatures.txt is empty");
            System.exit(1);
        }
        fileHandler.createFile();
        while (true){
            fileHandler.findFileSignature(bytesHandler.proceedFileBytes(scanner));
        }

    }












//    public static String

}









//        byte[] arr = new byte[8];
//        try (FileInputStream fin = new FileInputStream("/Users/efleta/IdeaProjects/day02/src/ex00/kocbyru-kid.doc")){
//            int i=fin.read(arr);
//        }catch (Exception e){
//            System.out.println("СМОТРИ ЧЕ ВВОДИШЬ БЛИНБ");
//            e.printStackTrace();
//        }
//
//        System.out.println(encodeHexString(arr));
//    }
//    public static String encodeHexString(byte[] byteArray) {
//        StringBuffer hexStringBuffer = new StringBuffer();
//        for (int i = 0; i < byteArray.length; i++) {
//            hexStringBuffer.append(byteToHex(byteArray[i]));
//        }
//        return hexStringBuffer.toString();
//    }
//    public static String byteToHex(byte num) {
//        char[] hexDigits = new char[2];
//        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
//        hexDigits[1] = Character.forDigit((num & 0xF), 16);
//        return new String(hexDigits);