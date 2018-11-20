import java.util.Date;

//这是“考试”实体类，其成员变量来自于E_R图上的实体
public class Exam {
   private int examNo;
   private  String examAddress;
   private Date examTime;
   private int courseNo;
public int getExamNo() {
	return examNo;
}
public void setExamNo(int examNo) {
	this.examNo = examNo;
}
public String getExamAddress() {
	return examAddress;
}
public void setExamAddress(String examAddress) {
	this.examAddress = examAddress;
}
public Date getExamTime() {
	return examTime;
}
public void setExamTime(Date examTime) {
	this.examTime = examTime;
}
public int getCourseNo() {
	return courseNo;
}
public void setCourseNo(int courseNo) {
	this.courseNo = courseNo;
}
   
}
