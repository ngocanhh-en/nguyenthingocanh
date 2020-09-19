package giaiphuongtrinh;

import java.util.Scanner;

public class songuyento {
	public static boolean dieukien (int n)
	{
		// so nguyen n < 2 khong phai la so nguyen to
		if(n<2)
		{
			return false;
		}
		 // check so nguyen to khi n >= 2
		int ktra = (int )Math.sqrt(n);
		for(int i=2; i<=ktra; i++)
		{
			if(n%i==0)
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println("Nhap n= ");
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		System.out.print("Cac so nguyen to la: " + n );
		for (int i=1; i<n;i++)
		{
			if(dieukien(i))
			{
				System.out.print(" " + i );
			}
		}
	}
}
