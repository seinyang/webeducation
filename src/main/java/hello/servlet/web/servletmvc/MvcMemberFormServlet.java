package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //컨트롤러에서 뷰로 이동하는 리쿠ㅔ스트 디스패처
        RequestDispatcher dispatcher= request.getRequestDispatcher(viewPath);
        //서블릿에서 디스패치로 이동 : 다른 서블릿이나 JSP로 이동할 수 있는 기능이다. 서버 내부에서 다시 호출이 발생한다
        //다시 왔다가 가는게 아닌 바로 가는거임
        //리다이렉트는 응답을 갔다가 가는거고(총2번) 다시 호출인데 포워드는 내부에서만!
        dispatcher.forward(request,response);
    }
}