package com.stmlab.android.lib;

public class MainTask1 {
    public static void main(String[] args) {
        User tester = new User(7,"Developer");
        System.out.println(tester.getId());
        System.out.println(tester.getVacancy());
    }
}
class User {
    private long id;
    private Vacancy vacancy;
    User(long id, String vacancyName) {
        this.id = id;
        vacancy = new Vacancy(vacancyName);
    }
    String getVacancy() {
        return vacancy.getVacancy();
    }
    long getId() {
        return id;
    }
}

class Vacancy {
    String name;
    Vacancy(String name) {
        this.name = name;
    }
    String getVacancy() {
        return name;
    }
}
/*Самая простая реализация класса User. Так же можно внести правки в класс с помощию наследования*/

//class UserExt extends Vacancy {
//    private long id;
//    UserExt(long id, String vacancyName) {
//        super(vacancyName);
//        this.id = id;
//    }
//    long getId() {
//        return id;
//    }
//}
/////////////////Исходный код/////////////////
//public static void main(String[] args) {
//        User tester = new User(7,“Developer”); //Невозможно создать экземпляр класса так, как нет конструктора
//        System.out.println(tester.getId());
//        System.out.println(tester.getVacancy());
//    }
//class User {
//    private long id;
//    private Vacancy vacancy;
//    String getVacancy() {
//        return vacancy.getVacancy(); //получим значение указанное в методе Vacancy.getVacancy(), а не указанное в конструкторе
//    }
//    long getId() {
//        return id;
//    }
//}
//class Vacancy { //класс не хранит информацию о наименовании вакансии
//    String getVacancy() {
//        return "engineer";
//    }
//}