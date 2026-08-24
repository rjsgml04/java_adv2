package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
// Files 객체를 이용한 복사
public class FileCopyMainV3 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");

        // 다른 방식은 파일 -> 자바 -> 파일 과정을 거침
        // Files 객체는 복사 시 파일 -> 파일로 바로 복사 진행 - 자바에 파일 데이터를 불러오지는 않음
        // 복사 시에만 유리한 방식
        Files.copy(source,target,REPLACE_EXISTING);


        long endTime = System.currentTimeMillis();
        System.out.println("Time taken :  " + (endTime - startTime) + "ms");
    }
}
