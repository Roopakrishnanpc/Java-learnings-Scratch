import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayProgramQuestionsforFindLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] values= {10,20,544,89,23,70};
		int[] values= {10,20};
		int[] avl= {};
		int value=fetchSecondLargest(values);
		int ansfoempty=fetchSecondLargest(avl);
		System.out.println(ansfoempty);
		System.out.println(value);
	}

	private static int fetchSecondLargest(int[] arr) {
		// TODO Auto-generated method stub
		
		if(arr==null||arr.length<2)
		{
			//not good practice so use illeagal argument exception
			return Integer.MIN_VALUE;
		}
		Arrays.sort(arr);
		//		OptionalInt s1=Arrays.stream(arr).sorted().skip(arr.length-2).findFirst();
		int s1=Arrays.stream(arr).distinct().sorted().skip(arr.length-2).findFirst().orElseThrow(() -> new IllegalArgumentException("Arrays doesnot have any value"));
//		int largest = arr[arr.length - 1];
//		System.out.println(arr.length +" 0 to 5 is there so arr.length is 6 so -1 because array start from 1");
//		System.out.println(largest);
//		int secondlargest=Integer.MIN_VALUE;
//		System.out.println(secondlargest);
//		for(int i=arr.length-2; i>=0;i--)
//		{
//			System.out.println(i+" " +secondlargest + " "+(arr.length-2));
//			if(arr[i]!=largest)
//			{
//				//code goes only two times first at largest value
//				System.out.println(i+" " +secondlargest);
//				secondlargest=arr[i];
//				System.out.println(secondlargest);
//				break;
//			}
//		}
		int s=arr[arr.length-2];

		//return s1.orElse(Integer.MIN_VALUE);
		return s1;
	}

}
