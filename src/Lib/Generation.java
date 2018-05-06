package Lib;

import java.io.PrintStream;
import java.util.concurrent.ConcurrentNavigableMap;

import javax.smartcardio.CommandAPDU;

import com.sun.corba.se.spi.ior.Identifiable;

import Lib.Interface.Bracket;
import Lib.Interface.Character;
import Lib.Interface.Number;
import Lib.Interface.Operator;
import InputException.OperationNumException;


public class Generation implements Number<Generation>, Operator<Generation>,
 Character<Generation>, Bracket<Generation> {

	public void main(String[] args)
	{
		// TODO Auto-generated method stub

		Generation g = new Generation();
		String[] operations = {};

        int i = 0;

/*        try {*/
        	while(i < args.length)
            {
            	switch (args[i])
        		{
    			case "-n":{
    		        try {
    		        	g.OperationNum = Integer.parseInt(args[i+1]);
    		        	i++;
    		          } catch (Exception e) {
    		              System.out.println("-n������������");
    		          }
    			}
    				break;
    			case "-m":{
    		        try {
    		        	g.lower = Integer.parseInt(args[i+1]);
    		        	g.upper = Integer.parseInt(args[i+2]);
    		        	i+=2;
    		          } catch (Exception e) {
    		        	  System.out.println("-m����˳�������������֣�lower upper");
    		          }
    			}
    				break;
    			case "-o":{
    		        try {
    					g.CRange = Integer.parseInt(args[i+1]);
    					i++;
    		          } catch (Exception e) {
    		        	  System.out.println("-o������������");
    		          }
    			}
    				break;
    			case "-c":{
    					g.ifM_D = true;
    			}
    				break;
    			case "-b":{
    				g.ifB = true;
    			}
    				break;
    			default:
    				break;
    			}
              	i++;
            }


/*	        try {
	            PrintStream ps = new PrintStream("../../result.txt");
	            System.setOut(ps);
	            operations = g.operation(g);
	            i = 0;
	            while(i<operations.length)
	            {
	            	System.out.println(operations[i]);
	            	i++;
	            }

	        } catch (Exception e) {
	            System.out.println("�ļ�����");
	        }
*///数组字符


	}

	public int OperationNum = 0;  //��ʼ��������-n
	public int lower = 0;//-m
	public int upper = 0;

	public int CRange = 1; //-o
	public boolean ifM_D = false;//-c
	public boolean ifB = false;//-b
	public boolean ifLegal = true;
	
	
	public int CharacterN;
	public int OperatorN;
	public strOperation OperatorL;
	public strOperation CharaL;
	
	public String operation(Generation g)
/*	 throws OperationNumException*/
	{
  /*      if((g.OperationNum == 0))//��n
        	throw new OperationNumException();
        else if(g.OperationNum < 1 || g.OperationNum > 1000)//n������Χ��
        	throw new OperationNumException();
   */     
		int OperationNum = g.OperationNum;
		int CRange = g.CRange;
		
//修改		
		String operation = null;
		while(!g.ifLegal)
		{
			g.ifLegal = true;
			g.CharacterN = 1 + (int)(Math.random() * (CRange));
			g.OperatorN = g.CharacterN + 1;			
			g.OperatorL =  g.operator(g);
			g.CharaL = g.character(g);
			
			operation =  g.bracket(g);
		}
		
		return operation;
		
		
		
/*		String[] operations = new String[OperationNum];
		int i = 0;
		
		while(!(OperationNum == 0))
		{
			g.CharacterN = 1 + (int)(Math.random() * (CRange));
			g.OperatorN = g.CharacterN + 1;			
			g.OperatorL =  g.operator(g);
			g.CharaL = g.character(g);
			
			operations[i] =  g.bracket(g);
			if(!g.ifLegal)
			{
				i--;
		        OperationNum++;
			}
	        i++;
	        OperationNum--;
	        g.ifLegal = true;
		}

		return operations;
		*/
	}
	
	public strOperation operator(Generation g)
	{				
		int OperatorN = g.OperatorN;
		int lower = g.lower;
		int upper = g.upper;
		
		strOperation OperatorL = new strOperation();
	        
        while(!(OperatorN == 0))
        {
        	int integer = lower + (int)(Math.random() * (upper-lower+1));//Vrange	
			
        	OperatorL.insertFirstd(integer);
		    			
        	OperatorN --;	
        } 
        	
        return OperatorL;
	}
	
	public strOperation character(Generation g)
	{
		boolean ifM_D = g.ifM_D;
		int CharacterN = g.CharacterN;
		strOperation OperatorL = g.OperatorL;
		
		strOperation CharaL = new strOperation();
		boolean ifLegal = false;//С��
				
		while(!ifLegal)
		{
			ifLegal = true;
			if(ifM_D)
			{
				//����c	
	        	int temp = CharacterN;
		        int add=0,subtract=0, multiply=0, divide=0;
		        
				while(!(CharacterN == 0))
				{	
	        		int CharaType = 0;
	        		CharaType = (int)(Math.random() * 4);
	        		
	        		switch (CharaType) 
	        		{
					case 0:{
						CharaL.insertFirstc("+");
						CharacterN--;
						add++;
					}
						break;
					case 1:{
						CharaL.insertFirstc("-");
						CharacterN--;
						subtract++;
					}
						break;
					case 2:{
						CharaL.insertFirstc("*");
						CharacterN--;
						multiply++;
					}
						break;
					case 3:{
						CharaL.insertFirstc("��");
						CharacterN--;
						divide++;
					}
						break;
					default:
						break;
					}
	        	}
	        	if(temp > 1 && (add==temp||subtract==temp||multiply==temp||divide==temp))//��������ڵ���2
	        	{
	        		ifLegal = false;
	        	}					
				
				//judge

	        	int result = 0;
	        	strOperation.Node p = OperatorL.first;
	        	strOperation.Node q = CharaL.first;
	        	int cur1 = 0;
	        	String chara = "";
	        	
            	result = p.data;
            	cur1 = p.next.data;
            	chara = q.character;
            	
            	while(!(q == null))
            	{
        			cur1 = p.next.data;
        			chara = q.character;
            		if(chara == "+" )
            		{
            			result = result + cur1;
            			p = p.next;
            			q = q.next;      			
            		}
            		else if (chara == "-") 
            		{
            			result = result - cur1;
            			p = p.next;
            			q = q.next;
    				}
            		else if (chara == "*") 
            		{
            			result = result * cur1;
            			p = p.next;
            			q = q.next;
    				}
            		else if (chara  == "��") 
            		{
            			if(cur1 == 0) {//!0
            				ifLegal = false;
            				break;
            			}
            			int cur3 = result;
            			result = result / cur1;
            			if(cur3 > result * cur1)//С��
            			{
            				ifLegal = false;
            			    g.ifLegal = false;
            			    return CharaL;
            			}
            			p = p.next;
            			q = q.next;
    				}
            	}    	   	
			}	
			else//+-
			{
				//����
	        	int temp = CharacterN;
		        int add=0,subtract=0;
		        
		        while(!(CharacterN == 0))
				{	
	        		int CharaType = 0;
	        		CharaType = (int)(Math.random() * 2);
	        		
	        		switch (CharaType) 
	        		{
					case 0:{
						CharaL.insertFirstc("+");
						CharacterN--;
						add++;
					}
						break;
					case 1:{
						CharaL.insertFirstc("-");
						CharacterN--;
						subtract++;
					}
						break;
						
					default:
						break;
					}
	        	}
	        	if(temp > 1 && (add==temp||subtract==temp))//��������ڵ���2
	        	{
	        		ifLegal = false;
	        	}							        
			}
		}
		return CharaL;	
	}
	
	public String bracket(Generation g)
	{
		strOperation OperatorL = g.OperatorL;
		strOperation CharaL = g.CharaL;
		boolean ifB = g.ifB;
		boolean ifLegal = false;//������
		
		
    	strOperation.Node p = OperatorL.first;
    	strOperation.Node q = CharaL.first;
    	String operation = p.data + "";
		
    	while(!ifLegal)
    	{
    		ifLegal = true;
        	int priority1 = 0, priority2 = 0;
        	
    		while(!(q == null))
    		{
			    p = p.next;
				String fchara = q.character;
				priority1 = priority2 = 0;
				
				if(!(q.next == null))
				{
					String lchara = q.next.character;

					if(fchara == "+"  || fchara == "-")
						priority1 = 0;
					else if(fchara == "*" || fchara == "��")
						priority1 = 1;
					   				 	
					if(lchara == "+" || lchara == "-")
						priority2 = 0;
					else if(lchara == "*" || lchara == "��")
						priority2 = 1; 						
				}
				 
				 	if(priority1 == 0 && priority2 == 1)
				 	{
				 		operation ="(" + operation + q.character 
				 				   + p.data  + ")"; 
				 		
				 		if(!ifB) {				 		
				 			ifLegal = false;
				 			g.ifLegal = false;
				 			return operation;
				 		}
				 	}
				 	else
				 	{
				 		operation = operation + q.character + p.data;
				 	}
				    q = q.next;
    		}
    	}	
		return operation;
	}


}
