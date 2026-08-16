package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class CreateFileV3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);

        // BufferedOutputStream 내부에서 단순히 버퍼 기능만 제공하여 반드시 대상 OutputStream 필요
        // CreateFileV2 보다 성능이 떨어지는 이유는 동기화 코드 때문
        BufferedOutputStream bos = new BufferedOutputStream(fos,BUFFER_SIZE); // Stream과 버퍼크기 지정
        long startTime = System.currentTimeMillis();

        // 10MB 크기의 파일 생성
        for (int i = 0; i < FILE_SIZE; i++) {
            bos.write(1);
        }
        bos.close(); // close 호출 시 내부에서 flush도 호출, 반드시 마지막에 연결한 스트림을 close해줘야 연쇄적으로 close를 호출함

        long endTime = System.currentTimeMillis();
        System.out.println("File created : " + FILE_NAME);
        System.out.println("File size : " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken : " + (endTime - startTime) + "ms"); // 194ms 소요됨
    }
}
