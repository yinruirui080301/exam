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
	 * ��ʦ����ѧ����
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
		   name=new JLabel("��ʦ����");
		  
		   tfName=new JTextField(10);
		  
		   tishi=new JLabel();
		   makingPaper=new JButton("�ľ�");
		   con=this.getContentPane();
		   con.setLayout(new FlowLayout());
		   con.add(name);con.add(tfName);
		   con.add(makingPaper);con.add(tishi);
		   makingPaper.addActionListener(this);
	   }
	   public void actionPerformed(ActionEvent e){
		   //���ҵ���ʦ�ı��
		   int teacherNo=0;
		   boolean flag=false;
		   Teacher[] teachers=DataTable.teachers;
		   for(int i=0;i<teachers.length;i++){
			   if (teachers[i].getTeacherName().equals(tfName.getText())){
				   teacherNo=teachers[i].getTeacherNo();
				   flag=true;break;
			   }
		   }
		   //���ҵ�ѧ���ύ�Ĵ�����Ǹý�ʦ������
		   if (flag) { new ShowStudentAnswer(teacherNo);
		      this.setVisible(false);
		   }else{
			   tishi.setText("��ʦ�����ڻ���Ϣ�������");
		   }
		   //��ʾ��Щ�����⣨���ɱ༭��
	   }
	   public static void main(String arg[]){
		   new TeacherToMake();
	   }
}
