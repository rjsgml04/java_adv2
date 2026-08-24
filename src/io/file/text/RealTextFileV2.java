package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

// 라인(한줄) 단위로 읽기
public class RealTextFileV2 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path,writeString, UTF_8);
        // 파일에서 읽기 - 리스트 단위로 반환
        // 해당 메서드의 단점 : 매우 큰 파일은 용량을 메모리에 올리기 때문에 용량 초과될 수 있음
        List<String> lines = Files.readAllLines(path, UTF_8);

        System.out.println("== Read String ==");
        /*
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));

        }
         */

        // 개선 코드
        Stream<String> lineStream = Files.lines(path, UTF_8);
        lineStream.forEach(line -> System.out.println(line));
        lineStream.close();
    }
}
