import java.util.Random;

/**
 随机组卷。从题库中随机抽取几个题组成一套试卷。
**/
public class RandomMakePaper {
   public  TestPaper randomMakePaper(int courseNo,int problemNums){
	   TestPaper tp=new TestPaper();
	   //设置试卷的编号和所属课程号
	   tp.setTestPaperNo(DataTable.testPapers.size()+1);
	   tp.setCourseNo(courseNo);
	   //随机生成problemNums个不同的20以内的整数，因为题库中只有20个词
	   int nums[]=randomNums(problemNums);
	   for(int i=0;i<problemNums;i++){
		   /**
		    假设随机生成了5个数字，分别是1，3，5，10，8,那么题库中的第1，3，5，10，8个问题组成了当前的试卷。
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
    * 因为这个类涉及到随机生成不同的整数，所以有必要使用main方法测试
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
