package ru.geekbrains.lesson7.observer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Vacancy {
    private Random random =new Random();
    private String type;

    public String getType() {
        return type;
    }

    public int getSalary() {
        return salary;
    }

    private int salary;

    public Vacancy(int maxSalary) {
        this.type = setTypeVacancy();
        this.salary = setSalary(maxSalary);
    }
    private String setTypeVacancy(){
        List<typeVacancy> listType = Arrays.asList(typeVacancy.values());
        return String.valueOf(random.nextInt(listType.size()));
    }

    private int setSalary(int maxSalary){
        int salary = random.nextInt(maxSalary);
        return salary;
    }


}
