package model;


import java.sql.Date;

public class Student{
    private int id;
    private String name;
    private Date birthday;
    private String address;
    private String phoneNumber;
    private String email;
    private String classroom_id;

    public Student() {

    }
    public Student(int id, String name, Date birthday, String address, String phoneNumber, String email, String classroom_id) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classroom_id = classroom_id;
    }
    public Student(String name, Date birthday, String address, String phoneNumber, String email, String classroom_id) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classroom_id = classroom_id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom(String classroom) {
        this.classroom_id = classroom_id;
    }


}
