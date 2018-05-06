package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Lib.Generation;

public class OperatorTest {



	@Test
	public void testOperator() {
		Generation g = new Generation();
		g.OperatorN = 4;
		g.lower = 1;
		g.upper = 50;
		g.operator(g);
		
		

	}

}
