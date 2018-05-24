package com.example.nora.learningfirebase;

public class Data {
    String username,email,phone,password,conpassword ,ssn;

    public Data(String email,String password){
        this.email = email;
        this.password=password;
    }

    public Data(String username, String email,String phone,String password,String conpassword ,String ssn) {
        this.username =username;
        this.email = email;
        this.phone =phone;
        this.password=password;
        this.conpassword=conpassword;
        this.ssn=ssn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone(){ return  phone;}
    public void  setPhone(String phone){this.phone=phone;}
    public String getPassword(){ return  password;}
    public void  setPassword(String password){this.password=password;}
    public String getConpassword(){ return  conpassword;}
    public void  setConpassword(String conpassword){this.conpassword=conpassword;}
    public String getSsn(){ return  ssn;}
    public void  setSsn(String ssn){this.ssn=ssn;}


}
