package giaiphuongtrinh;

import java.util.Scanner;

public class gptbac1 {
	public static int nhapso(String str)
	{
		int x; 
		Scanner sc= new Scanner(System.in);
		System.out.println(str);
		x=sc.nextInt();
		return x;
	}
	public static void gpt1(int a, int b)
	{
		if(a==0)
		{
			if(b==0)
			{
				System.out.println("Phuong trinh vo so nghiem");
			}
			else
			{
				System.out.println("phuong trinh vo nghiem");
			}
		}
		else 
		{
			System.out.println("Phuong trinh co nghiem x= " + (-b/a));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		a=nhapso("Nhap he so a= " );
		b=nhapso("Nhap he so b= " );
		gpt1(a,b);
	}
}
