package day0225;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet ���
public class Hello extends HttpServlet {
	
	// 2. ��û����� ó���� �� �ִ� �߻� method �� Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 3. ������ ���� (MIME-TYPES) - �����ڿ��� ������ ���� ����
		response.setContentType("text/html;charset=UTF-8");
		
		// 4. ���������� ������ ���Ͽ� �����ڿ��� ������ ������ �����ϱ� ���� Stream�� ���
		PrintWriter out = response.getWriter();
		
		// 5. ��� ������ ��Ʈ���� ���
		out.println("<!DOCTYPE html>"); // dtd ����
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�ȳ� Servlet</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("��û"+request+"<br />");
		out.println("����"+response+"<br />");
		out.println("<strong>�ȳ� Servlet!!?</strong><br />");
		out.println("�� �������̶�� ��<br />");
		out.println("2019�� 02�� 25�� �Դϴ�.");
		out.println("</body>");
		out.println("</html>");
		
	} // doGet

} // class
