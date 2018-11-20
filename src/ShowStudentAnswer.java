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
	 * ����ʦ�ľ�ʱ����֤���ʦ��Ϣ�󣬾�Ҫ��ʾ����ѧ�������Ǹý�ʦ������Ĵ�
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
	  * ��ΪҪ��ʾĳ����ʦ���⣬���Թ��췽��Ӧ���н�ʦ���������
	  */
     public ShowStudentAnswer(int teacherNo){
    	 
    	 List<TestProblem> testProblem=DataTable.testProblems;
		 this.teacherNo=teacherNo;
		 answersNo=new ArrayList<Integer>();
		 commit=new JButton("�ľ����");
		 problems=new ArrayList<JLabel>();
		 answers=new ArrayList<JLabel>();
		 scores=new ArrayList<JTextField>();
		 System.out.println("listlist"+DataTable.studentAnswers.size());
		 //������ѧ�������ҵ�ǰ��ʦ������Ĵ�
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
					 //ȡ�õ�ǰ�����ٴ�����е���ţ��Ա��ľ���ɺ󣬰��Ž��÷ִ���
					 System.out.println("*###########");
					 answersNo.add(studentAnswers.get(i).getStudentAnswerNo());
					 JLabel lp=new JLabel("��: "+nowProblem);
					 problems.add(lp);
					 //�õ���
					 JLabel la=new JLabel("��: "+studentAnswers.get(i).getAnswer());
					 answers.add(la);
					 //׼��һ���ı����ý�ʦ����ɼ�
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
		 //����Щ��ѽ��ѽ�ųɼ����ı���ѽ�ӵ�������
		 for(int i=0;i<answers.size();i++){
			 con.add(problems.get(i));
			 con.add(answers.get(i));
			 con.add(scores.get(i));
		 }
		 
		 con.add(commit);
	 }
	 public void actionPerformed(ActionEvent e){
		 /**
		  * ����ʦ�����ľ����ʱ����Ҫ����ʦ���ķ�������ѧ��������Ӧ�ļ�¼��
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
