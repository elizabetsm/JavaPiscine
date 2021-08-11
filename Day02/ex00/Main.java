import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main{
    public static void main(String[] args){

//        File file = new File(args[0]);
        Map<String, String> signatures = new HashMap<>();
        String line;
        Scanner scanner = new Scanner(System.in);

        try (FileInputStream fileInputStream = new FileInputStream("signatures.txt")){
           int bytes = fileInputStream.available();
           byte[] arr = new byte[bytes];
           if (fileInputStream.read(arr) > 0){
               String s = new String(arr, StandardCharsets.UTF_8);
               splitLine(s, signatures);
           }
        } catch (Exception e){
            e.printStackTrace();
        }
        while (true){
            proceedFileBytes(scanner, signatures, createFile());
        }

    }

    public static void proceedFileBytes(Scanner scanner, Map<String, String> signatures, File file){
        String filePath = scanner.next();
        if (filePath.equals("42")){
            System.exit(0);
        }
        findFileSignature(readBytes(filePath), signatures, file);
    }

    public static void findFileSignature(String encodedBytes, Map<String, String> signatures, File file){
        String sign = signatures.get(encodedBytes);
        if ( sign == null){
            System.out.println("UNDEFINED");
        }
        else {
            writeToFile(sign, file);
            System.out.println("PROCESSED");
        }
    }

    public static int writeToFile(String sign, File file){
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)){
            fileOutputStream.write(sign.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    public static File createFile(){
        File file = null;
        try {
            file = new File("result.txt");
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return file;
    }

    public static String readBytes(String filePath){
        byte[] arr = new byte[8];
        try (FileInputStream fin = new FileInputStream(filePath)){
            fin.read(arr);
        }catch (Exception e){
            System.out.println("Please enter valid path to file or valid filename");
        }
        return encodeHexString(arr);
    }
    public static String encodeHexString(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }
    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    /* Splitting file content to a map*/
    public static void splitLine(String line, Map<String, String> signatures){
//        String line = Arrays.toString(arr);
        String[] lines = line.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String[] keyVal = lines[i].split(",");
            signatures.put(keyVal[1].replaceAll(" ", "").toLowerCase(), keyVal[0]);
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