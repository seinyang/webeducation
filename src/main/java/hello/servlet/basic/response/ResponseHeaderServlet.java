package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet" , urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //응답의 메시지
        response.setStatus(HttpServletResponse.SC_OK);
        //호출
        redirect(response);

    }
    //리스폰스의 값을 변경
    private void redirect(HttpServletResponse response) throws IOException{
/*        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //쿠키라는 객체가 있음
        Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600);//600초 이후에 시간
        response.addCookie(cookie);*/

        response.sendRedirect("/basic/hello-form.html");
    }
}
