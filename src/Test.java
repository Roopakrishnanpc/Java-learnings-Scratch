import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,3,6,8,10,12,16,19,21,1};
		OptionalInt max = Arrays.stream(array).max();
        if (max.isPresent()) {
            System.out.println("Maximum value: " + max.getAsInt());
        } else {
            System.out.println("Array is empty");
        }
		//Arrays.sort(array);
		//System.out.println(Arrays.stream(array).map(a->a).max());
		//Arrays.stream(array)..collect(Collectors.groupingBy(e-> e, ));
		int num1=0, num2=0;
		int sum=0, value=0;
		
		for(int i=0; i<array.length-1; i++)
		{
			for(int j=i+1; j<array.length; j++)
			{
				sum=array[i]+array[j];
				//value=sum;
				if(sum>value)
				{
					value=sum;
                    num1 = array[i];
                    num2 = array[j];
				}
				
			}
		}
		System.out.println(num1 + " "+ num2);
		int sum1=array[array.length-1]+array[array.length-2];
		
		/*List<Integer> list = Arrays.stream(array)
                                   .boxed()  // Convert int[] to List<Integer>
                                   .sorted(Comparator.reverseOrder())  // Sort in descending order
                                   .collect(Collectors.toList());

        // Find the maximum sum pair
        int maxSum = list.get(0) + list.get(1);  // The largest two numbers in the sorted list
        int num1 = list.get(0);
        int num2 = list.get(1);

        // Output the maximum sum and the pair
        System.out.println("Maximum sum of a pair: " + maxSum);
        System.out.println("The pair is: (" + num1 + ", " + num2 + ")");*/
	}

}
