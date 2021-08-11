import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class InputFilesHandler {
    private List<List<String>> listOfTexts = new ArrayList<>();
    private List<Vector<Long>> listOfVectors = new ArrayList<>();

    public List<Vector<Long>> getListOfVectors() {
        return listOfVectors;
    }

    public void readFile(List<String> list) {
        for (String fileName : list) {
            List<String> textList = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                String[] line = bufferedReader.lines().collect(Collectors.joining("\n")).split(" ");
                textList = Arrays.asList(line.clone());
            } catch (Exception e) {
                e.printStackTrace();
            }
            listOfTexts.add(textList);
        }
    }

    public List<String> createDictionary(){
        Set<String> set = new HashSet<>();
        for (List<String> list : listOfTexts){
            set.addAll(list);
        }
        List<String> sortedDict = new ArrayList<>(set);
        Collections.sort(sortedDict);
        return sortedDict;
    }

    public void createVector(List<String> sortedDict){
        //TODO: sort dictionary
        for (List<String> list : listOfTexts) {
            Vector<Long> vec = new Vector<>();
            for (int i = 0; i < sortedDict.size(); i++) {
                int finalI = i;
                System.out.println(sortedDict.get(finalI));
                vec.add(list.stream().filter(str -> str.equals(sortedDict.get(finalI))).count());
            }
            listOfVectors.add(vec);
        }
    }
}
