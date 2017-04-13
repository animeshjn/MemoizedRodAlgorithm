import java.util.Scanner;

/**
 * CS 583 HomeWork 3 QUestion 3 (Bonus)
 * @author Animesh Jain
 *
 */
public class MemoizedCostBonus {

	public static double[] r;
	public static int[] s;
	public static int instructionCounter=0;
	static void ModifiedBottomCutRod(double p[], int n, double c) {
		r = new double[n];
		s = new int[n];
		
		double q;
		for (int j = 1; j <= n; j++) {
			q = -1;
			s[j-1] = j;
			instructionCounter++;
			for (int i = 1; i <= j; i++) {
				if (q < p[i-1] + r[j - i] - c) {
					q = (p[i-1] + r[j - i] - c);
					s[j-1] = i;
				}
			}
			r[j-1]=q;
		}
	}

	public static void main(String[] args) {
		Scanner keyboard= new Scanner(System.in);
		System.out.println("HW3 Q3");
		System.out.println("please enter n:");
		int n= keyboard.nextInt();
		System.out.println("Enter revenue of cuts");
		double p[]= new double[n];
		for (int i = 0; i < p.length; i++) {
			System.out.print("Revenue for cut "+(i+1)+":");
			p[i]=keyboard.nextDouble();
		}
		
		System.out.println("Enter Fixed Cost: ");
		double c= keyboard.nextDouble();
		System.out.println("solution: ");
		MemoizedCostBonus.ModifiedBottomCutRod(p, n, c);
		 System.out.print("Actual Solution: ");
	        System.out.print("[  ");
	        for(int k=n-1;k>=0;k-=s[k])
	        {
	            System.out.print(s[k] + "  ");
	        }
	        System.out.print("]");
	        System.out.println("Instruction Counter: "+instructionCounter);
		keyboard.close();
		
	}
	
	
}
