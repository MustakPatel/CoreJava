import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {

    public static void main(String[] args) throws IOException {

        String fileLine;

        BufferedReader reader = null;
        Map<String, Integer> map = new HashMap<>();

        try {

            reader = new BufferedReader(new FileReader("..\\Programs\\src\\WordList.txt"));

            while ((fileLine = reader.readLine()) != null) {

                if (map.containsKey(fileLine)) {
                    map.put(fileLine, map.get(fileLine) + 1);
                } else {
                    map.put(fileLine, 1);
                }

            }
        } catch (Exception e) {

            System.out.println(e);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> o2.getValue() - o1.getValue());   //lambda expression is being used for descending order Comparator

        for (Map.Entry<String, Integer> data : list) {      //foreach loop is being used for printing data

            System.out.println(data.getKey() + " : " + data.getValue());        //print data in key : value form

        }       //end of the foreach loop

    }       //end of the main method
}

