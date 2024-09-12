interface FunctionalInterface
{
	abstract int multiply(int a, int b);
}
public class Multiply2NumbersFunctional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FunctionalInterface func= new FunctionalInterface() {
//			public int multiply(int a, int b) {
//				// TODO Auto-generated method stub
//				return a*b;
//			}};
		FunctionalInterface func= (a, b) ->	 a*b;
				// TODO Auto-generated method stub
			
			System.out.println(func.multiply(10, 20));
	}

	


}
