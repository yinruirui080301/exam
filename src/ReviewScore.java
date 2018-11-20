import java.util.List;

/**�����ܳɼ�**/
public class ReviewScore {
	/**����ѧ��λstudentNo��ѧ���μ�course�γ̵Ŀ��Գɼ� **/
    public int reviewScore(int studentNo,String course){
    	boolean flag=true;
    	List<StudentAnswer> studentAnswers=DataTable.studentAnswers;
    	List<TakeExam> takeExam=DataTable.takeExams ;
    	Course[] courses=DataTable.courses;
    	Exam[] exams=DataTable.exams;
    	/**
    	 * ���ݿγ������ҿγ̺�
    	 */
    	int cno=-1,examno=-1;
    	for(int i=0;i<courses.length;i++){
    		if (courses[i].getCourseName().equals(course)){
    			cno=courses[i].getCourseNo();
    			break;
    		}
    	}
    	
    	//�������γ������ԣ���鲻���γ̺ţ���ô�ͷ���-1��˵�������ܳɼ�ʧ��
    	if (cno==-1) return -1;
    	/**
    	 * ���ݿγ̺Ų��Ҷ�Ӧ�Ŀ��Ժš�����Ĭ����һ�ſγ�ֻ��һ�Ρ�
    	 * ���һ�ſγ�Ҫ���ö�εĻ����͵��ټ���һ�����Ե�ʱ��
    	 */
    	for(int i=0;i<exams.length;i++){
    		if (exams[i].getCourseNo()==cno){
    			examno=exams[i].getExamNo();break;
    		}
    	}
    	if (examno==-1)return -1;
    	
    	int sum=0;
    	
    	/**
    	 * �����еĿ��������ҳ���ǰ�����Ĵ𰸣����ۼӡ������һ����û�ģ����ܼ����ܳɼ�������-1
    	 */
    	for(int i=0;i<studentAnswers.size();i++){
    		if (studentAnswers.get(i).getStudentNo()==studentNo&&studentAnswers.get(i).getExamNo()==examno){
    			if (studentAnswers.get(i).getScore()==-1) return -1;
    			sum+=studentAnswers.get(i).getScore();
    			
    		}
    	}
    	/**
    	 * ���ܳɼ��ŵ��μӿ��ԣ�׼����Ϣ����¼�С�
    	 */
    	for(int i=0;i<takeExam.size();i++){
    		if (takeExam.get(i).getExamNo()==examno&&takeExam.get(i).getStudentNo()==studentNo){
    			takeExam.get(i).setScore(sum);
    		}
    	}
    	
    	return sum;
    }
}
