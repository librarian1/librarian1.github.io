package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Lib.Generation;

public class GenerationTest {


	@Test
	public void testMain() {
		Generation generation = new Generation();
		String[] commandTest1 = {"-n","2","-m","1","50","-o","5","-c", "-b"};//���������й���
		String[] commandTest2 = {"-n","2","-m","1","50","-c", "-b"};//Ĭ��һ�������
		String[] commandTest3 = {"-n","2","-m","1","50","-o","5","-b"};//Ĭ���޳˳�
		String[] commandTest4 = {"-n","2","-m","1","50","-o","5"};//Ĭ��������
		String[] commandTest5 = {"-n","2","-m","1","50","-o","2","-c","-b"};//��������ڵ���2
		
	    generation.main(commandTest1);
		generation.main(commandTest2);
		generation.main(commandTest3);
		
		
		
		

	}



}
