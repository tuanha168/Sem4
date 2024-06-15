package com.example.model;

import javax.persistence.*;
import java.util.List;
import com.example.model.*;

@Entity
@Table(name = "subject_t")
public class Subject implements java.io.Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer subject_id;

    String subject_code;

    String subject_name;

    String credit;

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<StudentScore> student_scores;
}
