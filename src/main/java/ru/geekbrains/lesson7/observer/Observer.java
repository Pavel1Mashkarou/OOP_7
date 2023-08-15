package ru.geekbrains.lesson7.observer;

public interface Observer {

    void receiveOffer(String nameCompany, Vacancy vacancy);

    String getType();

}
