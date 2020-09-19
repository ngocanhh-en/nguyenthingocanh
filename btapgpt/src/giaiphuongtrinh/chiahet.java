package giaiphuongtrinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class chiahet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Cac so chia het cho 7 ma khong chia het  cho 5 la:");
		for(int i=20;i<=100;i++)
		{
			if(i%7==0 && i%5!=0)
			{
				
				System.out.println("Cac so chia het cho 7 ma ko chi het cho 5 la:" +i);
			}
			
		}
	
		/* List<Integer> list = new ArrayList<Integer>();
	        for (int i = 10; i < 201; i++) 
	        {
	            if ((i % 7 == 0) && (i % 5 != 0)) 
	            {
	                list.add(i);
	            }
	        }
	        // hiển thị list ra màn hình
	        showList(list);
	    }
	 
	    public static void showList(List<Integer> list) 
	    {
	        if (list != null && !list.isEmpty()) 
	        {
	            int size = list.size();
	            for (int i = 0; i < size - 1; i++) 
	            {
	                System.out.print(list.get(i) + ", ");
	            }
	            System.out.println(list.get(size - 1));
	        }
	        */
	    }

}
