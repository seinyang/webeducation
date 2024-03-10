package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//하위에 있던간에 *이거 쓰면 무조건 실행됨
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
 private final Map<String, ControllerV1> controllerMap = new HashMap<>();


 public FrontControllerServletV1() {
  controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
  controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
  controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
 }

 @Override
 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  System.out.println("FrontControllerServletV1.service");
  //리다이렉트 유알아이를 꺼낸다
  String requestURI = request.getRequestURI();
  //맵에 담아서 꺼내줌 그러면 해당 컨트롤러를 찾아준다
  ControllerV1 controller = controllerMap.get(requestURI);
  if (controller == null) {
   response.setStatus(HttpServletResponse.SC_NOT_FOUND);
   return;
  }
  controller.process(request, response);
 }
}