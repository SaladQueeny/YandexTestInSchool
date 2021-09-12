
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.*;

public class A {
    public static class nado{
        public int event_id;
        public int order_id;
        public int item_id;
        public int count;
        public int return_count;
        public String status;

        public nado(int event_id, int order_id, int item_id, int count, int return_count, String status) {
            this.event_id = event_id;
            this.order_id = order_id;
            this.item_id = item_id;
            this.count = count;
            this.return_count = return_count;
            this.status = status;
        }

        @Override
        public String toString() {
            return "nado{" +
                    "event_id=" + event_id +
                    ", order_id=" + order_id +
                    ", item_id=" + item_id +
                    ", count=" + count +
                    ", return_count=" + return_count +
                    ", status='" + status + '\'' +
                    '}';
        }

    }
    public static void main(String[] args){

        try (FileReader reader = new FileReader("C:\\Users\\kolpa\\Desktop\\input.txt")) {
            JSONParser parser = new JSONParser();
            List<nado> datadase = new ArrayList();
            JSONObject obj = null;
            JSONArray array = (JSONArray) parser.parse(reader);
            for(int i=0; i<array.size();i++){
                obj = (JSONObject) array.get(i);
                long a = (Long) obj.get("event_id");
                long b = (Long) obj.get("order_id");
                long c = (Long) obj.get("item_id");
                long d = (Long) obj.get("count");
                long e = (Long) obj.get("return_count");
                datadase.add(new nado((int) a,(int) b,(int)c,(int)d,(int)e, (String)obj.get("status") ));
            }
            if(datadase.size()==0){
                System.out.println("[]");
                return;
            }
            Collections.sort(datadase, new Comparator<nado>() {
                @Override
                public int compare(nado o1, nado o2) {
                    if(o1.event_id> o2.event_id){
                        return 1;
                    }else if(o1.event_id < o2.event_id){
                        return -1;
                    } else{
                        return 0;
                    }

                }
            });
            Collections.sort(datadase, new Comparator<nado>() {
                @Override
                public int compare(nado o1, nado o2) {
                    if(o1.item_id> o2.item_id){
                        return 1;
                    }else if(o1.item_id < o2.item_id){
                        return -1;
                    } else{
                        return 0;
                    }
                }
            });
            Collections.sort(datadase, new Comparator<nado>() {
                @Override
                public int compare(nado o1, nado o2) {
                    if(o1.order_id> o2.order_id){
                        return 1;
                    }else if(o1.order_id < o2.order_id){
                        return -1;
                    } else{
                        return 0;
                    }
                }
            });

            Map<Integer, Integer> items = new LinkedHashMap();//key - id, count - value
            Map<Integer, Map<Integer, Integer>> orders = new LinkedHashMap();//key - id, value - items
            for(int i=0; i<datadase.size()-1;i++){
                if(datadase.get(i).order_id!=datadase.get(i+1).order_id||datadase.get(i).item_id!=datadase.get(i+1).item_id){
                    if(!datadase.get(i).status.equals("CANCEL")&&(datadase.get(i).count-datadase.get(i).return_count)>0){
                        items.put(datadase.get(i).item_id,datadase.get(i).count-datadase.get(i).return_count );
                    }
                    if(datadase.get(i).order_id!=datadase.get(i+1).order_id&&items.size()>0){
                        orders.put(datadase.get(i).order_id, items);
                        items = new HashMap<>();
                    }
                }

            }
            int check = datadase.size()-1;
            if(!datadase.get(check).status.equals("CANCEL")&&datadase.get(check).count-datadase.get(check).return_count>0){
                items.put(datadase.get(check).item_id,datadase.get(check).count-datadase.get(check).return_count );
            }
            if(items.size()>0){
                orders.put(datadase.get(check).order_id, items);
            }

            JSONArray resultMain = new JSONArray();
            for(Map.Entry<Integer, Map<Integer, Integer>> entry :orders.entrySet()){
                JSONObject object1 = new JSONObject();
                object1.put("id", entry.getKey());
                JSONObject object2 = new JSONObject();
                JSONArray array1 = new JSONArray();
                for (int j=0;j<entry.getValue().values().size();j++){
                    object2.put("count",entry.getValue().values().toArray()[j]);
                    object2.put("id", entry.getValue().keySet().toArray()[j]);
                    array1.add(object2);
                    object2 = new JSONObject();
                }


                object1.put("items", array1);
                resultMain.add(object1);
            }

            System.out.println(resultMain.toJSONString());

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
