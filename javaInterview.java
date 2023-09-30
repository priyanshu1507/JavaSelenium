package selenium;

import java.util.Scanner;

public class javaInterview {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int flag;
		for (int i = 1; i <= n ; i ++) {
			
			System.out.print(i);
			flag = i-1;
			while(flag>0) {
				int a = i*i;
				System.out.print(" " + a);
				flag--;
				if(flag>0) {
					System.out.print(" " + i);
					flag--;
				}
			}
			System.out.println();
		}
		
		
		
		
	}

}
