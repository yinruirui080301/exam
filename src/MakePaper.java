//这是“组卷”实体类，其成员变量来自于E_R图上的实体
public class MakePaper {
   private int testPaperNo;
   private int testProblemNo;
   private int innerNo;
   private String correctAnswer;
   private int score;
public int getTestPaperNo() {
	return testPaperNo;
}
public void setTestPaperNo(int testPaperNo) {
	this.testPaperNo = testPaperNo;
}
public int getTestProblemNo() {
	return testProblemNo;
}
public void setTestProblemNo(int testProblemNo) {
	this.testProblemNo = testProblemNo;
}
public int getInnerNo() {
	return innerNo;
}
public void setInnerNo(int innerNo) {
	this.innerNo = innerNo;
}
public String getCorrectAnswer() {
	return correctAnswer;
}
public void setCorrectAnswer(String correctAnswer) {
	this.correctAnswer = correctAnswer;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
   
}
