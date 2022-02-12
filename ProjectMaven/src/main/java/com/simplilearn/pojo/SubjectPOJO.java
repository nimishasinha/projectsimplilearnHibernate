package com.simplilearn.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="subject")
public class SubjectPOJO {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int subjectId;
	private String subjectName;
	
	@ManyToOne
    @JoinColumn(name="teacher_id")
	private TeacherPOJO teacher;
	
	@ManyToMany(mappedBy="subjects")
    private List<ClassRoomPOJO> classRoom = new ArrayList<ClassRoomPOJO>();
	
	
	
	public TeacherPOJO getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherPOJO teacher) {
		this.teacher = teacher;
	}
	public List<ClassRoomPOJO> getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(List<ClassRoomPOJO> classRoom) {
		this.classRoom = classRoom;
	}
	public SubjectPOJO(String subjectName) {
		super();
		this.subjectName = subjectName;
	}
	public SubjectPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return "SubjectPOJO [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
	
}
