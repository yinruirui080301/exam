//这是试题实体对象
public class TestProblem {
    private int testProblemNo;
    private int teacherNo;
    private int courseNo;
    private String problem;
	public int getTestProblemNo() {
		return testProblemNo;
	}
	public void setTestProblemNo(int testProblemNo) {
		this.testProblemNo = testProblemNo;
	}
	public int getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}
	public int getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
    
}
