package com.metro.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private Long mobileNo;

    public Customer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
