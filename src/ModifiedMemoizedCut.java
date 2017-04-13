import java.util.Scanner;

/**
 * cs 583 Home work 3 
 * @author Animesh Jain
 *
 */
public class ModifiedMemoizedCut {
	public static double[] mem;
	public static int[] s;
	public static int instructionCounter=0;
	private static double modifiedMemoCutRod(double[] p) {
		int n = p.length;
		mem = new double[n + 1];
		s = new int[n + 1];
		for (int i = 0; i <= n; i++)
		{	mem[i] =-1;
			instructionCounter++;
		}
		return modifiedMemoCutRodRunner(p, n);
	}

	private static double modifiedMemoCutRodRunner(double[] p, int n) {
		
		if (n == 0) {
			mem[0] = 0;
			return 0;
		}
		if (mem[n] >= 0)
			return mem[n];
		double q = -1;
		for (int i = 1; i <= n; i++) {
			instructionCounter++;
			if (p[i - 1] + modifiedMemoCutRodRunner(p, n - i) > q) {
				q = p[i - 1] + modifiedMemoCutRodRunner(p, n - i);
				s[n - 1] = i;
			}
		}
		mem[n] = q;
		return q;
	}

	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Length:");
		int length = keyboard.nextInt();
		double[] p = new double[length];
		for (int i = 1; i <= length; i++) {
			System.out.println("Input Revenue for cut " + i + ":");
			p[i - 1] = keyboard.nextInt();
		}
		ModifiedMemoizedCut.modifiedMemoCutRod(p);
		System.out.print("Actual Solution: ");
		System.out.print("[  ");
		for (int n = length - 1; n >= 0; n -= s[n]) {
			System.out.print(s[n] + "  ");
		}
		System.out.print("]");
		System.out.println();
		System.out.println("Instruction Counter Value: "+instructionCounter);
		
		keyboard.close();
	}

}