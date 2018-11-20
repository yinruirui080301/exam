import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ShowPaper extends JFrame implements ActionListener{
  
	
	/**
	 * ��ѧ������ʱ����֤����������Ϣ�󣬾�Ҫ��ʾ�Ծ�
	 */
	private static final long serialVersionUID = 1L;
    
	private TakeExam takeExam;
	private List<JLabel> problems=new ArrayList<JLabel>();
	private List<JTextField> answers=new ArrayList<JTextField>();
	private JButton commit=new JButton("����");
	private List<StudentAnswer> studentAnswers=new ArrayList<StudentAnswer>();
	
	public ShowPaper(TakeExam takeExam){
		//takeExam��ʾ��ǰҪ���еĿ���
		this.takeExam=takeExam;
		//��ʾ��ǰ����ʹ�õ������Ծ�
		int paperNo=takeExam.getTestPaperNo();
		//��Ҫ���������ҵ���ǰ�Ծ����������ı��
		List<MakePaper> list=DataTable.makePapers;
		//��Ҫ����������ҵ��������������
		List<TestProblem> listPro=DataTable.testProblems;
		//�ҵ����Ծ����е���
		String pro="";
		int teacherNo=-1;
		//�Ծ����е��ⶼ��������
		for(int i=0;i<list.size();i++){
			if (list.get(i).getTestPaperNo()==paperNo){
				int problemNo=list.get(i).getTestProblemNo();
				//��������ı�Ŵ���������ҵ����������
				for(int j=0;j<listPro.size();j++){
					if (listPro.get(j).getTestProblemNo()==problemNo){
						pro=listPro.get(j).getProblem();
						teacherNo=listPro.get(j).getTeacherNo();
						break;
					}
				}
				//���ҵ��ľ�������ǰ����Ͼ��ڱ�ţ��ŵ���ǩ�У��Ա���ʾ�ٴ����С�
				JLabel jl=new JLabel(list.get(i).getInnerNo()+":"+pro);
				problems.add(jl);
				//׼��������ı�������𰸺ܶ࣬�������ı���
				JTextField jtf=new JTextField(10);
				answers.add(jtf);
				//�����Խ�����Ҫ��ÿ�����⼰�𰸷ŵ��������У����ó�ʼ�ɼ�λ-1����Ϊ��û����
				StudentAnswer sa=new StudentAnswer();
				sa.setExamNo(takeExam.getExamNo());
				sa.setStudentNo(takeExam.getStudentNo());
				sa.setProblemNo(problemNo);
				sa.setTeacherNo(teacherNo);
				sa.setScore(-1);
				
				studentAnswers.add(sa);
			}
		}
		//���ô���
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
		 * ��ѧ������󣬽�ѧ���𰸼��뵽���Դ𰸶����С�
		 * �����д�ò�����ֻҪ���и����������ԣ��ͳ����ˣ�ֻ�ܵ�һ����������
		 * ������������޸ģ�
		 */
	  for(int i=0;i<answers.size();i++){
		 studentAnswers.get(i).setAnswer(answers.get(i).getText());
		 //���������޸ģ���Ҫ������
		 studentAnswers.get(i).setStudentAnswerNo(i+1);
	  }
	  //������޸ģ���Ҫ������
	  DataTable.studentAnswers=studentAnswers;
	  System.out.println("listlist="+DataTable.studentAnswers);
	  this.setVisible(false);
	  javax.swing.JOptionPane.showConfirmDialog(this,"���ѽ���10������ɼ�");
	  
	}
}
