package ru.geekbrains.lesson7.observer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Company {

    private Random random = new Random();

    Publisher jobAgency;

    private String name;

    public int getMaxSalary() {
        return maxSalary;
    }

    private int maxSalary;

    public Company(Publisher jobAgency, String name, int maxSalary) {
        this.jobAgency = jobAgency;
        this.name = name;
        this.maxSalary = maxSalary;
    }

    public void needEmployee(){
        Vacancy vacancy = new Vacancy(maxSalary);
        jobAgency.sendOffer(name, vacancy);
    }

}
