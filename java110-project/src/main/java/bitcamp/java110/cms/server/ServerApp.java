package bitcamp.java110.cms.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;


//톰캣서버가 이 서블릿을 찾을 수 있도록 등록한다.
@WebServlet("/app/*")
public class ServerApp implements javax.servlet.Servlet{

    ServletConfig config;
    ClassPathXmlApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap;

    private void createIoCContainer() {
        iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java110/cms/conf/application-context.xml");
    }

    private void processRequestMappingAnnotation() {
        requestHandlerMap = new RequestMappingHandlerMapping();

        // => IoC 컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            // => 이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);

            // => 객체에서 @RequestMapping이 붙은 메서드를 찾아 지정한다.
            requestHandlerMap.addMapping(obj);
        }
    }
    private void logBeansOfContainer() {
        System.out.println("---------------------");
        String[] nameList = iocContainer.getBeanDefinitionNames();
        for(String name : nameList) {
            System.out.println(name);
        }
        System.out.println("--------------------");
    }

  
    @Override
    public void init(ServletConfig config) throws ServletException {
        //서블릿 컨테이너는
        // 이 서블릿 객체를 생성한 후
        // 이 서블릿이 실행하는데 필요한 자원을 준비할 수 있도록
        // 딱 한 번 호출한다.

        createIoCContainer();
        logBeansOfContainer();
        processRequestMappingAnnotation();
        this.config=config;

    }
    

    @Override
    public ServletConfig getServletConfig() {
        // 서블릿에서 작업을 하는 동안 서블릿 설정 정보를 참조할 필요가 있을 때
        // 이 메서드를 호출한다.
        // 따라서 이 메서드는 서블릿 설정 정보를 다루는 객체를 리턴해야 한다.
        // 보통 init() 메서드가 호출될 때 파라미터 값을 그대로 리턴한다.


        return config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 서블릿 컨테이너는 클라이언트 요청이들어올 때 마다 호출한다.
        // 이 메서드에서 요청을 처리할 컨트롤러의 메서드를 찾아 호출하면 된다.

        //예) http://localhost:8888/manager/list
        //=>HTTP프로토콜 정보를 다루려면 request 객체를 원래의 타입으로
        //캐스팅 한 후 사용하라!
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String servletPath = httpRequest.getServletPath();
        String pathInfo = httpRequest.getPathInfo();
        System.out.println("servletPath=====>"+servletPath);
        System.out.println("pathInfo=====>"+pathInfo);

        RequestMappingHandler mapping =
                requestHandlerMap.getMapping(pathInfo.substring(1));
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(mapping == null) {
            out.println("어플리케이션 경로를 찾을 수 없습니다.");
            out.flush();
            return;
        }

        try {
            // 요청 핸들러 호출
            mapping.getMethod().invoke(mapping.getInstance()
                    , request, response);
        } catch(Exception e) {
            e.printStackTrace();
            out.println("요청 처리 중 오류가 발생하였습니다.");
            out.flush();
        }



    }



    @Override
    public String getServletInfo() {
        // 서블릿 컨테이너 관리자 화면에서 이 서블릿의 정보를 출력할 때 이 메서드를 호출 한다.
        // 이 서블릿에 대한 간단한 정보를 문자열로 리턴하면 된다.
        return "클라이언트 요청을 중계하는 서블릿";
    }

    @Override
    public void destroy() {
        //서블릿 컨테이너는
        //서버를 종료하거나, 웹 애플리케이션을 정지기 바로 빅전에
        //why?
        //이 서블릿이 사용했던 자원을 해제시켜 메모리를 줄일 수 있도록 하기 위해
        //이 method를 호출한다.
        //예를 들어 DB연결된 것을 닫는다거나 열린 파일을 닫는다거나,
        //연결된 소켓을 닫는 등의 작업을 이 메서드에서 수행하면 된다.


    }

} // Server class 