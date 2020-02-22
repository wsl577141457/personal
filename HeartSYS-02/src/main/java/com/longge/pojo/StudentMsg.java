package com.longge.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.sound.midi.Soundbank;

@Table(name = "tb_studentmsg")
public class StudentMsg {
    private Integer id;
    private String college;
    private String profession;
    @Column(name = "classNum")
    private String classNum;
    private Integer grade = 0;
    private Integer level;
    @Transient
    private String levelStr;
    private String name;
    @Transient
    private TeacherAccount teacherAccount;
    private String stunum;
    @Transient
    private StudentAccount studentAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public TeacherAccount getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(TeacherAccount teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public StudentAccount getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(StudentAccount studentAccount) {
        this.studentAccount = studentAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelStr() {
        if(level == null){
            return "未测试";
        }
        if(this.level == 1){
            return "A";
        }
        else if(this.level == 2){
            return "B";
        }
        else if(this.level == 3){
            return "C";
        }
        else if(this.level == 4){
            return "D";
        }
        return "未测试";
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    @Override
    public String toString() {
        return "StudentMsg{" +
                "id=" + id +
                ", college='" + college + '\'' +
                ", profession='" + profession + '\'' +
                ", classNum='" + classNum + '\'' +
                ", grade=" + grade +
                ", level=" + level +
                ", teacherAccount=" + teacherAccount +
                ", stunum='" + stunum + '\'' +
                ", studentAccount=" + studentAccount +
                '}';
    }
}
