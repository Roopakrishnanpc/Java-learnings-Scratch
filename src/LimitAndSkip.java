import java.util.Arrays;
import java.util.List;

public class LimitAndSkip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> initialList = Arrays.asList(10, 28, 87, 10, 20, 76, 28, 80);
		initialList.stream().limit(4).forEach(x->System.out.println(x));
		initialList.stream().skip(4).forEach(x->System.out.println(x));
	}

}
