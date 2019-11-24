package com.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	private String skillName;
    private int rating;
    private String proficiency;
    
    @ManyToOne
    @JoinColumn(name="stud_id")
    @JsonBackReference
    private Student student;
    

  
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getProficiency() {
		return proficiency;
	}
	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}
	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skillName=" + skillName + ", rating=" + rating + ", proficiency="
				+ proficiency + ", student=" + student + "]";
	}
    
    
}