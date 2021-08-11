import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;

public class BytesHandler {
    public String proceedFileBytes(Scanner scanner){
        String filePath = scanner.next();
        if (filePath.equals("42")){
            System.exit(0);
        }
        return readBytes(filePath);
    }
    public String readBytes(String filePath){
        byte[] arr = new byte[8];
        try (FileInputStream fin = new FileInputStream(filePath)){
            fin.read(arr);
        }catch (Exception e){
            System.out.println("Please enter valid path to file or valid filename");
        }
        return encodeHexString(arr);
    }
    public String encodeHexString(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }

    public String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }
}
