package com.techelevator.model.kudo;

public class KudoDetail {

    private int id;
    private int teacherId;
    private String firstName;
    private String lastName;
    private int studentId;
    private String message;
    private int typeId;
    private String kudoTypeName;
    private String kudoTypeDescription;
    private int kudoTypeValue;
    private String approvalStatus = "Pending";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getKudoTypeName() {
        return kudoTypeName;
    }

    public void setKudoTypeName(String kudoTypeName) {
        this.kudoTypeName = kudoTypeName;
    }

    public String getKudoTypeDescription() {
        return kudoTypeDescription;
    }

    public void setKudoTypeDescription(String kudoTypeDescription) {
        this.kudoTypeDescription = kudoTypeDescription;
    }

    public int getKudoTypeValue() {
        return kudoTypeValue;
    }

    public void setKudoTypeValue(int kudoTypeValue) {
        this.kudoTypeValue = kudoTypeValue;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
