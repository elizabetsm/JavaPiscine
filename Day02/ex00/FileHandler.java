import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    private Map<String, String> signatures = new HashMap<>();
    private File file = null;

    public File createFile(){
        try {
            file = new File("result.txt");
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return file;
    }

    /* Splitting signatures.txt content to a map*/
    public Map<String, String> splitLine(String line){
        String[] lines = line.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String[] keyVal = lines[i].split(",");
            signatures.put(keyVal[1].replaceAll(" ", "").toLowerCase(), keyVal[0]);
        }
        return signatures;
    }

    public void writeToFile(String sign, File file){
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)){
            fileOutputStream.write(sign.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void findFileSignature(String encodedBytes){
        String sign = signatures.get(encodedBytes);
        if ( sign == null){
            System.out.println("UNDEFINED");
        }
        else {
            writeToFile(sign, file);
            System.out.println("PROCESSED");
        }
    }

}
