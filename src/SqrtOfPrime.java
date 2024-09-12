import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SqrtOfPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Double> sqrtOfprimeStream=Stream.iterate(1, i->i+1)
				.filter(SqrtOfPrime::isPrime).
				map(x->Math.sqrt(x)).limit(10).collect(Collectors.toList());
		System.out.println(sqrtOfprimeStream);
		List<Double> sqrtOfprime=new ArrayList<>(10);
		
		System.out.println(sqrtOfprime.size());
		int num=100;
		int index=1;
		
        while (sqrtOfprime.size() < 10) {  // Check for the first 10 prime numbers
            if (isPrime(index)) {
            	sqrtOfprime.add(Math.sqrt(index));
            }
            index++;
        }
        System.out.println(sqrtOfprime.size());
		System.out.println(sqrtOfprime);
	}
    private static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number)//(int) Math.sqrt(number) + 1)
            .noneMatch(n -> number % n == 0);
    }
}
