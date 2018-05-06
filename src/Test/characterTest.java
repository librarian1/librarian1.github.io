package Test;


import Lib.Generation;
import Lib.strOperation;
import org.junit.Test;
public class characterTest {

	@Test
	public void test() {
		Generation g = new Generation();
		g.CharacterN = 4;
		

		g.OperationNum = 2;
		g.OperatorN = g.CharacterN + 1;
		g.lower = 1;
		g.upper = 50;		
		g.OperatorL = g.operator(g);
		
		g.character(g);
		g.ifM_D = true;
		g.character(g);
			
	}

}
