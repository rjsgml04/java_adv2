package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] input = {65,66,67}; // 데이터를 한번에 넘기기 - 바이트 배열
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] readBytes = fis.readAllBytes();
        System.out.println("readBytes = " + Arrays.toString(readBytes)); // 스트림이 끝날때 까지 모든 데이터를 한번에 읽어옴
        fis.close();

    }
}
