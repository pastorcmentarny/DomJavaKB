/*
 * Created on Nov 29, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dms.pastor.examples.sorting;
import java.io.*;
import java.util.*;

/**
 * @author rcs
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MakeDataFile {


	public static void main(String[] args) {

		BufferedWriter writer=null;
		Vector storedNums=new Vector();
		try {
			writer = new BufferedWriter(new FileWriter(args[0]));
		} catch (IOException ex) {
		}

		int numbers=Integer.parseInt(args[1]);
		int number=0;
		
		for (int i = 0; i<numbers; i++)
		{
			number=(int)(1000000+(Math.random()*8999999));
			try {
				writer.write(number+"\n");
			} catch (IOException e)
			{}
		}

		try {
			writer.close();
		} catch (IOException ex) {
		}
	}
}
