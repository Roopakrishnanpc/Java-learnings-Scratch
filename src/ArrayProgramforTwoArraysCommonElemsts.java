import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayProgramforTwoArraysCommonElemsts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] value1= {1,34,23,56,68};
		int[] value2= {34,23,56,98,1};
		
		Set<Integer> val=fetchCommonArray(value1,  value2);
		System.out.println(val);
	}

	private static Set<Integer> fetchCommonArray(int[] value1, int[] value2) {
		// TODO Auto-generated method stub
//		Set<Integer> newVal=new HashSet<>();
//		for(int i=0;i<value1.length;i++)
//		{
//			for(int j=0;j<value2.length;j++)
//			{
//				if(value1[i]==value2[j])
//				{
//					newVal.add(value1[i]);
//				}
//			}
//		}
//		return newVal;
//        Set<Integer> set1 = new HashSet<>();
//      for (int num : value1) {
//          set1.add(num);
//        }
//
//        Set<Integer> set2 = new HashSet<>();
//        for (int num : value2) {
//            set2.add(num);
//        }

//
//        // Find the intersection
//        set1.retainAll(set2);
//
//        return set1;
		//convert to int stream of integers -> boxed
		Set<Integer> set1 =Arrays.stream(value1).boxed().collect(Collectors.toSet());
		Set<Integer> set2 =Arrays.stream(value2).boxed().collect(Collectors.toSet());
		Set<Integer> finaset=new HashSet<>(set1); 
		finaset.retainAll(set2);
		Set<Integer> values=Arrays.stream(value1).filter(num1->Arrays.stream(value2).anyMatch(num2-> num1==num2)).boxed().collect( Collectors.toSet());
		//value1[value1.length]==value2[value2.length];
		return values;
	}

}
