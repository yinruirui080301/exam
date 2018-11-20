import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFramee extends JFrame implements ActionListener{
     /** �������࣬��������**/
	 private JButton studentExam,teacherMake,studentResearch;
	 public MainFramee(){
		 //��ʼ��3����ť
		 studentExam=new JButton("ѧ������");
		 teacherMake=new JButton("��ʦ�ľ�");
		 studentResearch=new JButton("ѧ�����");
		 //���ô��ڿɼ�
		 setVisible(true);
		 //���ô��ڴ�С
		 setSize(150,150);
		 //�򴰿������3����ť
		 Container con=this.getContentPane();
		 con.setLayout(new FlowLayout());
		 con.add(studentExam);
		 con.add(teacherMake);
		 con.add(studentResearch);
		 //Ϊ3����ť����¼�����
		 studentExam.addActionListener(this);
		 studentResearch.addActionListener(this);
		 teacherMake.addActionListener(this);
	 }
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==studentExam){
			 //��������ѧ�����ԡ�ʱ��ʹ��StudentToExam����������
			 new StudentToExam();
		 }
		 if (e.getSource()==teacherMake){
			 //����������ʦ�ľ�ʱ��ʹ��TeacherToMake������
			 new TeacherToMake();
		 }
		 if(e.getSource()==studentResearch){
			 //������ѧ����֡�ʱ��ʹ��StudentResearchScore����������
			 new StudentResearchScore();
		 }
	 }
	 public static void main(String ar[]){
		 new MainFramee();
	 }
}
