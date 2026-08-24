package io.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/.."); // temp의 상위 폴더
        System.out.println("path = " + file.getPath());

        // 절대 경로
        // 프로그램 처음 시작부터의 경로
        System.out.println("Absolute path = " + file.getAbsolutePath());

        // 정규 경로
        // file 경로 계산에 대한 결과값 (.. 등에 대한 계산이 끝난 결과)
        System.out.println("Canonical path = " + file.getCanonicalPath());

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println((f.isFile() ? "F" : "D") + " | " + f.getName());
        }
    }
}
