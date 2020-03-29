import java.io.*;
import java.util.Scanner;

public class ceshizhuanyong {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("D:\\数据.txt"));
        String textLine;
        String str = "";
        int i=0;
        while ((textLine = bf.readLine()) != null) {
            str += " " + textLine;
            i++;
        }

        System.out.println(str);
        System.out.print(i);
    }
}
