package com.learn.demo.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost",8899),600);

        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person = client.getPersonByUsername("yanbin");
            System.out.println(person.getAge());
            System.out.println(person.getUsername());
            System.out.println(person.isMarried());

            System.out.println("----------------");
            Person person2 = new Person();
            person2.setUsername("yanbin2");
            person2.setMarried(false);
            person2.setAge(23);
            client.savePerson(person2);


        }catch (Exception e){
            throw  new RuntimeException(e.getMessage(),e);
        }finally {
            transport.close();
        }
    }
}
