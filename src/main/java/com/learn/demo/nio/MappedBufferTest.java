package com.learn.demo.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedBufferTest{
    public static void main(String[] args)  throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("mapped.txt","rw");

        FileChannel channel = randomAccessFile.getChannel();

        //MappedByteBuffer是文件内存映射，就是将整个文件内容或者一部分内容映射到内存中,位于堆外内存
        //将文件的0到5的位置直接映射到内存中，现在我们对这0到5位置的操作就是直接反应到了文件中
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        //下面是对映射到的内存的值进修修改，会直接反应到文件上
        map.put(0,(byte)'a'); //直接将0-5位置上的第0个进行修改
        map.put(2,(byte)'b'); //直接将0-5位置上的第2个进行修改

        randomAccessFile.close();

        //文件中原始内容为123456789，运行完之后，变为a2b456789
    }
}
