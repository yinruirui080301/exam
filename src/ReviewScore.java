import java.util.List;

/**计算总成绩**/
public class ReviewScore {
	/**计算学号位studentNo的学生参加course课程的考试成绩 **/
    public int reviewScore(int studentNo,String course){
    	boolean flag=true;
    	List<StudentAnswer> studentAnswers=DataTable.studentAnswers;
    	List<TakeExam> takeExam=DataTable.takeExams ;
    	Course[] courses=DataTable.courses;
    	Exam[] exams=DataTable.exams;
    	/**
    	 * 根据课程名查找课程号
    	 */
    	int cno=-1,examno=-1;
    	for(int i=0;i<courses.length;i++){
    		if (courses[i].getCourseName().equals(course)){
    			cno=courses[i].getCourseNo();
    			break;
    		}
    	}
    	
    	//如果输入课程名不对，则查不出课程号，那么就返回-1，说明计算总成绩失败
    	if (cno==-1) return -1;
    	/**
    	 * 根据课程号查找对应的考试号。这里默认是一门课程只考一次。
    	 * 如果一门课程要考好多次的话，就得再加上一个考试的时间
    	 */
    	for(int i=0;i<exams.length;i++){
    		if (exams[i].getCourseNo()==cno){
    			examno=exams[i].getExamNo();break;
    		}
    	}
    	if (examno==-1)return -1;
    	
    	int sum=0;
    	
    	/**
    	 * 从所有的考生答案中找出当前考生的答案，并累加。如果有一个题没阅，则不能计算总成绩，返回-1
    	 */
    	for(int i=0;i<studentAnswers.size();i++){
    		if (studentAnswers.get(i).getStudentNo()==studentNo&&studentAnswers.get(i).getExamNo()==examno){
    			if (studentAnswers.get(i).getScore()==-1) return -1;
    			sum+=studentAnswers.get(i).getScore();
    			
    		}
    	}
    	/**
    	 * 将总成绩放到参加考试（准考信息）记录中。
    	 */
    	for(int i=0;i<takeExam.size();i++){
    		if (takeExam.get(i).getExamNo()==examno&&takeExam.get(i).getStudentNo()==studentNo){
    			takeExam.get(i).setScore(sum);
    		}
    	}
    	
    	return sum;
    }
}
