import java.util.*;
class LeftFactori
{
 	private String str,string;
	String left,right,A,X;
	
	public
	LeftFactori()
	{
	A="A->";	
	X="X->";	
	}
	void get_string()
	{
	Scanner S=new Scanner(System.in);	
	System.out.print("Enter String:");
	str=S.nextLine();
	string=str;
	}
	
	void Left_Factori()
	{
	int i;
	char ch;
	i=str.indexOf("/");
		if(i!=-1)
		{
			left=str.substring(0,i);
			right=str.substring(i+1,str.length());
		}
		
		System.out.println("Left: "+left+" Right:"+right);
		for(int j=0;(j<left.length());j++)
		{
			for(int k=0;k<right.length();k++)
			{
				ch=left.charAt(j);
				if(ch==right.charAt(k))
				{
		
					left=left.replaceFirst(""+ch," ");
					right=right.replaceFirst(""+ch," ");
					A=A+ch;	
					break;
				}
			}
		}
	left=left.trim();
	right=right.trim();
	if(left.equals(null)||left.equals(""))
	{
		left="%";
	}
	if(right.equals(null)||right.equals(""))
	{
		right="%";
	}
	
	X=X+left+"/"+right;
	System.out.println(A+"X"+"\n"+X);
	
	}
	
	
}
class LeftFactoriMain
{
	
		public static void main(String[] args)
		{
		LeftFactori L1=new LeftFactori();
		L1.get_string();
		L1.Left_Factori();
	
		}
	
	
}


