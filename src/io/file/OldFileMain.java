package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("File exists: " +  file.exists()); // 파일 존재 여부

        boolean created = file.createNewFile(); // 파일 생성
        System.out.println("File created : " + created);

        boolean dirCreated = directory.mkdir(); // 디렉터리 생성
        System.out.println("Directory created : " + dirCreated);

        //boolean delete = file.delete();// 파일 삭제
        //System.out.println("File deleted = " + delete);

        System.out.println("Is file : " + file.isFile());
        System.out.println("Is directory : " + directory.isDirectory());
        System.out.println("File Name : " + file.getName());
        System.out.println("File size : " + file.length() + "bytes");


        // 파일명 변경
        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("File renamed: " + renamed);

        // 파일이 마지막으로 변경된 시간
        long lastModified = newFile.lastModified();
        System.out.println("Last modified: " + new Date(lastModified));
    }
}
