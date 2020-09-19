package giaiphuongtrinh;

import java.util.Scanner;

public class gptbac2 {

	public static int nhapso(String str)
	{
		int x; 
		Scanner sc= new Scanner(System.in);
		System.out.println(str);
		x=sc.nextInt();
		return x;
	}
	public static void gpt(int a, int b, int c)
	{
		if(a==0)
		{
			if(b==0)
			{
				if(c==0)
				{
					System.out.println("Phuong trinh vo so nghiem");}
				else
				{
					System.out.println("Phuong trinh vo nghiem");
				}
			}
			else
			{
				System.out.println("Phuong trinh co mot nghiem la: x= " + (-c/b));
			}
		}
		else
		{
			float x1; 
			float x2;
			float denta= (float) (Math.pow(b, 2)-4*a*c);
			if(denta < 0)
			{
				System.out.println("Phuong trinh vo nghiem");
			}
			else if(denta > 0)
			{
				x1 = (float) ((-b + Math.sqrt(denta)) / (2*a));
	            x2 = (float) ((-b - Math.sqrt(denta)) / (2*a));
	            System.out.println("Phương trình có 2 nghiệm là: "
	                    + "x1 = " + x1 + " và x2 = " + x2);
			}
			else 
			{
				System.out.println("Phuong trinh co nghiem kep x1=x2= " + (-b / (2 * a)));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;
		a=nhapso("Nhap he so a= " );
		b=nhapso("Nhap he so b= " );
		c=nhapso("Nhap he so c= " );
		gpt(a,b,c);
	}

}
