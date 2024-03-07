package hello.servlet.basic;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//http서블릿이
@WebServlet(name = "helloservlet" , urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
//이서비스를 호출하면서 동작된다
    @Override                //리퀘스트는 서비스에서 요청메시지,리스폰스는 서비스에서 응답메시지
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //톰캣에서 어떻게 요청하고 응답하는지 보여줌
        System.out.println("HelloServlet.service");
        //서버에 http형식의 메시지를 만들어서 던져줌 (request객체를 만들어서 서블릿을 호출해줌)
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //요청에서 ?해서 파라미터 값을 응답할때 값을 꺼낼때쓰는 getParamater
        String username = request.getParameter("username");
        System.out.println("username="+username);

        //데이터를 담아서 값이 나가게된다/ 이두개는 헤더타입 정보에 들어감
        response.setContentType("text/plain");
        //인코딩하는 정보를 알려줘야함
        response.setCharacterEncoding("utf-8");



        //http getbody에 데이터가 들어간다
        response.getWriter().write("hello"+username);

    }
}
