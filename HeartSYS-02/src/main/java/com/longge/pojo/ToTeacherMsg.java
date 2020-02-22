package com.longge.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_toteachermsg")
public class ToTeacherMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private StudentAccount studentAccount;
    private TeacherAccount teacherAccount;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentAccount getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(StudentAccount studentAccount) {
        this.studentAccount = studentAccount;
    }

    public TeacherAccount getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(TeacherAccount teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
