package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet",urlPatterns = "/request-body-string")

//http바디에 넣었던 정보가 뜨는것
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //메시지 바이트 코드를 스르림 으로 바로 바꿀수있는거,인풋스트림으로 데이터를 읽을수있다?
        ServletInputStream inputStream = req.getInputStream();
        //바이트를 문자로 변환할때는 인코딩 정보를 알려줘야함,반대로 문자를 바이트로 바꿀때도 인코딩 정보 알려줘야함
        String messagebody=StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messagebody="+messagebody);


        resp.getWriter().write("ok");

    }
}
