package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Program {
    static Random random = new Random();

    static Candidate generateCandidate(){
        int index = random.nextInt(3);
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
        switch (index){
            case 0:
                return new Student(names[random.nextInt(names.length)]+" "+surnames[random.nextInt(surnames.length)]);
            case 1:
                return new Master(names[random.nextInt(names.length)]+" "+surnames[random.nextInt(surnames.length)]);
            case 2:
                return new Specialist(names[random.nextInt(names.length)]+" "+surnames[random.nextInt(surnames.length)]);
        }
        return null;
    }



    public static void main(String[] args) {
        Publisher jobAgency = new JobAgency();
        Company google = new Company(jobAgency, "Google", 120000);
        Company yandex = new Company(jobAgency, "Yandex", 95000);
        Company geekBrains = new Company(jobAgency, "GeekBrains", 90000);

        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        for (int i=0; i< 10; i++){
            candidates.add(generateCandidate());
        }

        for (Candidate e:candidates) {
            jobAgency.registerObserver((Observer) e);
        }

        for (int i = 0; i < 2; i++){
            google.needEmployee();
            yandex.needEmployee();
            geekBrains.needEmployee();
            System.out.println("=".repeat(100));
        }



    }

}

