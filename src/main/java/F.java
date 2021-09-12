
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class F {
    public static boolean checkTime(List<String> queue, Map<String, Integer> time, String element){
        int key=0, size = queue.size();
        List<String> queue1 = new ArrayList<>(queue);
        for(int i=0; i< queue.size(); i++){
            if(time.get(element)< time.get(queue1.get(i))){
                key++;
            }else{
            }
        }

        if(key==queue.size()){
            return false;
        }else{
            return true;
        }

    }
    public static void main(String[] args)  {
        try(FileReader reader = new FileReader("C:\\Users\\kolpa\\Desktop\\input.txt")) {
            Scanner scanner = new Scanner(reader);
            String[] str1 = scanner.nextLine().split(" ");
            int n = Integer.parseInt(str1[0]), capacity = Integer.parseInt(str1[1]);
            List<String> queuelist = new ArrayList<>(capacity);
            List<String> words = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i< n;i++){
                String[] str = scanner.nextLine().split(" ");
                words.add(str[0]);
                map.put(str[0], Integer.parseInt(str[1]));
            }
            if(n==0||capacity==0){
                return;
            }
            for(int i=0;i<n;i++){
                if(queuelist.size()<capacity &&!queuelist.contains(words.get(i))){
                    queuelist.add(words.get(i));
                    System.out.println((i+1)+" PUT "+ words.get(i));
                } else if(queuelist.contains(words.get(i))){
                    System.out.println((i+1)+" UPDATE "+ words.get(i));
                    queuelist.remove(words.get(i));
                    queuelist.add(words.get(i));
                } else if(queuelist.size()==capacity&&checkTime(queuelist, map, words.get(i))){
                    System.out.println((i+1)+" DELETE "+ queuelist.get(0));
                    queuelist.remove(queuelist.get(0));
                    System.out.println((i+1)+" PUT "+ words.get(i));
                    queuelist.add(words.get(i));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //для второго примера смотрим если время этой операции меньше чем время каждой операции кэша то его не добавляем(если его нет). Если больше хотя бы одного то добавляем
    }
}
/*
5 2
status 10
history 2
history 4
price 7
status 3


1 PUT status
2 PUT history
3 UPDATE history
4 DELETE status
4 PUT price

 */