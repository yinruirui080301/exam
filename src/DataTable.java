import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DataTable {
   public static Student[] students=new Student[2];
   public static Teacher[] teachers=new Teacher[2];
   public static Exam[] exams=new Exam[2];
   public static Course[] courses=new Course[3];
   public static List<TakeExam> takeExams=new ArrayList<TakeExam>();
   public static List<MakePaper> makePapers=new ArrayList<MakePaper>();
   public static List<TestPaper> testPapers=new ArrayList<TestPaper>();
   public static List<TestProblem> testProblems=new ArrayList<TestProblem>();
   public static List<StudentAnswer> studentAnswers=new ArrayList<StudentAnswer>();
  static{
	   //��ʼ��������Ϣ
	   Student s1=new Student();
	   s1.setName("ѧ��1"); s1.setStudentNo(19);
	   Student s2=new Student();
	   s2.setName("ѧ��2"); s2.setStudentNo(20);
	   students[0]=s1; students[1]=s2;
	   //��ʼ����ʦ��Ϣ
	   Teacher t1=new Teacher(); t1.setTeacherName("��ʦ1");t1.setTeacherNo(1);
	   Teacher t2=new Teacher(); t2.setTeacherName("��ʦ2");t2.setTeacherNo(2);
	   teachers[0]=t1; teachers[1]=t2;
	   //��ʼ���γ�
	   Course c1=new Course();
	   c1.setCourseName("����"); c1.setCourseNo(1);
	   Course c2=new Course();
	   c2.setCourseName("��ѧ"); c2.setCourseNo(2);
	   Course c3=new Course();
	   c3.setCourseName("Ӣ��"); c3.setCourseNo(3);
	   courses[0]=c1; courses[1]=c2; courses[2]=c3;
	   //���Եĳ�ʼ��
	   Exam e1=new Exam();
	   e1.setCourseNo(2); e1.setExamAddress("��ѧ¥405"); e1.setExamNo(1);e1.setExamTime(new Date());
	   Exam e2=new Exam();
	   e2.setCourseNo(1); e2.setExamAddress("����¥213"); e2.setExamNo(2);e2.setExamTime(new Date());
       exams[0]=e1; exams[1]=e2;
       //��ʼ������
       TestProblem tp1=new TestProblem();
       tp1.setCourseNo(2); tp1.setProblem("1��1���ڼ���");
       tp1.setTeacherNo(1); tp1.setTestProblemNo(1);
       testProblems.add(tp1);
       
       TestProblem tp2=new TestProblem();
       tp2.setCourseNo(2); tp2.setProblem("2��2���ڼ���");
       tp2.setTeacherNo(1); tp2.setTestProblemNo(2);
       testProblems.add(tp2);
       
       TestProblem tp3=new TestProblem();
       tp3.setCourseNo(2); tp3.setProblem("3��3���ڼ���");
       tp3.setTeacherNo(1); tp3.setTestProblemNo(3);
       testProblems.add(tp3);
       
       TestProblem tp4=new TestProblem();
       tp4.setCourseNo(2); tp4.setProblem("4��4���ڼ���");
       tp4.setTeacherNo(1); tp4.setTestProblemNo(4);
       testProblems.add(tp4);
       
       TestProblem tp5=new TestProblem();
       tp5.setCourseNo(2); tp5.setProblem("5��5���ڼ���");
       tp5.setTeacherNo(1); tp5.setTestProblemNo(5);
       testProblems.add(tp5);
       
       TestProblem tp6=new TestProblem();
       tp6.setCourseNo(2); tp6.setProblem("6��6���ڼ���");
       tp6.setTeacherNo(1); tp6.setTestProblemNo(6);
       testProblems.add(tp6);
       
       TestProblem tp7=new TestProblem();
       tp7.setCourseNo(2); tp7.setProblem("7��7���ڼ���");
       tp7.setTeacherNo(1); tp7.setTestProblemNo(7);
       testProblems.add(tp7);
       
       TestProblem tp8=new TestProblem();
       tp8.setCourseNo(2); tp8.setProblem("8��8���ڼ���");
       tp8.setTeacherNo(1); tp8.setTestProblemNo(8);
       testProblems.add(tp8);
       
       TestProblem tp9=new TestProblem();
       tp9.setCourseNo(2); tp9.setProblem("9��9���ڼ���");
       tp9.setTeacherNo(1); tp9.setTestProblemNo(9);
       testProblems.add(tp9);
       
       TestProblem tp10=new TestProblem();
       tp10.setCourseNo(2); tp10.setProblem("10��10���ڼ���");
       tp10.setTeacherNo(1); tp10.setTestProblemNo(10);
       testProblems.add(tp10);
       
       TestProblem tp11=new TestProblem();
       tp11.setCourseNo(2); tp11.setProblem("3����5���ڼ�");
       tp11.setTeacherNo(2); tp11.setTestProblemNo(11);
       testProblems.add(tp11);
       
       TestProblem tp12=new TestProblem();
       tp12.setCourseNo(2); tp12.setProblem("8����4���ڼ�");
       tp12.setTeacherNo(2); tp12.setTestProblemNo(12);
       testProblems.add(tp12);
       
       TestProblem tp13=new TestProblem();
       tp13.setCourseNo(2); tp13.setProblem("7����7���ڼ�");
       tp13.setTeacherNo(2); tp13.setTestProblemNo(13);
       testProblems.add(tp13);
       
       TestProblem tp14=new TestProblem();
       tp14.setCourseNo(2); tp14.setProblem("9����3���ڼ�");
       tp14.setTeacherNo(2); tp14.setTestProblemNo(14);
       testProblems.add(tp14);
       
       TestProblem tp15=new TestProblem();
       tp15.setCourseNo(2); tp15.setProblem("2����2���ڼ�");
       tp15.setTeacherNo(2); tp15.setTestProblemNo(15);
       testProblems.add(tp15);
       
       TestProblem tp16=new TestProblem();
       tp16.setCourseNo(2); tp16.setProblem("6����8���ڼ�");
       tp16.setTeacherNo(2); tp16.setTestProblemNo(16);
       testProblems.add(tp16);
       
       TestProblem tp17=new TestProblem();
       tp17.setCourseNo(2); tp17.setProblem("5����9���ڼ�");
       tp17.setTeacherNo(2); tp17.setTestProblemNo(17);
       testProblems.add(tp17);
       
       TestProblem tp18=new TestProblem();
       tp18.setCourseNo(2); tp18.setProblem("4����7���ڼ�");
       tp18.setTeacherNo(2); tp18.setTestProblemNo(18);
       testProblems.add(tp18);
       
       TestProblem tp19=new TestProblem();
       tp19.setCourseNo(2); tp19.setProblem("8����5���ڼ�");
       tp19.setTeacherNo(2); tp19.setTestProblemNo(19);
       testProblems.add(tp19);
       
       TestProblem tp20=new TestProblem();
       tp20.setCourseNo(2); tp20.setProblem("7����9���ڼ�");
       tp20.setTeacherNo(2); tp20.setTestProblemNo(20);
       testProblems.add(tp20);
       
       //��ʼ��׼��֤��Ϣ
       TakeExam tx1=new TakeExam();
       tx1.setExamNo(1); tx1.setScore(-1); tx1.setStudentNo(19);
       takeExams.add(tx1);
       
       TakeExam tx2=new TakeExam();
       tx2.setExamNo(2); tx2.setScore(-1); tx2.setStudentNo(20);
       takeExams.add(tx2);
  }
}
