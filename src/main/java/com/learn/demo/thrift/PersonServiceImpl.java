package com.learn.demo.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * 服务端和客户端各自生成代码后，服务端实现接口，客户端调用接口
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("params:" + username);

        Person person = new Person();
        person.setAge(27);
        person.setMarried(true);
        person.setUsername("yanbin");

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("person:" + person);
        System.out.println(person.getAge());
        System.out.println(person.getUsername());
        System.out.println(person.isMarried());

    }
}
