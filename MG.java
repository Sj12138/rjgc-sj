import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

public class   MG {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			int n=scanner.nextInt();
			int [][]maze=new int[n][n];
			int [][]visited=new int[n][n];
			int [][]back_xy=new int[n][n];
			int [][]last_dir=new int[n][n];
			int []dx={-1,1,0,0};
			int []dy={0,0,-1,1};
			for(int i=0;i<n;i++){
				Arrays.fill(visited[i], 0);
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					maze[i][j]=scanner.nextInt();
				}
			}
			long startTime = System.currentTimeMillis();
			int start_x=1;
			int start_y=1;
			int end_x=n-2;
			int end_y=n-2;
			Queue<Integer> queue=new LinkedList<Integer>();
			queue.offer(start_x*n+start_y);			//矩阵数组按0,1,2...n*m编号
			back_xy[start_x][start_y]=start_x*n+start_y;
			visited[start_x][start_y]=1;
			while(!queue.isEmpty()){
				int index=queue.poll();
				int x0=index/n;
				int y0=index%n;
				for(int i=0;i<4;i++){
					int x1=x0+dx[i];
					int y1=y0+dy[i];
					if(x1>=0&&x1<n&&y1>=0&&y1<n&&maze[x1][y1]==0&&visited[x1][y1]==0){
						queue.offer(x1*n+y1);
						visited[x1][y1]=1;
						back_xy[x1][y1]=index;
						last_dir[x1][y1]=i;
					}
				}
			}
			StringBuffer path=new StringBuffer();
			int x2=end_x;
			int y2=end_y;
			int index=end_x*n+end_y;
			while(back_xy[x2][y2]!=index){
				path.append(last_dir[x2][y2]);
				int x=back_xy[x2][y2]/n;
				int y=back_xy[x2][y2]%n;
				x2=x;
				y2=y;
				index=x2*n+y2;
			}
			if(path.reverse().toString().length()>1) {
				System.out.println(path.reverse().toString().length());
			}else {
				System.out.println("No solution!");
			}
			long endTime = System.currentTimeMillis();
			System.out.println("程序运行时间："+(endTime-startTime)+"ms");
		}
		scanner.close();

	}
}