package com.simplilearn.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "classRoom")
public class ClassRoomPOJO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLASS_ID")
	private int classId;
	private String className;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CLASS_SUBJECT", joinColumns = { @JoinColumn(name = "CLASS_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SUBJECT_ID") })
	private List<SubjectPOJO> subjects = new ArrayList<SubjectPOJO>();

	@ManyToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "classRoom", targetEntity = TeacherPOJO.class)
	private List<TeacherPOJO> classRoom = new ArrayList<TeacherPOJO>();

	public List<SubjectPOJO> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectPOJO> subjects) {
		this.subjects = subjects;
	}

	public ClassRoomPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassRoomPOJO(String className) {
		super();
		this.className = className;
	}

	public int getclasstId() {
		return classId;
	}

	public void setclassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "ClassRoomPOJO [classId=" + classId + ", className=" + className + "]";
	}

}
