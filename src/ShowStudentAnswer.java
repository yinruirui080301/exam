import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ShowStudentAnswer extends JFrame implements ActionListener{
	/**
	 * 当教师阅卷时，验证完教师信息后，就要显示所有学生答案中是该教师出的题的答案
	 */
     private int teacherNo;
     private List<StudentAnswer> studentAnswers=DataTable.studentAnswers;
     private List<JLabel> problems;
     private List<JLabel> answers;
     private List<JTextField> scores;
     private List<Integer> answersNo;
     private JButton commit;
	 /**
	  * 
	  * 因为要显示某个教师的题，所以构造方法应该有教师编号做参数
	  */
     public ShowStudentAnswer(int teacherNo){
    	 
    	 List<TestProblem> testProblem=DataTable.testProblems;
		 this.teacherNo=teacherNo;
		 answersNo=new ArrayList<Integer>();
		 commit=new JButton("阅卷完成");
		 problems=new ArrayList<JLabel>();
		 answers=new ArrayList<JLabel>();
		 scores=new ArrayList<JTextField>();
		 System.out.println("listlist"+DataTable.studentAnswers.size());
		 //从所有学生答案中找当前教师出的题的答案
		 for(int i=0;i<studentAnswers.size();i++){
			 if (studentAnswers.get(i).getTeacherNo()==teacherNo){
				
				 String nowProblem="";
				 int problemNo=studentAnswers.get(i).getProblemNo();
				 for(int j=0;j<testProblem.size();j++){
					 if (testProblem.get(j).getTestProblemNo()==problemNo){
						nowProblem=testProblem.get(j).getProblem(); break;
					 }
				 }
				 if (!nowProblem.equals("")){
					 //取得当前答题再答题库中的序号，以便阅卷完成后，按号将得分存入
					 System.out.println("*###########");
					 answersNo.add(studentAnswers.get(i).getStudentAnswerNo());
					 JLabel lp=new JLabel("题: "+nowProblem);
					 problems.add(lp);
					 //得到答案
					 JLabel la=new JLabel("答: "+studentAnswers.get(i).getAnswer());
					 answers.add(la);
					 //准备一个文本框让教师输入成绩
					 JTextField tfs=new JTextField(4);
					 scores.add(tfs);
				 }	 
				 
			 }
		 }
		  
		 this.setVisible(true);
		 this.setSize(200,500);
		 Container con=this.getContentPane();
		 con.setLayout(new FlowLayout());
		 commit.addActionListener(this);
		 //把这些题呀答案呀放成绩的文本框呀加到窗口上
		 for(int i=0;i<answers.size();i++){
			 con.add(problems.get(i));
			 con.add(answers.get(i));
			 con.add(scores.get(i));
		 }
		 
		 con.add(commit);
	 }
	 public void actionPerformed(ActionEvent e){
		 /**
		  * 当教师单击阅卷完成时，需要将教师给的分数存入学生答案中相应的记录中
		  */
		 for(int i=0;i<answersNo.size();i++){
			int fenshu=Integer.parseInt(scores.get(i).getText());
			for(int j=0;j<studentAnswers.size();j++){
				if (studentAnswers.get(j).getStudentAnswerNo()==answersNo.get(i)){
					studentAnswers.get(j).setScore(fenshu);break;
				}
			}
			
		 }
		 this.setVisible(false);
	 }
	
}
