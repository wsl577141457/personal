package com.longge.pojo;

import javax.persistence.*;

@Table(name = "tb_teachergroup")
public class TeacherGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "maxNum")
    private Integer maxNum;
    @Column(name = "chooseNum")
    private Integer chooseNum;

    @Transient
    private String fullStr;
    @Transient
    private TeacherAccount teacherAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getChooseNum() {
        return chooseNum;
    }

    public void setChooseNum(Integer chooseNum) {
        this.chooseNum = chooseNum;
    }



    public String getFullStr() {
        if(chooseNum < maxNum){
            return "未满人";
        }
        else if (chooseNum == maxNum){
            return "已满人";
        }
        return "出错";
    }

    public void setFullStr(String fullStr) {
        this.fullStr = fullStr;
    }

    public TeacherAccount getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(TeacherAccount teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    @Override
    public String toString() {
        return "TeacherGroup{" +
                "id=" + id +
                ", maxNum=" + maxNum +
                ", chooseNum=" + chooseNum +
                ", fullStr='" + fullStr + '\'' +
                ", teacherAccount=" + teacherAccount +
                '}';
    }
}
