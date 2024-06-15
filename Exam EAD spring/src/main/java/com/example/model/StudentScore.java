package com.example.model;

import javax.persistence.*;
import com.example.model.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "student_score_t")
public class StudentScore {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int student_score_id;
  private double score1;
  private double score2;

  @ManyToOne
  @JoinColumn(name = "student_id")
  @JsonBackReference
  private Student student;

  @ManyToOne
  @JoinColumn(name = "subject_id")
  private Subject subject;

  public int getStudentScoreId() {
    return student_score_id;
  }

  public void setStudentScoreId(int student_score_id) {
    this.student_score_id = student_score_id;
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

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }
}
