package com.gstu.models;

public class User {

    private long idUser;
    private String firsName;
    private String lastName;
    private String patronymic;
    private int age;
    private String passportSerial;
    private String login;
    private String password;
    private int role;// TODO ROLE как-то лучше сделать;

    public User(long idUser, String firsName, String lastName, String patronymic, int age, String passportSerial, String login, String password, int role) {
        this.idUser = idUser;
        this.firsName = firsName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.age = age;
        this.passportSerial = passportSerial;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }


    public String getLogin() {
        return login;
    }

    public int getRole() {
        return role;
    }

    public long getIdUser() {
        return idUser;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", passportSerial='" + passportSerial + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
