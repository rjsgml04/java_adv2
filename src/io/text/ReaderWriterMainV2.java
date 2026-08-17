package io.text;


import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV2 {

    public static void main(String[] args) throws IOException {
        String writeString = "가나다";
        System.out.println("write String = " + writeString);

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8); // 인코딩할 집합 넘겨서 인코딩 진행

        osw.write(writeString); // 인코딩할 문자 넘기면 변환하여 쓰기 작업 진행
        osw.close();

        // 파일 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);


        StringBuilder content = new StringBuilder();
        int ch;
        while((ch = isr.read()) != -1){
            content.append((char) ch); // 원래 문자로 저장 int -> char
        }
        isr.close();

        System.out.println("read String = " + content);
    }
}
