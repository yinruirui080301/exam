import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFramee extends JFrame implements ActionListener{
     /** 这是主类，程序的入口**/
	 private JButton studentExam,teacherMake,studentResearch;
	 public MainFramee(){
		 //初始化3个按钮
		 studentExam=new JButton("学生考试");
		 teacherMake=new JButton("教师阅卷");
		 studentResearch=new JButton("学生查分");
		 //设置窗口可见
		 setVisible(true);
		 //设置窗口大小
		 setSize(150,150);
		 //向窗口中添加3个按钮
		 Container con=this.getContentPane();
		 con.setLayout(new FlowLayout());
		 con.add(studentExam);
		 con.add(teacherMake);
		 con.add(studentResearch);
		 //为3个按钮添加事件处理
		 studentExam.addActionListener(this);
		 studentResearch.addActionListener(this);
		 teacherMake.addActionListener(this);
	 }
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==studentExam){
			 //当单击“学生考试”时，使用StudentToExam对象来处理
			 new StudentToExam();
		 }
		 if (e.getSource()==teacherMake){
			 //当单击“教师阅卷”时，使用TeacherToMake来处理
			 new TeacherToMake();
		 }
		 if(e.getSource()==studentResearch){
			 //当处理“学生查分”时，使用StudentResearchScore对象来处理
			 new StudentResearchScore();
		 }
	 }
	 public static void main(String ar[]){
		 new MainFramee();
	 }
}
