package day0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
// 1. HttpServlet ���
public class LifeCycle extends HttpServlet {
	
	@Override
	// �����ֱ� method
	public void init() {
		System.out.println("=============> init method ���� �����ڿ� ���� �� �� ȣ��(������ ����)");
	} // init
	@Override
	public void destroy() {
		System.out.println("=============> Web Container�� ����� �� ��ü�� ������鼭 �� �� ȣ��");
	} // destroy
	
	
	
	// 2. �����Ŀ� ���� ó�� method Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 3. ���� ��� ���� (MIME-Type ����)
		response.setContentType("text/html;charset=UTF-8");
		// 4. ��� ��Ʈ�� ���
		PrintWriter out = response.getWriter();
		// 5. ���䳻�� ����
		out.println("<strong>�湮�� ����</strong><br />");
		out.println("<strong>������ ip : </strong><br />");
		out.print(request.getRemoteAddr());
		out.println("���� ���� �Ͽ����ϴ�.");
		
		System.out.println("---------------> service, doGet, doPost ��� �����ڿ��� ȣ��. ������ ȣ��"+request.getRemoteAddr());
		
	} // doGet

} // class
