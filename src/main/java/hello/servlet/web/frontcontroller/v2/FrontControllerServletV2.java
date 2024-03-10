package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//하위에 있던간에 *이거 쓰면 무조건 실행됨
@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
 private final Map<String, ControllerV2> controllerMap = new HashMap<>();


 public FrontControllerServletV2() {
  controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
  controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
  controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
 }

 @Override
 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  System.out.println("FrontControllerServletV1.service");
  //리다이렉트 유알아이를 꺼낸다
  String requestURI = request.getRequestURI();
  //맵에 담아서 꺼내줌 그러면 해당 컨트롤러를 찾아준다
  ControllerV2 controller = controllerMap.get(requestURI);
  if (controller == null) {
   response.setStatus(HttpServletResponse.SC_NOT_FOUND);
   return;
  }
  //뷰가 반환되면 해당 myview만 반환되게끔
  MyView view=controller.process(request,response);
  /*view.render(mv.getModel(), request,response);*/
 }
}