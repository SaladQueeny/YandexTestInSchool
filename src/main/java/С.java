import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class С {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        int[] monthNormal = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] monthNotNormal = {31,29,31,30,31,30,31,31,30,31,30,31};
        long start = System.currentTimeMillis();
        FileReader reader = new FileReader("C:\\Users\\kolpa\\Desktop\\C\\input.txt");
        //FileReader reader = new FileReader("input.txt");
        Scanner scanner = new Scanner(reader);
        int t = scanner.nextInt();
        int e = scanner.nextInt();
        List<String> str = new ArrayList<>();

        while(scanner.hasNext()){
            str.add(scanner.nextLine());
        }
        List<Double> time = new ArrayList<>();
        List<Integer> timegood = new ArrayList<>();
        List<Date> date = new ArrayList<>();
        timegood.add(0);

        List<String> datesTime = new ArrayList<>();
        List<String[]> list = new ArrayList<>();
        for(int i=1; i<str.size();i++){
            String string = str.get(i);
            String[] words = string.split(" ");
            list.add(words);

            //String forDatesTime = words[0].substring(1,words[0].length())+" "+ words[1].substring(0,words[1].length()-1);

            if(words[2].equals("ERROR")){//возможно учитывать даты
                Date dated = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(words[0].substring(1,words[0].length())+" "+ words[1].substring(0,words[1].length()-1));
                //System.out.println(dated);
                //System.out.println(dated.getTime()/1000);
                //System.out.println(words[0].substring(1,words[0].length())+" "+ words[1].substring(0,words[1].length()-1));
                datesTime.add(words[0].substring(1,words[0].length())+" "+ words[1].substring(0,words[1].length()-1));


//                double currentTime = 0;
//                double currentdatePlusMonth=0;
//                for(int k=0;k<Integer.parseInt(forDatesTime.substring(5,7))-1;k++){
//                    if(Integer.parseInt(forDatesTime.substring(0,4))==2020){
//                        currentdatePlusMonth+=monthNotNormal[k];
//                    }else{
//                        currentdatePlusMonth+=monthNormal[k];
//                    }
//                }
//                currentdatePlusMonth+=Double.parseDouble(forDatesTime.substring(8,10));
//
//                currentTime=31536000*Double.parseDouble(forDatesTime.substring(0,4))+86400*currentdatePlusMonth+Double.parseDouble(forDatesTime.substring(11,13))*3600+Double.parseDouble(forDatesTime.substring(14,16))*60+Double.parseDouble(forDatesTime.substring(17,19));

                //time.add(currentTime);
                time.add((double)dated.getTime()/1000);

            }


        }

        double summ=0;int j=0;
        String answer="-1";
        for(int i=e-1; i<time.size();i++){

            summ=time.get(i)-time.get(j);

            if(summ<t){
                answer= datesTime.get(i);
                break;
            }else{
                j++;
            }
        }
        System.out.println(answer);

    }
}