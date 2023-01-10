package com.techelevator.model.point;

import java.time.LocalDate;

public class GradePoint extends Point{

    private String currentGradeLevel;

    public String currentGrade(int graduationYear){
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        if(now.getMonthValue() > 7){
            return "Grade " + (12 - (graduationYear - (currentYear + 1)));
        }else {
            return "Grade " + (12 - (graduationYear - currentYear));
        }
    }

    public String getCurrentGradeLevel() {
        return currentGradeLevel;
    }

    public void setCurrentGradeLevel(String currentGradeLevel) {
        this.currentGradeLevel = currentGradeLevel;
    }
}
