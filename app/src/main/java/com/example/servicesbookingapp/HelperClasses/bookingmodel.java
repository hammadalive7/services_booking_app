package com.example.servicesbookingapp.HelperClasses;

public class bookingmodel {

    String name, service, address, phone;

    public bookingmodel(String name, String service, String address, String phone) {
        this.name = name;
        this.service = service;
        this.address = address;
        this.phone = phone;
    }

    public bookingmodel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //    public bookingmodel(String name2, String service2, String address2, String mail2) {
//        this.name2 = name2;
//        this.service2 = service2;
//        this.address2 = address2;
//        this.mail2 = mail2;
//    }

    //public  bookingmodel(){}

//    public String getName2() {
//        return name2;
//    }
//
//    public void setName2(String name2) {
//        this.name2 = name2;
//    }
//
//    public String getService2() {
//        return service2;
//    }
//
//    public void setService2(String service2) {
//        this.service2 = service2;
//    }
//
//    public String getAddress2() {
//        return address2;
//    }
//
//    public void setAddress2(String address2) {
//        this.address2 = address2;
//    }
//
//    public String getMail2() {
//        return mail2;
//    }
//
//    public void setMail2(String mail2) {
//        this.mail2 = mail2;
//    }
}
