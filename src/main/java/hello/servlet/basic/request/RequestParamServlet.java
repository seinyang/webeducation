package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //request.getParameter는 url로도 데이터를 꺼낼수있지만 ,body에 있는 데이터도 꺼낼수있따. 파라미터 정보를 꺼낼슈있다 겟파라미터
        //post의 폼 형식과 get의 url파라미터 데이터 받는 리스폰스의 응답의 형식은 같게 받기때문에 겟.파라미터로 구분없이 조회가능
        System.out.println("[전체 파라미터 조회]-start");
        //값이 여러가지가 들어온것임
        req.getParameterNames().asIterator()
        .forEachRemaining(paramName -> System.out.println(paramName+"="+req.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회]-end");

        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username= req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username"+username);
        System.out.println("age="+age);
        System.out.println();


        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username");
        for (String name:usernames){
            System.out.println("username="+name);
        }
        //데이터를 잘받아오면 응답의 메시지를 정해줄수있음
        resp.getWriter().write("ok");


    }
}
