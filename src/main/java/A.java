import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class A {

    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        String jsonString = scanner.next();

        try (FileReader reader = new FileReader("C:\\Users\\kolpa\\Desktop\\input.txt")) {
            JSONParser parser = new JSONParser();
            JSONObject obj = null;
            JSONArray array = (JSONArray) parser.parse(reader);
            //obj = (JSONObject) array.get(0);
            //String str = (String) obj.get("event_id");
            System.out.println(array);

            List<Integer> items = new ArrayList<>();
            List<Integer> order = new ArrayList<>();















        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
