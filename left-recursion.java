import java.util.*;

class LeftRecursion
{
	String end,newEnd[];
	char start;
	Scanner S;
	LeftRecursion()
	{
		newEnd=new String[2];
		S=new Scanner(System.in);
		System.out.print("Enter Starting Symbol:");
		start=S.next().charAt(0);
		System.out.print("Enter Ending Symbol:");
		end=S.next();	
	}
	boolean checkLeftrecursion(char Tstart,String Tend)
	{
		if((Tend.charAt(0)<'A'&&Tend.charAt(0)>'Z')||(Tend.charAt(0)!=Tstart))
		{
			return(false);
		}
		return(true);
		
	}
	void removeLeftRecursion()
	{
		int index;
		if(checkLeftrecursion(start,end))
		{
			if((index=end.indexOf('|'))==-1)
			{
				index=end.length()-1;
			}
			String alpha=end.substring(1,index),beta=end.substring(index+1,end.length());
		if(beta.equals(""))
		{
			beta=beta+'!';
		}
		System.out.print("Alpha:"+alpha+" beta:"+beta+"\n");
		
		newEnd[0]=beta+'X';
		newEnd[1]=alpha+"X|!";
		System.out.print(start+"->"+newEnd[0]+"\nX->"+newEnd[1]);
		}
		else
		{
					System.out.print("Left recursion is not present!");

		}
	
		
	}
	
	
	
 	
}

class LeftRecursionMain
{
	
	public static void main(String[] a)
	{
		LeftRecursion L=new LeftRecursion();
		L.removeLeftRecursion();
	}	
	
	
	
}
