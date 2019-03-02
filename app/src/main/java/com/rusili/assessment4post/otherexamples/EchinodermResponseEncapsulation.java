package com.rusili.assessment4post.otherexamples;

public class EchinodermResponseEncapsulation {
    private int age;

    public EchinodermResponseEncapsulation(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int ageIn5Years() {
        return age + 5;
    }
}
