package com.cybertek.test;

import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println("hello world");

        Faker faker=new Faker();
        System.out.println(faker.name().fullName());
        System.out.println(faker.harryPotter().hashCode());
        System.out.println("faker.finance().iban() = " + faker.finance().iban());
    }
}
