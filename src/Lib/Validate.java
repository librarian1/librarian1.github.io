package Lib;
import java.io.*;
import java.util.Scanner;

public class Validate {

	public void Validate()
	{
		try(
				Scanner op = new Scanner("1+2");
			){
			    
				while(op.hasNext()) 
				{			
					int result = this.doResult(op.nextLine());
					System.out.println(result);
				}
			}catch (Exception e) {
				System.out.println("请输入");
			}


	}

	public int doResult(String INFIX)
	{
		int result = 0;
		String str1 = INFIX;
		String str2 = "";
		int lBracIndex = str1.lastIndexOf('(');
		int rBracIndex = str1.indexOf(')');
		boolean ifLegal = true;

		while(!str1.equals(str2))
		{
			boolean str1eqstr2 = false;
			
			if(lBracIndex == -1 && rBracIndex == -1)//去括号
			{
				str2 = str1;
				str1eqstr2 = true;
				
			}
			else
			{
				str2 = str1.substring(lBracIndex+1, rBracIndex);
			}
			
			
			//注意括号内负数,计算括号内
			if(str2.charAt(0) == '-')
			{

				str2 = "0" + str2;
			}

				String []strnum = str2.split("[\\+\\-\\*\\÷]");
				String []operator = str2.split("\\d+");
				
				System.out.println(operator[1]);
				
				int i = 0;
				int j = 1;
				result = Integer.parseInt(strnum[0]);
				
				while(j < operator.length)
				{
					i++;

					if(operator[j].equals("+") )
            		{
            			result +=Integer.parseInt(strnum[i]);
    			
            		}
            		else if (operator[j].equals("-")) 
            		{
            			result -= Integer.parseInt(strnum[i]);

    				}
            		else if (operator[j].equals("*")) 
            		{
            			result *= Integer.parseInt(strnum[i]);
    				}
            		else if (operator[j].equals("÷")) 
            		{
 /*           			if(result == 0) {  //异常0
            				ifLegal = false;
            				break;
            			}
 */
            			int cur1 = result;
            			result /= Integer.parseInt(strnum[i]);
 /*           			if(cur1 > result * Integer.parseInt(strnum[i]))//异常分数
            			{
            				ifLegal = false;
            				break;
            			}
 */           			
            		}
					j++;
				}	
			
			str2 = "" + result;	
			
			if(str1eqstr2)//str2数值替换str1括号内表达式
			{
				str1=str2;
			}
			else
			{
				str1 = str1.substring(0, lBracIndex) + str2 +
				   str1.substring(rBracIndex+1);
				lBracIndex = str1.lastIndexOf('(');
				rBracIndex = str1.indexOf(')');
			}

		}
	
		return result;
		
		
	}
}
