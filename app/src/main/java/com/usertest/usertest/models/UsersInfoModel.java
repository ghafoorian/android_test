package com.usertest.usertest.models;

/**
 * Created by asma on 9/17/17.
 */

public class UsersInfoModel {

    int Id;
    String Name;
    String Email;
    String IsFemal;
    int Age;
    String Hobbies;
    String Image;
    String Back;


    public UsersInfoModel(int id, String name, String email, String isFemal, int age, String hobbies, String image, String back) {
        Id = id;
        Name = name;
        Email = email;
        IsFemal = isFemal;
        Age = age;
        Hobbies = hobbies;
        Image = image;
        Back = back;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getIsFemal() {
        return IsFemal;
    }

    public void setIsFemal(String isFemal) {
        IsFemal = isFemal;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String hobbies) {
        Hobbies = hobbies;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getBack() {
        return Back;
    }

    public void setBack(String back) {
        Back = back;
    }
}
