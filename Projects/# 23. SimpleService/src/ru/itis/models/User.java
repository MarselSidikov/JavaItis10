package ru.itis.models;

import ru.itis.exceptions.EmptyCredentialsException;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;
    private String login;
    private String password;
    private UserRole role;

    private User(Builder builder) {
        this.id = builder.id;
        this.age = builder.age;
        this.password = builder.password;
        this.email = builder.email;
        this.login = builder.login;
        this.phone = builder.phone;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.role = builder.role;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    // статический вложенный класс
    public static class Builder {
        // поля, аналогичные полям обрамляющего класса User
        private int id;
        private String firstName;
        private String lastName;
        private int age;
        private String phone;
        private String email;
        private String login;
        private String password;
        private UserRole role;

        // методы, которые называются так же, как и поля
        // похожи на setters
        // но возвращают в качестве результата сам объект из которого
        // был вызван данный метод
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder role(UserRole role) {
            this.role = role;
            return this;
        }
        // метод, который вызывает конструктор обрамляющего класса
        // и в качестве аргумента передает объект
        // самого себя
        public User build() {
            if (isEmptyCredentials()) {
                throw new EmptyCredentialsException("Пустой пароль или логин");
            }
            return new User(this);
        }

        private boolean isEmptyCredentials() {
            return this.login == null ||
                    this.login.equals("") ||
                    this.password == null ||
                    this.password.equals("");
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isModerator() {
        return this.role.equals(UserRole.MODERATOR);
    }

    public String toString() {
        return id + "|"
                + firstName + "|"
                + lastName + "|"
                + age + "|"
                + email + "|"
                + phone + "|"
                + login + "|"
                + password + "|"
                + role.toString();
    }
}
