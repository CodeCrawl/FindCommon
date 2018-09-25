import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CommonList {

	public static void main(String args[])
	{
		int a[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int b[] = new int[]{2,4,18};
		
		LinkedList<Integer> L1 = new LinkedList<Integer>();
		LinkedList<Integer> L2 = new LinkedList<Integer>();
		
		fillList(L1, a);
		fillList(L2, b);
		
		ArrayList<Integer> commons = getCommon(L1, L2);
		
		System.out.print("Common Items: ");
		
		for(Integer item : commons)
		{
			System.out.print(item + " ");
		}	
	}
	
	public static void fillList(LinkedList<Integer> L, int items[])
	{
		for(int i = 0; i < items.length; i++)
		{
			L.add(items[i]);
		}
	}
	
	public static ArrayList<Integer> getCommon(LinkedList<Integer> L1, LinkedList<Integer> L2)
	{
		ArrayList<Integer> commons = new ArrayList<Integer>();
		
		Iterator<Integer> itr1= L1.iterator();
		Iterator<Integer> itr2 = L2.iterator();
		
		int a,b;
		
		//just the initialization step
		//setting the first elements from both the lists to a and b respectively
		if(itr1.hasNext() && itr2.hasNext())
		{
			a = itr1.next();
			b = itr2.next();
		}
		else
			return commons;
		
		//once we have the first elements, we start comparing the lists
		
		int iterations = 0;
		boolean hasElements=true;
		
		while(hasElements)
		{	
			if(a < b)
			{
				//check if list 1 has more elements to compare
				if (itr1.hasNext())
					a = itr1.next();
				else
					hasElements = false;	
			}
			
			else if(b < a)
			{
				//check if list 2 has more elements to compare
				if(itr2.hasNext())
				{
					b = itr2.next();
				}
				else
					hasElements = false;
			}
				
			else
			{
				//found a common element, when a == b
				commons.add(a);
				
				//check if list 1 has more elements to compare
				if (itr1.hasNext())
					a = itr1.next();
				else
					hasElements = false;
				
				//check if list 2 has more elements to compare
				if(itr2.hasNext())
				{
					b = itr2.next();
				}
				else
					hasElements = false;
			}
			
			iterations++;
			
		};
		
		
		System.out.println("Number of items in list 1 = " + L1.size());
		System.out.println("Number of items in list 2 = " + L2.size());
		System.out.println("Number of common items = " + commons.size());
		System.out.println("Number of iterations = " + iterations);
		
		return commons;
	}
	
	
}
