package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Student extends Candidate implements Observer {
    private Random random = new Random();

    private String type;
    private String name;
    int salary = 2000;

    public Student(String name) {
        this.name = name;
        this.type = setTypeVacancy();
    }

    private String setTypeVacancy(){
        List<typeVacancy> listTypeVacancies = Arrays.asList(typeVacancy.values());
        return String.valueOf(random.nextInt(listTypeVacancies.size()));
    }

    @Override
    public void receiveOffer(String nameCompany, Vacancy vacancy) {
        if (this.salary <= vacancy.getSalary()){
            System.out.printf("Student %s (type:%s): Мне нужна эта работа! (company: %s; salary: %d, typeVacancy: %s)\n", name,getType(),
                    nameCompany, vacancy.getSalary(), vacancy.getType());
            this.salary = vacancy.getSalary();
        }
        else {
            System.out.printf("Student %s (type:%s): Я найду работу получше! (company: %s; salary: %d,typeVacancy: %s)\n", name,getType(),
                    nameCompany, vacancy.getSalary(), vacancy.getType());
        }
    }

    @Override
    public String getType() {
        return type;
    }
}
