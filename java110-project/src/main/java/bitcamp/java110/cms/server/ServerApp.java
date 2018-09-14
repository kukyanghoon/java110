package bitcamp.java110.cms.server;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws Exception {


        //클라이언트 서버를 기다리는 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("서버 실행 중........");
        
        
        while(true)
        {
            try (
                    Socket socket = serverSocket.accept();
                    PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    )
            {
                System.out.println(in.readLine());
                out.println("OK"); out.flush();
                while(true) {
                    String requestLine = in.readLine();
                    out.println(requestLine);
                    out.println();
                    out.flush();
                    
                    if(requestLine.equals("exit"))
                    {
                        out.println("good-bye");
                        out.println();
                        out.flush();
                        break;
                    }
                }
            }
        }
    }
}






















