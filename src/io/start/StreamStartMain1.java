package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// IOException : 파일,데이터를 입출력 시 발생하는 예외
public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {
        // 자바 -> 외부 - 데이터 보내기
        // 파일이 없으면 새로 만들어주고, 파일에 내용이 있다면 덮어서 씀
        FileOutputStream fos = new FileOutputStream("temp/hello.dat",true); // 파일에서 읽을 때 디코딩을 하여 숫자 -> 텍스트로 보여줌
        fos.write(65); // 바이트로 저장
        fos.write(66);
        fos.write(67);
        fos.close();    // 자바 외부 자원 사용 시 자원 연결을 종료 시켜줘여 함 - 메모리 누수 등의 문제

        // 외부 -> 자바 - 데이터 읽기
        FileInputStream fis = new FileInputStream("temp/hello.dat");
        System.out.println(fis.read()); // 1바이트 씩 데이터 읽어오기
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read()); // 파일 내용의 끝은 -1로 표현 (EOF)
        fis.close();
    }
}
