package com.techelevator.model.profile;

public class ParentStudent {
    private int parentId;
    private int studentId;
    private String relation;


    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "ParentStudent{" +
                "parentId=" + parentId +
                ", studentId=" + studentId +
                ", relation='" + relation + '\'' +
                '}';
    }
}
