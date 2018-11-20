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
 * ѧ�����
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
		   name=new JLabel("����");
		   course=new JLabel("�γ�");
		   tfName=new JTextField(10);
		   tfCourse=new JTextField(10);
		   tishi=new JLabel();
		   exam=new JButton("��ɼ�");
		   con=this.getContentPane();
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
		   //������ܳɼ�
		   ReviewScore rs=new ReviewScore();
		   int sum=rs.reviewScore(sno,tfCourse.getText());
		   //����Ѿ����ģ����ڵ�ǰҳ������ʾ�ܳɼ���
		   if (sum>0){
			   
			   tishi.setText("��ĳɼ���:"+sum);
			   
		   }else{
			  tishi.setText("��ĳɼ���û���������������Ϣ����");
		   }
		   
		   
	   }
	   public static void main(String arg[]){
		   new StudentResearchScore();
	   }
}