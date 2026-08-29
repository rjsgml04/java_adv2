package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV1 {

    private static final int PORT = 12345; // 서버 포트

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT); // 연결되는 클라이언트를 대기
        log("서버 소캣 시작 - 리스닝 포트 : " + PORT);

        Socket socket = serverSocket.accept(); // 클라이언트 접속을 대기하고 접속 시 클라이언트에 대한 소켓을 생성하여 통신 진행
        log("소캣 연결 : " + socket);

        DataInputStream input = new DataInputStream(socket.getInputStream());   // 클라언트가 보낸 데이터를 읽음
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());   // 클라이언트에게 보낼 데이터를 작성

        // 클라이언트로 부터 받은 데이터
        String received = input.readUTF();
        log("client -> server :" + received);

        // 클라이언트에게 보낼 데이터
        String toSend = received + " World!";
        output.writeUTF(toSend);
        log("client <- server : " + toSend);

        // 자원정리 - 역순정리
        log("자원정리 :" + socket);
        output.close();
        input.close();
        socket.close();
        serverSocket.close();
    }
}
