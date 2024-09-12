import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysProgramForIntegerInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values= {10,20,544,89,23,70};
		findIntegerInPlace(values);
		reverseTheInteger(values);
		int r=reverseInteger(1789);
		System.out.println(r);
		String stri="Hello Hi";
		String s=reverseStringUsingStreams(stri);
		System.out.println(s);
	}

	private static void reverseTheInteger(int[] values) {
		// TODO Auto-generated method stub
		int left = 0;
        int right = values.length - 1;
        while(left<right)
        {
        	int temp=values[left];
        	values[left]=values[right];
        	values[right]=temp;
        	left++;
        	right--;
        }
        System.out.println("Print the value "+Arrays.toString(values));
        List<Integer> list=Arrays.stream(values).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        int[] value=list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(value));
        
	}

	private static int reverseInteger(int number) {
	    int reversed = 0;
	    int sign = (number < 0) ? -1 : 1;  // Determine the sign
	    number = Math.abs(number);  // Work with the absolute value
	    
	    while (number != 0) {
	        int digit = number % 10;
	        reversed = reversed * 10 + digit;
	        number /= 10;
	    }
	    return reversed * sign;  // Apply the sign
	}


	private static void findIntegerInPlace(int[] values) {
		// TODO Auto-generated method stub
		
		IntStream.range(0, values.length/2).forEach(i-> {
			int temp=values[i];
			values[i]=values[values.length-i-1];
			values[values.length-i-1]=temp;
		});
		System.out.println(Arrays.toString(values));
	}
    private static int reverseIntegerUsingStreams(int number) {
        String reversedString = new StringBuilder(String.valueOf(number))
            .reverse()  // Reverse the string representation
            .toString();  // Convert back to string

        // Handle cases where the reversed number might have leading zeros
        return Integer.parseInt(reversedString);
    }
    
    private static String reverseStringUsingStreams(String str) {
        String reversedString = new StringBuilder(String.valueOf(str))
            .reverse()  // Reverse the string representation
            .toString();  // Convert back to string

        // Handle cases where the reversed number might have leading zeros
        return reversedString;
    }
    private static String reverseStringUsingTrad(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
    private static String reverseStringUsingSubString(String name,String substring) {
    	if(name.contains(substring))
    	{
        String reversedString = new StringBuilder(String.valueOf(substring))
            .reverse()  // Reverse the string representation
            .toString();
        name.replace(substring, reversedString);// Convert back to string
    	}
        // Handle cases where the reversed number might have leading zeros
        return name;
    }
}
