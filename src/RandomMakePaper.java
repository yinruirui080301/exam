import java.util.Random;

/**
 ������������������ȡ���������һ���Ծ�
**/
public class RandomMakePaper {
   public  TestPaper randomMakePaper(int courseNo,int problemNums){
	   TestPaper tp=new TestPaper();
	   //�����Ծ�ı�ź������γ̺�
	   tp.setTestPaperNo(DataTable.testPapers.size()+1);
	   tp.setCourseNo(courseNo);
	   //�������problemNums����ͬ��20���ڵ���������Ϊ�����ֻ��20����
	   int nums[]=randomNums(problemNums);
	   for(int i=0;i<problemNums;i++){
		   /**
		    �������������5�����֣��ֱ���1��3��5��10��8,��ô����еĵ�1��3��5��10��8����������˵�ǰ���Ծ�
		   **/
		   MakePaper mp=new MakePaper();
		   mp.setInnerNo(i+1);
		   mp.setScore(20);
		   mp.setTestProblemNo(nums[i]);
		   mp.setTestPaperNo(tp.getTestPaperNo());
		   DataTable.makePapers.add(mp);
	   }
	   return tp;
   }
   private int[] randomNums(int nums){
	   int no[]=new int[nums];
	   int x;
	   Random ran=new Random();
	   for(int i=0;i<nums;i++){
		int j;
		do{
		  j=0;
		  x=1+ran.nextInt(20);
	      while(j<i){
		    if (x==no[j]) break;
		    j++;
	      }
		}while(j!=i);
	    no[i]=x;
	   }
	   return no;
   }
   /**
    * ��Ϊ������漰��������ɲ�ͬ�������������б�Ҫʹ��main��������
    * 
    */
   public static void main(String ar[]){
	   RandomMakePaper r=new RandomMakePaper();
	   System.out.println("XXXX");
	   int x[]=r.randomNums(5);
	  
	   for(int i=0;i<x.length;i++){
		   System.out.println(x[i]);
	   }
   }
}
