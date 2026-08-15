package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// IOException : 파일,데이터를 입출력 시 발생하는 예외
public class StreamStartMain2 {

    public static void main(String[] args) throws IOException {
        // 자바 -> 외부 - 데이터 보내기
        // 파일이 없으면 새로 만들어주고, 파일에 내용이 있다면 덮어서 씀
        FileOutputStream fos = new FileOutputStream("temp/hello.dat"); // 파일에서 읽을 때 디코딩을 하여 숫자 -> 텍스트로 보여줌
        fos.write(65); // 바이트로 저장
        fos.write(66);
        fos.write(67);
        fos.close();    // 자바 외부 자원 사용 시 자원 연결을 종료 시켜줘여 함 - 메모리 누수 등의 문제

        // 외부 -> 자바 - 데이터 읽기
        FileInputStream fis = new FileInputStream("temp/hello.dat");
        int data;   // 파일깂을 변수에 저장
        // int read = fis.read(); - int를 반환 중
        while((data = fis.read())!=-1){ // 파일의 끝일 때 -1 을 반환하므로 반복문을 통해서 데이터를 모두 읽을 수 있음
            System.out.println(data);
        }
        fis.close();
    }
}
