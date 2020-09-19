package giaiphuongtrinh;

import java.util.Scanner;

public class giaithua {
	
	
	public static void main(String[] args) {
		int a;
		System.out.println("Nhap vao mot so can tinh:");
		Scanner sc= new Scanner(System.in);
		a= sc.nextInt();
		long giaithua = 1;
		int i=1;
		while(i<=a)
		{
			giaithua=giaithua *i;
			i++;
		}
		System.out.println("Giai thua cua " + a + " la: " + giaithua);

	}

}
