package charset;

import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;
// 인코딩 : 문자를 컴퓨터가 이해할 수 있도록 숫자(byte)로 변경하는 것을 인코딩이라 함
public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");


    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");
        encoding("A", US_ASCII);
        encoding("A", ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", UTF_8);
        encoding("A", UTF_16BE);    // 2byte를 사용함, ASCII와 호환되지 않음

        System.out.println("== 한글 지원 ==");
        encoding("가",EUC_KR);
        encoding("가",MS_949);
        encoding("가", UTF_8);
        encoding("가", UTF_16BE);

        String str = "hello";
        byte[] bytes = str.getBytes();  // Charset를 지정하지 않으면 시스템 기본 문자 집합으로 지정됨
        System.out.println("bytes = " + Arrays.toString(bytes));

    }

    // 인코딩 헬퍼 메서드 - Charset인자를 넣으면 됨
    private static void encoding(String text, Charset charset){
        // 문자를 문자집합에 넣으면 숫자가 나옴 ( 'a' -> 문자집합 -> 65 )
        // 아래 메서드 사용 시 String 문자를 byte 배열로 추출 가능
        // 중요한 점 : 문자를 byte로 변경하려면 문자 집합이 꼭 필요함
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n",text,charset , Arrays.toString(bytes),bytes.length);
    }
}
