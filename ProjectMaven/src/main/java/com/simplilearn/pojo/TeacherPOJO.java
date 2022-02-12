package com.simplilearn.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="teacher")
public class TeacherPOJO {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String teacherName;
	
	
	 @OneToMany(mappedBy="teacher")
	private List<SubjectPOJO> subject; 
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TEACHER_CLASS", 
        joinColumns = { @JoinColumn(name = "Teacher_Id") }, 
        inverseJoinColumns = { @JoinColumn(name = "Class_id") })
    private List<ClassRoomPOJO> classRoom = new ArrayList<ClassRoomPOJO>();
	
	public List<ClassRoomPOJO> getClassRoom() {
		return classRoom;
	}



	public void setClassRoom(List<ClassRoomPOJO> classRoom) {
		this.classRoom = classRoom;
	}



	public TeacherPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public List<SubjectPOJO> getSubject() {
		return subject;
	}



	public void setSubject(List<SubjectPOJO> subject) {
		this.subject = subject;
	}



	public TeacherPOJO(String teacherName) {
		super();
		this.teacherName = teacherName;
	}



	public int getTeacherId() {
		return teacherId;
	}



	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}



	public String getTeacherName() {
		return teacherName;
	}



	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}



	@Override
	public String toString() {
		return "TeacherPOJO [teacherId=" + teacherId + ", teacherName=" + teacherName + "]";
	}
	
	

}
