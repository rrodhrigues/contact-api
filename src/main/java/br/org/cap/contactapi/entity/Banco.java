package br.org.cap.contactapi.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Banco {

    private static List<Person> personList = new ArrayList<>();

    static {

        Person person = new Person();
        person.setId(1l);
        person.setNome("Renato");
        person.setCodigo("452l");
        personList.add(person);

        Person person2 = new Person();
        person2.setId(2l);
        person2.setNome("Alex");
        person2.setCodigo("453l");
        personList.add(person2);

        Person person3 = new Person();
        person3.setId(3l);
        person3.setNome("Camargo");
        person3.setCodigo("454l");
        personList.add(person3);

    }

    public static List<Person> getPersonList() {
        return personList;
    }

    public static void setPersonList(List<Person> personList) {
        Banco.personList = personList;
    }

    public static Person getPersonOfList(Long id) {
        Person personRequest = new Person();

        for (Person person : personList) {
            if (person.getId().equals(id))
                personRequest = person;
        }

        return personRequest;
    }
}
