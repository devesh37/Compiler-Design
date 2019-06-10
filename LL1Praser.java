import java.util.*;

class Production
{
	String starting,end[],terminal,nonTerminal,first,follow;
	int endingSym;
	Production(String start,String ending[])
	{
		starting=start;
		end=ending;
		endingSym=end.length;
		Lexical();
		first="";
	}
	
	void display()
	{
		System.out.println("G:"+returnProduction()+" first:"+first+" follow:"+follow);
	}
	
	
	String returnProduction()
	{
		String temp="";
		for(int i=0;i<endingSym;i++)
		{
			temp=temp+end[i]+"/";
		}
		temp=temp.substring(0,temp.length()-1);
		return(starting+"->"+temp);
	}
	void Lexical()
	{
		terminal="";
		nonTerminal="";
			for(int i=0;i<endingSym;i++)
			{
			for(int j=0;j<end[i].length();j++)
			{
			if(end[i].charAt(j)>='A'&&end[i].charAt(j)<='Z')	
				nonTerminal=nonTerminal+end[i].charAt(j);
			else
				terminal=terminal+end[i].charAt(j);	
		
			}
			}
	}
	

}


class LL1Praser
{
	Production[] P;
	int n;
	String start,end[];
	LL1Praser()
	{
		int i,j,k;
	Scanner S=new Scanner(System.in);
	System.out.print("Enter number of Production:");
	n=S.nextInt();
	P=new Production[n];
	for(i=0;i<n;i++)
	{
		System.out.println("------------------------------\nEnter Production("+i+"):");
		
		int endingSym;
		System.out.print("Enter Starting Symbol:");
		start=S.next();
		System.out.print("Enter number ending Symbol:");
		endingSym=S.nextInt();
		
		end=new String[endingSym];
		for(j=0;j<endingSym;j++)
		{
		System.out.print("Enter End Symbol "+j+":");
		end[j]=S.next();
		}
		
		P[i]=new Production(start,end);
		System.out.println("Terminal:"+P[i].terminal);	
		System.out.println("Non-Terminal:"+P[i].nonTerminal);
		System.out.println(P[i].returnProduction());	
		
	}
	}
	
	void parse()
	{
		int i;
		System.out.println("\n-----------prasing-----------------\n");
		for( i=0;i<n;i++)
		{
		P[i].first=removeDuplicates(findFirst(P[i]));
		P[i].follow=removeDuplicates(findFollow(P[i]));	
		P[i].display();
		}
	
	
	}
	
	
	 String removeDuplicates(String input){
    String result = "";
    for (int i = 0; i < input.length(); i++) {
        if(!result.contains(String.valueOf(input.charAt(i)))) {
            result += String.valueOf(input.charAt(i));
        }
    }
    return result;
    }
	String findFirst(Production P1)
	{
	int i,j,k,o,p;
		String first="";
		for(j=0;j<P1.endingSym;j++)
		{
			String  temp=P1.end[j];
			k=0;
			if(isTerminal(temp.charAt(k)))
			{
				first=first+temp.charAt(k);
			}
			else
			{
			
				for(o=0;o<n;o++)
				{
					
					if(P1.starting.charAt(0)!=temp.charAt(k))
					{
						if(P[o].starting.charAt(0)==temp.charAt(k))
						{
							first=first+findFirst(P[o]);	
						}
					}
					else
					{
						System.out.println("Sorry Grammer has Left recursion ending prasing!");
						System.exit(0);
					}
				}
		    
			}
	
	
	      
		}
		return(first);
	}
	

	String findFollow(Production P1)
	{
		String follow="",temp;
		int i,j,k,index;
		for(i=0;i<n;i++)
		{
			
			
			for(j=0;j<P[i].endingSym;j++)
			{
			
				if((index=P[i].end[j].indexOf(P1.starting.charAt(0)))!=-1)
				{
					if(index<(P[i].end[j].length()-1))
					{
						char tempCh;
						if(isTerminal(tempCh=P[i].end[j].charAt(index+1)))
						{
							
							follow=follow+tempCh;
						}
						else
						{
								follow=follow+findFirst(P[i]);
						}
						
					}
					else
					{
						follow=follow+findFollow(P[i]);
					}
				}
			}
			
			
		}
		if(follow.equals(""))
		{
			follow=follow+"$";
		}
		follow=follow.replaceAll("!","$");	

	return(removeDuplicates(follow));
	}
boolean isTerminal(char a)
{
	
	if(a>='A'&&a<='Z')
	{
		return(false);
	}
	return(true);
}
		
	
	
   
}

class Main
{
	
	public static void main(String[] a)
	{
	LL1Praser L=new LL1Praser();
	L.parse();
	}	
	
	
	
}
