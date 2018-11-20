import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class TeacherToMake extends JFrame implements ActionListener{
	   /**
	 * 教师批阅学生答案
	 */
	   private static final long serialVersionUID = 1L;
	
	   private JLabel name;
	   private JTextField tfName;
	   private JButton makingPaper;
	   private JLabel tishi;
	   private Container con;
	   public TeacherToMake(){
		   this.setSize(150,400);
		   this.setVisible(true);
		   name=new JLabel("教师姓名");
		  
		   tfName=new JTextField(10);
		  
		   tishi=new JLabel();
		   makingPaper=new JButton("阅卷");
		   con=this.getContentPane();
		   con.setLayout(new FlowLayout());
		   con.add(name);con.add(tfName);
		   con.add(makingPaper);con.add(tishi);
		   makingPaper.addActionListener(this);
	   }
	   public void actionPerformed(ActionEvent e){
		   //先找到教师的编号
		   int teacherNo=0;
		   boolean flag=false;
		   Teacher[] teachers=DataTable.teachers;
		   for(int i=0;i<teachers.length;i++){
			   if (teachers[i].getTeacherName().equals(tfName.getText())){
				   teacherNo=teachers[i].getTeacherNo();
				   flag=true;break;
			   }
		   }
		   //再找到学生提交的答卷中是该教师出的题
		   if (flag) { new ShowStudentAnswer(teacherNo);
		      this.setVisible(false);
		   }else{
			   tishi.setText("教师不存在或信息输入错误");
		   }
		   //显示那些答卷的题（不可编辑）
	   }
	   public static void main(String arg[]){
		   new TeacherToMake();
	   }
}
