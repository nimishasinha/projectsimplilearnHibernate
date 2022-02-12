package com.simplilearn.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="student")
public class StudentPOJO {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int studentId;
	private String studentName;
	private String studentEmail;
	@OneToOne
    @JoinColumn(name="Class_Id")
	private ClassRoomPOJO classRoom;  
	
	public StudentPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentPOJO(String studentName, String studentEmail) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}

	public ClassRoomPOJO getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoomPOJO classRoom) {
		this.classRoom = classRoom;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		return "StudentPOJO [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", classRoom=" + classRoom + "]";
	}

	
	
	
	
	
}
