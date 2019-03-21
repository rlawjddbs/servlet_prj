package day0306;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@SuppressWarnings("serial")
public class UseDBCP extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
	      out.write("#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
	      out.write("\t\t\tposition: relative; }\r\n");
	      out.write("#headerTitle{ font-family: HY견고딕, 고딕; font-size: 30px; font-weight: bold;text-align: center;\r\n");
	      out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
	      out.write("#container{  width:800px; height: 600px; }\r\n");
	      out.write("#footer{  width:800px; height: 120px; }\r\n");
	      out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
	      out.write("</style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<div\tid=\"wrap\">\r\n");
	      out.write("\t<div id=\"header\">\r\n");
	      out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"container\">\r\n");

	      
	      // DBCP 사용
	      // 1. JDNI 사용 객체 생성
	      try {
			Context ctx = new InitialContext();
			// 2. 이름으로 객체 찾기
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbcp"); // lookup() 메소드는 Object type을 반환하므로 자식 클래스인 DataSource type으로 캐스팅 해준다.
			// 3. Connection 얻기
			Connection con = ds.getConnection();
			out.println("DB연동 성공 : "+con);
			
			con.close();
		} catch (NamingException ne) {
			out.println("뎨둉합니다.");
			out.println("<img src='common/images/img.png' />");
		} catch (SQLException sqle) {
			out.println("<img src='common/images/img2.jpg' />");
			sqle.printStackTrace();
		} // end catch


	      out.write("\t\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"footer\">\r\n");
	      out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</div>\r\n");
	      out.write("\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
		
	} // doGet

	// 단위 테스트 코드
//	public static void main(String[] args) {
//		UseDBCP ud = new UseDBCP();
//		ud.test();
//	}
//	
//	public void test() {
//		// DBCP 사용
//	      // 1. JDNI 사용 객체 생성
//	      try {
//			Context ctx = new InitialContext();
//			// 2. 이름으로 객체 찾기
//			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbcp"); // lookup() 메소드는 Object type을 반환하므로 자식 클래스인 DataSource type으로 캐스팅 해준다.
//			// 3. Connection 얻기
//			Connection con = ds.getConnection();
//			System.out.println("DB연동 성공 : "+con);
//			
//			con.close();
//		} catch (NamingException ne) {
//			System.out.println("뎨둉합니다.");
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		} // end catch
//	}
	
} // class
