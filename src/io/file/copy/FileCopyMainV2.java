package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV2 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("temp/copy_new.dat");

        // 성능 최적화가 되어 있지만, 상황에 따라 더 느릴 수 있음
        // 디스크는 실행 시 시간의 편차가 심함
        fis.transferTo(fos);    // inputStream을 읽어서 OutputStream으로 전송해줌

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken :  " + (endTime - startTime) + "ms");
    }
}
