import java.util.stream.IntStream;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int num=3;
		System.out.println(IntStream.range(2, num).noneMatch(n->num%n==0));
		
boolean trueofalse=isPrime(num);
System.out.println(isPrime(num));
if(!trueofalse)
{
	System.out.println(num+" is not prime");
}
else
{
	System.out.println(num+" is prime");
}
	}
 private static boolean isPrime(int num)
 {
	 boolean isDivisible=false;
	 int count=0;
	 for(int i=2;i<num;i++)
	 {
	 if(num%i==0)
	 {
		 isDivisible=true;
		 count++;
		 break;
	 }
	 
	 }
	 return num>1&&!isDivisible;
 }
}
