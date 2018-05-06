import java.util.Scanner;

import com.sun.org.apache.xpath.internal.Arg;
import Lib.Generation;


public class Command {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Generation g = new Generation();

		
       try {
        	//������       	
        	g.main(args);
          } catch (Exception e) {
              System.out.println("请输入command");
          }
        
	}

}
