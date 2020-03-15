import java.util.Scanner;
/**
 * @author SJ
 */
public class FirstRjgc {
    private static class M implements Comparable<M> {
        int x=1,y=1;
        @Override
        public int compareTo(M b ) {
            return 0;
        }
        private static int findNext( M[] M) {
            return 0;
        }
    }
    public static void input( int size, int[][] maze_size){
        System.out.println("输入迷宫样式(一行输入)");
        for(int i=0;i<size;i++) {
            Scanner sc1=new Scanner(System.in);
            String inputString = sc1.nextLine();
            String[] stringArray = inputString.split(" ");
            for (int j = 0; j < size; j++) {
                maze_size[i][j] = Integer.parseInt(stringArray[j]);
            }
        }
    }

    public static void lookup(int size, int[][] mazeSize) {
        int x = 1, y = 1;
        int num = 0;
        int min=size*size+1;
        M[] M = new M[size * size];
        for (int i = 0; i < size * size; i++) {
            M[i] = new M();
        }
        while (x != 1 || y != 1 || mazeSize[1][1] != 4) {

            if (x == size - 2 && y == size - 2) {
                if (num < min) {
                    min = num;
                }
                num--;
                x = M[num].x;
                y = M[num].y;
                continue;
            }
            if (mazeSize[x][y] == 0 && y + 1 < size - 1 && mazeSize[x][y + 1] == 0) {
                mazeSize[x][y]++;
                num++;
                y = y + 1;
                M[num].x = x;
                M[num].y = y;
                continue;
            }
            if (mazeSize[x][y] == 1 && x + 1 < size - 1 && mazeSize[x + 1][y] == 0) {
                mazeSize[x][y]++;
                num++;
                x = x + 1;
                M[num].x = x;
                M[num].y = y;
                continue;
            }
            if (mazeSize[x][y] == 2 && y - 1 > 0 && y - 1 < size - 1 && mazeSize[x][y - 1] == 0) {
                mazeSize[x][y]++;
                num++;
                y = y - 1;
                M[num].x = x;
                M[num].y = y;
                continue;
            }
            if (mazeSize[x][y] == 3 && x - 1 > 0 && x - 1 < size - 1 && mazeSize[x - 1][y] == 0) {
                mazeSize[x][y]++;
                num++;
                x = x - 1;
                M[num].x = x;
                M[num].y = y;
                continue;
            }
            if (mazeSize[x][y] == 4) {
                mazeSize[x][y] = 0;
                num--;
                x = M[num].x;
                y = M[num].y;
                continue;
            }
            mazeSize[x][y]++;
        }
        if(min!=size*size+1) {
            System.out.println(min);
        }
        else{
            System.out.println("没有到达终点的路");
        }
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int size;
        Scanner sc=new Scanner(System.in);
        size=sc.nextInt();
        int [][] mazeSize =new int[size][size];
        input(size, mazeSize );
        lookup(size, mazeSize );
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");
    }
}
