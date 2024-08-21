package model;

public class Details {

	private int studentid;
	private String studentname;
	private String course;
	private int fees;
	private int paidfee;
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public int getPaidfee() {
		return paidfee;
	}
	public void setPaidfee(int paidfee) {
		this.paidfee = paidfee;
	}
}
