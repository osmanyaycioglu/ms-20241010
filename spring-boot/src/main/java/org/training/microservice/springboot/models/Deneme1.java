package org.training.microservice.springboot.models;

public class Deneme1 {
    public static void main(String[] args) {
        Customer customerLoc = new Customer();
        customerLoc.setName("osman");

        Phone phoneLoc = new Phone();
        phoneLoc.setName("ev");
        phoneLoc.setNumber("328472374");

        customerLoc.setPhone(phoneLoc);

        System.out.println("customer : " + customerLoc);
    }
}
