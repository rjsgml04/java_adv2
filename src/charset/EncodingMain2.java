package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;
// ASCII 영문 인코딩 : UTF-16을 제외하고는 모두 호환
// 사실상 표준인 UTF-8을 사용하는걸 권장

/**
 * 한글이 깨지는 가장 큰 이유 2가지
 * 1. EUC-KR(MS949), UTF-8이 서로 호환되지 않음
 *      대부분의 문제는 UTF-8로 인코딩한 한글을 EUC-KR(MS949)로 디코딩하거나 또는 반대로 했을 시 발생
 *
 * 2. EUC-KR(MS949) 또는 UTF-8로 인코딩한 한글을 ISO-8859-1로 디코딩할 때
 *      EUC-KR(MS949) 또는 UTF-8로 인코딩한 한글을 지원하지 않는 ISO_8859-로 디코딩할 때 발생
 */
public class EncodingMain2 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");


    public static void main(String[] args) {
        System.out.println("== ASCII 인코딩 ==");
        test("A", US_ASCII, US_ASCII);
        test("A", US_ASCII, ISO_8859_1);    // ASCII 확장(LATIN-1)
        test("A", US_ASCII, EUC_KR);  // ASCII 포함
        test("A", US_ASCII, MS_949);  // ASCII 포함
        test("A", US_ASCII, UTF_8);  // ASCII 포함
        test("A", US_ASCII, UTF_16BE);  // UTF-16 디코딩 실패

        System.out.println("== 한글 인코딩 - 기본 ==");
        test("가",US_ASCII, US_ASCII); // ?가 나오는데 인코딩 표에서 찾을 수 없어서 나오게 된 결과
        test("가",ISO_8859_1, ISO_8859_1); // 호환불가
        test("가",EUC_KR, EUC_KR);
        test("가",MS_949, MS_949);
        test("가",UTF_8, UTF_8);
        test("가",UTF_16BE, UTF_16BE);

        System.out.println("== 한글 인코딩 - 복잡한 문자");
        test("뷁",EUC_KR,EUC_KR);    // 호환 불가

        // 모든 한글 표현 가능
        test("뷁",MS_949,MS_949);
        test("뷁",UTF_8,UTF_8);
        test("뷁",UTF_16BE,UTF_16BE);

        System.out.println("== 한글 인코딩 - 디코딩이 다른 경우");
        test("가",EUC_KR,MS_949);
        test("뷁",MS_949,EUC_KR);    // 인코딩은 가능, 디코딩은 불가 - MS_949가 EUC_KR의 확장 버전이기 때문
        test("가",EUC_KR, UTF_8);    // 한글 바이트 크기(2바이트 vs 3바이트)와 비트 저장 규칙이 서로 달라 디코딩에 실패
        test("가", MS_949, UTF_8);
        test("가", UTF_8,MS_949);

        System.out.println("== 영문 인코딩 - 디코딩이 다른 경우");
        test("A",EUC_KR, UTF_8); // 둘 다 ASCII 지원
        test("A",MS_949, UTF_8);
        test("A",UTF_8, MS_949);
        test("A",UTF_8, UTF_16BE);  // 호환 불가
    }

    // - 문자 -> 숫자 / 숫자 -> 문자 로 변경시에 꼭 문자집합 필요
    private static void test(String text, Charset encodingCharset, Charset decodingCharset){
        byte[] encoded = text.getBytes(encodingCharset); // 문자를 인코딩해 숫자로 변경
        String decoded = new String(encoded, decodingCharset);// 숫자를 문자로 디코딩
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n",
                text, encodingCharset, Arrays.toString(encoded), encoded.length
                ,decodingCharset,decoded);
    }
}
