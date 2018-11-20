import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * 学生查分
 *
 */
public class StudentResearchScore extends JFrame implements ActionListener{
	   private JLabel name;
	   private JLabel course;
	   private JTextField tfName;
	   private JTextField tfCourse;
	   private JButton exam;
	   private JLabel tishi;
	   private Container con;
	   
	   public StudentResearchScore(){
		   this.setSize(200,200);
		   this.setVisible(true);
		   name=new JLabel("姓名");
		   course=new JLabel("课程");
		   tfName=new JTextField(10);
		   tfCourse=new JTextField(10);
		   tishi=new JLabel();
		   exam=new JButton("查成绩");
		   con=this.getContentPane();
		   con.setLayout(new FlowLayout());
		   con.add(name);con.add(tfName);con.add(course);
		   con.add(tfCourse);
		   con.add(exam);con.add(tishi);
		   exam.addActionListener(this);
}
	   public void actionPerformed(ActionEvent e){
		 //根据姓名取得学生学号
		   String name=tfName.getText();
		   int sno=-1;
		   Student ss[]=DataTable.students;
		   for(int i=0;i<ss.length;i++){
			   if (ss[i].getName().equals(name))
			   {sno=ss[i].getStudentNo();break;}
		   }
		   //计算机总成绩
		   ReviewScore rs=new ReviewScore();
		   int sum=rs.reviewScore(sno,tfCourse.getText());
		   //如果已经批阅，就在当前页面上显示总成绩。
		   if (sum>0){
			   
			   tishi.setText("你的成绩是:"+sum);
			   
		   }else{
			  tishi.setText("你的成绩还没出来或你输入的信息有误");
		   }
		   
		   
	   }
	   public static void main(String arg[]){
		   new StudentResearchScore();
	   }
}