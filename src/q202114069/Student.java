package q202114069;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	String studentNo;
	String name;
	public Student(String studentNo, String name) {
		this.studentNo = studentNo;
		this.name = name;
	}
	public String getStudentNo() { return studentNo; }
	public String getName() { return name; }
	public void setStudentNo(String studentNo) { this.studentNo = studentNo; }
	public void setName(String name) { this.name = name; }
}
