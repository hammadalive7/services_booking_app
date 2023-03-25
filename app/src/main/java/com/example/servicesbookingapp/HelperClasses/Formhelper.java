package com.example.servicesbookingapp.HelperClasses;

public class Formhelper {

    String Name, Phone, Address, NIC, Service1, Comment;

    public Formhelper(String name, String phone, String address, String NIC, String service, String comment) {
        Name = name;
        Phone = phone;
        Address = address;
        this.NIC = NIC;
        Service1 = service;
        Comment = comment;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getService() {
        return Service1;
    }

    public void setService(String service) {
        Service1 = service;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
