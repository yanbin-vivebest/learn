package com.learn.demo.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NioCharsetTest {
    public static void main(String[] args) throws  Exception{
        String inputFile = "charset_input.txt";
        String outputFile = "charset_output.txt";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile,"r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile,"rw");

        long inputLength = new File(inputFile).length();

        FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
        FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

        //内存映射buffer
        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY,0,inputLength);

        // 该处换成UTF-8和iso-8859-1 都是会正常将文件写到文件中去，并且不会乱码
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        //解码成charbuffer(字节的缓冲)
        CharBuffer charBuffer = decoder.decode(inputData); //先解码

        for(int i = 0;i<charBuffer.length() ;i++){
            System.out.println("--------->" + charBuffer.get(i));
        }

        ByteBuffer outputData = encoder.encode(charBuffer);//再编码

        outputFileChannel.write(outputData); //再输出到文件中去

        inputRandomAccessFile.close();
        outputRandomAccessFile.close();



    }
}
