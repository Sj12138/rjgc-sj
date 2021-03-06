import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author SSS
 */
public class Sudoku {
    public static void text(int m, int[][] shudu, String fileoutput) throws IOException {
            int [][] shudujudge=new int[m][m];
            int gonggeh=0;
            int gonggel=0;
            if(m==4){
                gonggeh=gonggel=2;
            }
            if(m==9){
                gonggeh=gonggel=3;
            }
            if(m==8){
                gonggeh=2;
                gonggel=4;
            }
            if(m==6){
                gonggeh=3;
                gonggel=2;
            }
            for(int h=0;h<m;h++){
                for(int l=0;l<m;l++){
                    if(shudu[h][l]!=0){
                        shudujudge[h][l]=1;
                    }
                    else{
                        shudujudge[h][l]=0;
                    }
                }
            }
            for(int hang=0;hang<m;hang++){
                int lie=0;
                int judge=0;
                while (lie < m) {
                    if (shudujudge[hang][lie] == 1) {
                        lie++;
                        continue;
                    }
                    shudu[hang][lie]++;
                    if (shudu[hang][lie] > m) {
                        shudu[hang][lie] = 0;
                        if (lie == 0) {
                            hang--;
                            lie = m - 1;
                        } else {
                            lie--;
                        }
                        while (shudujudge[hang][lie] != 0) {
                            if (shudujudge[hang][lie] == 1) {
                                if (lie == 0) {
                                    hang--;
                                    lie = m - 1;
                                } else {
                                    lie--;
                                }
                            }
                        }
                        continue;
                    }
                    for (int a1 = 0; a1 < m; a1++) {
                        if (lie == a1) {
                            continue;
                        }
                        if (shudu[hang][lie] == shudu[hang][a1]) {
                            judge = 1;
                            break;
                        }
                    }
                    for (int a1 = 0; a1 < m; a1++) {
                        if (hang == a1) {
                            continue;
                        }
                        if (shudu[hang][lie] == shudu[a1][lie]) {
                            judge = 1;
                            break;
                        }
                    }
                    if (judge == 1) {
                        judge = 0;
                        continue;
                    }
                    if(gonggeh!=0){
                        int h = 0, l = 0;
                        if (hang >= gonggeh && hang < 2 * gonggeh) {
                            h = 1;
                        }
                        if (hang >= 2 * gonggeh && hang < 3 * gonggeh) {
                            h = 2;
                        }
                        if (hang >= 3 * gonggeh) {
                            h = 3;
                        }
                        if (lie >= gonggel && lie < 2 * gonggel) {
                            l = 1;
                        }
                        if (lie >= 2 * gonggel) {
                            l = 2;
                        }
                        for (int i = 0; i < gonggeh; i++) {
                            for (int j = 0; j < gonggel; j++) {
                                if (hang == h * gonggeh + i && lie == l * gonggel + j) {
                                    continue;
                                }
                                if (shudu[hang][lie] == shudu[h * gonggeh + i][l * gonggel + j]) {
                                    judge = 1;
                                    break;
                                }
                            }
                        }
                        if (judge == 1) {
                            judge = 0;
                            continue;
                        }
                    }
                    lie++;
                }
            }
        File file = new File(fileoutput);
        FileWriter out = new FileWriter(file,true);
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                out.write(shudu[i][j]+" ");
            }
            out.write("\r\n");
        }
        out.write("\r\n");
        out.close();
    }

    public static void main(String[] args) throws IOException {
        int m= Integer.parseInt(args[1]);
        int n= Integer.parseInt(args[3]);
        String fileinput=args[5];
        String fileoutput=args[7];
        ArrayList<int[][]> problems=new ArrayList<>();
        int [][]shudu=new int[m][m];
        BufferedReader bf = new BufferedReader(new FileReader(fileinput));
        for(int a=0;a<n;a++){
            for(int i=0;i<m;i++){
                String toint=bf.readLine();
                String str=toint.replaceAll(" ","");
                for(int j=0;j<m;j++){
                    shudu[i][j]= (int) str.charAt(j) -48;
                }
            }
            bf.readLine();
            problems.add(shudu);
                text(m,problems.get(a),fileoutput);
        }
     }
}