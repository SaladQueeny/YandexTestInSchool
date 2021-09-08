import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class F {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("input.txt");
        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt(), m = scanner.nextInt();
        List<String> str = new LinkedList<>();
        while(scanner.hasNext()){
            str.add(scanner.nextLine());
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