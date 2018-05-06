package Lib;

import InputException.OperationNumException;

public class Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	interface Number<Generation>
	{
		String operation(Generation g)
			throws OperationNumException; 
	}
	
	interface Operator<Generation>
	{
		strOperation operator(Generation g); 
	}

	interface Character<Generation>
	{
		strOperation character(Generation g); 


	}
	
	interface Bracket<Generation>
	{
		String bracket(Generation g); 
		
	}
	
	interface doResult//������validate��
	{

	}
}

