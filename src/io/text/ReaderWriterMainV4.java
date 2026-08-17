package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        // 파일에 쓰기
        /*
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);
        두 코드를 간단하게 사용할 수 있음
         */
        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        // 파일 읽기
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;
        while((line = br.readLine()) != null){  // 줄 단위로 데이터를 읽음 abc , 가나다 , null(파일 끝) 총 3번 readLine
            content.append(line).append("\n");
        }
        br.close();

        System.out.println("== Read String ==");
        System.out.println(content);
    }
}
