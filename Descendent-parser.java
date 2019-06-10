import java.util.*;
class Production
{
	String starting,end,terminal,nonTerminal;
	Production(String start,String end)
	{
		starting=start;
		this.end=end;
		Lexical();
	}
	
	String returnProduction()
	{
		return(starting+"->"+end);
	}
	void Lexical()
	{
			for(int j=0;j<end.length();j++)
			{
			if(end.charAt(j)>='A'&&end.charAt(j)<='Z')	
				nonTerminal=nonTerminal+end.charAt(j);
			else
				terminal=terminal+end.charAt(j);	
		
			}
	}
	boolean appearIn(char c)	
	{
		for(int i=0;i<terminal.length();i++)
		{
			if(terminal.charAt(i)==c)
			return(true);
			
		}
		return(false);
	}
	


}


class DescendentParser
{
 	private 
	String start,end,terminal,nonTerminal,input;
	Production[] P; 
	int n;
	public
	DescendentParser()
	{
		Scanner S=new Scanner(System.in);
		System.out.print("Enter no. of Production:");
		n=S.nextInt();
		P=new Production[n];
		nonTerminal=terminal="";
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Production "+i+":\n");
			System.out.print("Enter Starting Symbol:");
			start=S.next();	
			System.out.print("Enter Ending Symbol:");
			end=S.next();
			P[i]=new Production(start,end);
		}
			System.out.print("Enter Input String:");
			input=S.next();
			Lexical();
	}
		
	void Lexical()
	{
		int j;
		boolean flag;
		String temp=new String(input.replace("->",""));
		for(j=0;j<input.length();j++)
		{	
			if(temp.charAt(j)>='A'&&temp.charAt(j)<='Z')	
				nonTerminal=nonTerminal+temp.charAt(j);
			else
				terminal=terminal+temp.charAt(j);	
		}
		System.out.print("\nTerminal:"+terminal+" Length:"+terminal.length());
		
		for(j=0;j<terminal.length();j++)
		{
			flag=false;
			for(int i=0;i<n;i++)
			{
				if(P[i].appearIn(terminal.charAt(j)))
				{ 
					flag=true;
				break;
				}
		    }
		
			if(!flag)
			{
				System.out.println("\nSorry During Lexical We cannot find symbol '"+terminal.charAt(j)+"'!");
				System.exit(0);
			}
		}
		
			System.out.println("\nLexical analysis is done!");
	}
	boolean isTerminal(char a)
	{
	if(a>='A'&&a<='Z')
	{
		return(false);
	}		
	return(true);
	}
	
   void parse()
   {
	   int i,j,k=0,h;
			String temp;
			for(i=0;i<n;i++)
			{
				
			k=0;
			temp=P[i].end;
			System.out.println("\nChecking in Production:"+P[i].returnProduction());
			for(j=0;j<temp.length();j++)   
			{
			

			char ch=temp.charAt(j);
			if(isTerminal(ch))
			{
				if(terminal.charAt(k)!=ch)
				{
					//change the production
				System.out.println("Not matched BackTracking!");
       			break;
				}
				else
				{
					System.out.println("'"+terminal.charAt(k)+"' is matched!"+k);
					k++;
				}
			}
			else
			{
				String expanded=expand(temp.charAt(j));
				if(expanded.equals("!"))
				{   //expand with nothing
					temp=temp.replaceFirst(""+temp.charAt(j),"");
				}
				else
				{
					temp=temp.replaceFirst(""+temp.charAt(j),expanded);
				}
				System.out.println("\nAfter expanding:"+temp);
			j--;
			}
			
			}
		
				if(k>=(terminal.length()-1))
			{
				System.out.println("Matched"+k);
				System.exit(0);
			}
		
		}
   
   System.out.println("Not Matched"+k);
   }

	String expand(char ch)
	{
	for(int i=0;i<n;i++)
	{
		if(P[i].starting.charAt(0)==ch)
		{
			return(P[i].end);
		}
		
	}
	return(null);
	}
   
   
   
   
}

class Main
{
	
	public static void main(String[] a)
	{
	DescendentParser P1=new DescendentParser();	
	P1.parse();	
	}	
	
	
	
}
