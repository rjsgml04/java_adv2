package io.streams;

import java.io.*;

public class DataStreamEtcMain {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/data.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("회원A"); // UTF-8 인코딩을 하여 데이터를 전달함
        dos.writeInt(20); // 4byte 를 그대로 저장
        dos.writeDouble(10.5);
        dos.writeBoolean(true);
        dos.close();

        FileInputStream fis = new FileInputStream("temp/data.dat");
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        dis.close();
    }
}
