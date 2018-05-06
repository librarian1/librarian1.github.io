package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Lib.Generation;

public class GenerationTest {


	@Test
	public void testMain() {
		Generation generation = new Generation();
		String[] commandTest1 = {"-n","2","-m","1","50","-o","5","-c", "-b"};//所有命令行功能
		String[] commandTest2 = {"-n","2","-m","1","50","-c", "-b"};//默认一个运算符
		String[] commandTest3 = {"-n","2","-m","1","50","-o","5","-b"};//默认无乘除
		String[] commandTest4 = {"-n","2","-m","1","50","-o","5"};//默认无括号
		String[] commandTest5 = {"-n","2","-m","1","50","-o","2","-c","-b"};//运算符大于等于2
		
	    generation.main(commandTest1);
		generation.main(commandTest2);
		generation.main(commandTest3);
		
		
		
		

	}



}
