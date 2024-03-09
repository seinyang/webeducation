package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@WebServlet(name="responseJsonServlet",urlPatterns = "/response-json")
@RequiredArgsConstructor
public class ResponseJsonServlet extends HttpServlet {


    final ObjectMapper objectMapper;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();

        helloData.setUsername("yang");
        helloData.setAge("25");

//이형태의 데이터를 json형태로 바ㅣ꾸려면?objectMapper를 써야해,json뿌리는방법!

        String result = objectMapper.writeValueAsString(helloData);
        resp.getWriter().write(result);
    }
}
