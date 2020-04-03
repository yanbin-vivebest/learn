package com.learn.demo.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {
    public static void main(String[] args) {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAge(20).setAddress("北京").build();

        System.out.println(student.getName());

        System.out.println("--------------");

        byte[] student2ByteArrary = student.toByteArray();
        DataInfo.Student student2 = null;
        try {
            student2 = DataInfo.Student.parseFrom(student2ByteArrary);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println(student2);
        System.out.println("--------------------");
        System.out.println(student2.getAge());
        System.out.println(student2.getName());
        System.out.println(student2.getAddress());

    }
}
