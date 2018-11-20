import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class StudentToExam extends JFrame implements ActionListener{
   private JLabel name;
   private JLabel course;
   private JTextField tfName;
   private JTextField tfCourse;
   private JButton exam;
   private JLabel tishi;
   public StudentToExam(){
	   this.setSize(180,200);
	   this.setVisible(true);
	   name=new JLabel("����");
	   course=new JLabel("�γ�");
	   tfName=new JTextField(10);
	   tfCourse=new JTextField(10);
	   tishi=new JLabel();
	   exam=new JButton("����");
	   Container con=this.getContentPane();
	   con.setLayout(new FlowLayout());
	   con.add(name);con.add(tfName);con.add(course);
	   con.add(tfCourse);
	   con.add(exam);con.add(tishi);
	   exam.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e){
	   //��������ȡ��ѧ��ѧ��
	   String name=tfName.getText();
	   int sno=-1;
	   Student ss[]=DataTable.students;
	   for(int i=0;i<ss.length;i++){
		   if (ss[i].getName().equals(name))
		   {sno=ss[i].getStudentNo();break;}
	   }
	   //�жϴ�ѧ���ܲμӿ�����(׼��֤����Ϣ�Ƿ���ȷ��
	   int zhunkaono=0;
	   List<TakeExam> te=DataTable.takeExams;
	   Exam exam[]=DataTable.exams;
	   Course course[]=DataTable.courses;
	   boolean flag=false;
	   /**
	    * ��׼����Ϣ�У�����ѧ��ѧ���ҳ���ǰѧ���μӵĿ��Ժţ�
	    * �ٸ��ݿ��ԺŲ���γ̺�
	    * �ٸ��ݿγ̺Ų���γ���
	    * ��һ�ºͿ�������Ŀγ����Ƿ�һ��
	    */
	   for(int i=0;i<te.size();i++){
		   if (te.get(i).getStudentNo()==sno){
			   int examNo=te.get(i).getExamNo();
			   for(int j=0;j<exam.length;j++){
				   if (exam[j].getExamNo()==examNo){
					   int courseNo=exam[j].getCourseNo();
					   for(int k=0;k<course.length;k++){
						   if (course[k].getCourseNo()==courseNo){
							   if (course[k].getCourseName().equals(tfCourse.getText())){
								   flag=true;break;
							   }
						   }
					   }
					   break; 
				   }
			   }
			 zhunkaono=i;break;
		   }
	   }
	   //���
	   if (flag){
		   RandomMakePaper rmp=new RandomMakePaper();
		   TestPaper tp=rmp.randomMakePaper(2,5);
		 //��ʾ�Ծ�
		   te.get(zhunkaono).setTestPaperNo(tp.getTestPaperNo());
		   new ShowPaper(te.get(zhunkaono));
		   
		   this.setVisible(false);
		   
	   }else{
		  tishi.setText("�㲻�ܲμӿ��Ի���Ϣ��������");
	   }
	   
	   
   }
   public static void main(String arg[]){
	   new StudentToExam();
   }
}
