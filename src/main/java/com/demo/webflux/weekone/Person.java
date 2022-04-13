package com.demo.webflux.weekone;

public class Person {
    String name;
    String mail;
    String number;

    public Person(String name, String mail, String number) {
        this.name = name;
        this.mail = mail;
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
