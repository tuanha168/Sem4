package com.example.model;

import javax.persistence.*;
import java.util.List;
import com.example.model.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student_t")
public class Student implements java.io.Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer student_id;

    String student_code;

    String full_name;

    String address;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<StudentScore> student_scores;

    public List<StudentScore> getStudent_scores() {
        return student_scores;
    }
}
