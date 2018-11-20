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
	   name=new JLabel("姓名");
	   course=new JLabel("课程");
	   tfName=new JTextField(10);
	   tfCourse=new JTextField(10);
	   tishi=new JLabel();
	   exam=new JButton("考试");
	   Container con=this.getContentPane();
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
	   //判断此学生能参加考试吗(准考证中信息是否正确）
	   int zhunkaono=0;
	   List<TakeExam> te=DataTable.takeExams;
	   Exam exam[]=DataTable.exams;
	   Course course[]=DataTable.courses;
	   boolean flag=false;
	   /**
	    * 从准考信息中，根据学生学号找出当前学生参加的考试号，
	    * 再根据考试号查出课程号
	    * 再根据课程号查出课程名
	    * 看一下和考生输入的课程名是否一致
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
	   //组卷
	   if (flag){
		   RandomMakePaper rmp=new RandomMakePaper();
		   TestPaper tp=rmp.randomMakePaper(2,5);
		 //显示试卷
		   te.get(zhunkaono).setTestPaperNo(tp.getTestPaperNo());
		   new ShowPaper(te.get(zhunkaono));
		   
		   this.setVisible(false);
		   
	   }else{
		  tishi.setText("你不能参加考试或信息输入有误");
	   }
	   
	   
   }
   public static void main(String arg[]){
	   new StudentToExam();
   }
}
