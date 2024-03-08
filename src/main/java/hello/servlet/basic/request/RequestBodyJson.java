package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet(name ="requestBodyJson" ,urlPatterns ="/request-body-json" )
public class RequestBodyJson extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream  = request.getInputStream();
        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("message="+message);
//내가 만든 dto의 값을 json에서 주는 라이브러리를 사용해 해당 dto 클래스를 가져오면 알아서 객체로 json형식으로 반환해준다
        //json결과를 파싱해서 ->자바 객체로 변환 하려면? objectmapper(json라이부로리)를 사용해야해
        HelloData helloData = objectMapper.readValue(message, HelloData.class);
        System.out.println("age="+helloData.getAge());
        System.out.println("name="+helloData.getUsername());
    }
}
