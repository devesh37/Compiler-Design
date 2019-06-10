import java.util.*;
import java.io.*;


class LexicalAnalyzer
{
 	private String str,string;
	String indentfier,keyword,operator;
	public
	LexicalAnalyzer()
	{
		
		indentfier=keyword=operator="";
	}
	void get_string()
	{
	Scanner S=new Scanner(System.in);	
	System.out.print("Enter String:");
	str=S.nextLine();
	str=str+" ";
	string=str;
	}
	int in(String sub)
	{ 
	int i;
		if((i=str.indexOf(sub))!=-1)
		{
			return(i);
		}
	return(-1);	
	}
    void keyword()
	{   int j;
		String[] S={"int","float","char","double","long"};
	
		for(int i=0;i<5;i++)
		{
			j=str.indexOf(S[i]);
			if(j!=-1)
			{
				if(str.charAt(j+S[i].length())==' ')
				{
					
					keyword=keyword+"'"+S[i]+"',";
					str=str.replace(str.substring(j,(j+S[i].length())),"");
				}
			}
		}
	
	}
	
	void operator()
	{
		int j;
		String[] S={",","+","-","*",";","/","(",")","="}; 
		
		for(int i=0;i<=8;i++)
		{
			j=str.indexOf(S[i]);
			if(j!=-1)
			{
					
                   	operator=operator+"'"+S[i]+"',";
					str=str.replace(str.substring(j,(j+S[i].length()))," ");
					
				
			}
		}
		
		
		
	}
	
	void identifier()
	{
		int j;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>='a'&str.charAt(i)<='z')
			{   
		     
				for(j=i;str.charAt(j)!=' ';j++)
				{
		        			
       		    }
			indentfier=indentfier+"'"+str.substring(i,j)+"',";
				str=str.replace(str.substring(i,(j)),"");
			}
			
			
		}
		
		
		
		
		
		
	}
	
	void lexical()
	{
		

				keyword();
				operator();
			identifier();
	  System.out.println("\n\nkeyword:"+keyword+"\n\nIndetifier:"+indentfier+"\n\nOperator:"+operator+"\n\nConstants:"+str);
	
	}
	
	
	
	
	
	
}


class LexicalMain
{
	
		public static void main(String[] args)
		{
			LexicalAnalyzer l1=new LexicalAnalyzer();
				l1.get_string();
				l1.lexical();
		}
	
	
}


