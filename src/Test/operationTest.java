package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Lib.Generation;

public class operationTest {

	@Test
	public void test() {
		Generation g = new Generation();
		g.OperationNum= 2;
		g.CRange = 4;
		g.operation(g);
	}

}
