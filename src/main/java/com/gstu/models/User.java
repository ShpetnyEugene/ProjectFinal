package com.gstu.models;

public class User {

    private long idUser;
    private String firsName;
    private String lastName;
    private String patronymic;
    // TODO заменить на private Date date
    private int age;
    private String passportSerial;
    private String login;
    private String password;
    // TODO заменить на private Role role
    private int role;

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

    public User(String firsName, String lastName, String patronymic, int age, String passportSerial, String login, String password, int role) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.age = age;
        this.passportSerial = passportSerial;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
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
