import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ShowPaper extends JFrame implements ActionListener{
  
	
	/**
	 * 当学生考试时，验证完姓名等信息后，就要显示试卷。
	 */
	private static final long serialVersionUID = 1L;
    
	private TakeExam takeExam;
	private List<JLabel> problems=new ArrayList<JLabel>();
	private List<JTextField> answers=new ArrayList<JTextField>();
	private JButton commit=new JButton("交卷");
	private List<StudentAnswer> studentAnswers=new ArrayList<StudentAnswer>();
	
	public ShowPaper(TakeExam takeExam){
		//takeExam表示当前要进行的考试
		this.takeExam=takeExam;
		//表示当前考试使用的哪套试卷
		int paperNo=takeExam.getTestPaperNo();
		//需要从组卷表中找到当前试卷的所有问题的编号
		List<MakePaper> list=DataTable.makePapers;
		//需要从问题表中找到所有问题的内容
		List<TestProblem> listPro=DataTable.testProblems;
		//找到该试卷所有的题
		String pro="";
		int teacherNo=-1;
		//试卷所有的题都在组卷表中
		for(int i=0;i<list.size();i++){
			if (list.get(i).getTestPaperNo()==paperNo){
				int problemNo=list.get(i).getTestProblemNo();
				//根据问题的编号从问题表中找到具体的问题
				for(int j=0;j<listPro.size();j++){
					if (listPro.get(j).getTestProblemNo()==problemNo){
						pro=listPro.get(j).getProblem();
						teacherNo=listPro.get(j).getTeacherNo();
						break;
					}
				}
				//在找到的具体问题前面加上卷内标号，放到标签中，以便显示再窗口中。
				JLabel jl=new JLabel(list.get(i).getInnerNo()+":"+pro);
				problems.add(jl);
				//准备答题额文本框。如果答案很多，可以用文本域
				JTextField jtf=new JTextField(10);
				answers.add(jtf);
				//当考试结束，要将每个考题及答案放到考生答案中，设置初始成绩位-1，因为还没批阅
				StudentAnswer sa=new StudentAnswer();
				sa.setExamNo(takeExam.getExamNo());
				sa.setStudentNo(takeExam.getStudentNo());
				sa.setProblemNo(problemNo);
				sa.setTeacherNo(teacherNo);
				sa.setScore(-1);
				
				studentAnswers.add(sa);
			}
		}
		//布置窗口
		Container con=this.getContentPane();
		con.setLayout(new FlowLayout());
		this.setSize(200,400);
		this.setVisible(true);
		for(int i=0;i<problems.size();i++){
			con.add(problems.get(i));
			con.add(answers.get(i));
		}
		con.add(commit);
		commit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		/**
		 * 当学生交卷后，将学生答案加入到考试答案对象中。
		 * 这里编写得并不灵活，只要再有个考生来考试，就出错了，只能第一个考生考。
		 * 请大家想想如何修改？
		 */
	  for(int i=0;i<answers.size();i++){
		 studentAnswers.get(i).setAnswer(answers.get(i).getText());
		 //如果大家想修改，需要改这里
		 studentAnswers.get(i).setStudentAnswerNo(i+1);
	  }
	  //如果想修改，需要改这里
	  DataTable.studentAnswers=studentAnswers;
	  System.out.println("listlist="+DataTable.studentAnswers);
	  this.setVisible(false);
	  javax.swing.JOptionPane.showConfirmDialog(this,"你已交卷，10天后请查成绩");
	  
	}
}
