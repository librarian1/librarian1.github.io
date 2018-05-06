package Test;


import Lib.Validate;
import org.junit.Test;
public class ValidateTest {

@Test
	public void testDoResult() {
		Validate vaildate = new Validate();

		assert(vaildate.doResult("6��3") == 2);
		assert(vaildate.doResult("((-1)+3)") == 2);
		assert(vaildate.doResult("(1+2)*3") == 9);
		
	}

}
