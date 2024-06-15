package com.example.dto;

public class CreateStudentScoreDTO {
    private int student_id;
    private int subject_id;
    private double score1;
    private double score2;

    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getSubject_id() {
        return subject_id;
    }
    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public double getScore1() {
        return score1;
    }
    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }
    public void setScore2(double score2) {
        this.score2 = score2;
    }
}
