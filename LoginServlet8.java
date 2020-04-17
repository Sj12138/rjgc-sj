package taobao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet8 extends HttpServlet{
	private static class cd implements Comparable<cd> {
	    String a,name;
		public int compareTo( cd b ) {
			return 0;
		}
		private static int findNext( cd[] arr) {
			return 0;
			}
	}
	private static class ce implements Comparable<ce> {
		String a;
		public int compareTo( ce b ) {
			return 0;
		}
		private static int findNext( ce[] are) {
			return 0;
			}
	}
		private static class cf implements Comparable<cf> {
			String a;
			public int compareTo( cf b ) {
				return 0;
			}
			private static int findNext( cf[] arf) {
				return 0;
				}
		}
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException{
		//HttpSession session = req.getSession();
		String path="jzshu2.jsp";
		String name=req.getParameter("name");
		/*List<String>info=new ArrayList<String>();
			String DBDRIVER="com.mysql.cj.jdbc.Driver";
			String DBURL="jdbc:mysql://localhost:3306/user?serverTimezone=UTC&useSSL=false";
			String DBUSER="root";
			String DBPASS="root";
			String id=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Connection conn=null;
			boolean flag=false;
				try {
					Class.forName(DBDRIVER);
					conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);*/
					int pd=0;
					cd[] arr = new cd[1];
					ce[] are = new ce[999];
					cf[] arf = new cf[999];
					int i=0;
					int n=0;
					arr[0]=new cd();
					for(int c=0;c<999;c++) {
						are[c]=new ce();
						arf[c]=new cf();
					}
					while(true) {
						if(i==name.length()) {
							break;
						}	
						if(pd==0&&name.charAt(i)!='：') {
							arr[0].a=arr[0].a+name.charAt(i);
							i++;
							continue;
					}
						if(pd==0&&name.charAt(i)=='：') {
							pd=1;
							i++;
							continue;
					}
						if(pd==1&&name.charAt(i)!='\n') {
							arr[0].name=arr[0].name+name.charAt(i);
							i++;
							continue;
						}
						if(pd==1&&name.charAt(i)=='\n') {
							pd=3;
							i++;
							continue;
						}
						if(pd==3&&name.charAt(i)!='：') {
							are[n].a=are[n].a+name.charAt(i);
							i++;
							continue;
						}
						if(pd==3&&name.charAt(i)=='：') {
							pd=4;
							i++;
							continue;
						}
						if(pd==4&&name.charAt(i)!='\n') {
							arf[n].a=arf[n].a+name.charAt(i);
							i++;
							continue;
						}
						if(pd==4&&name.charAt(i)=='\n') {
							n++;
							pd=3;
							i++;
							continue;
						}
					}
					req.setAttribute("ds",arr[0].a);
					req.setAttribute("dsname",arr[0].name);
					req.setAttribute("xslb",are);
					req.setAttribute("xsname",arf);
					req.getRequestDispatcher(path).forward(req,resp);
				/*	pstmt=conn.prepareStatement(";");
					rs=pstmt.executeQuery();
		req.setAttribute("info",info);
		req.getRequestDispatcher(path).forward(req,resp);
	}*/
	}			
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
				this.doGet(req, resp);
			}
}
