package a2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestWordleUtils {

	@Test
	public void test01a_replace() {
		// method args
		String s = "A";
		int index = 0;
		char c = 'B';
		
		// expected answer
		String exp = "B";
		
		// run test
		assertEquals(exp, WordleUtils.replace(s, index, c));
	}

	@Test
	public void test01b_replace() {
		// method args
		String s = "GUMBO";
		int index = 0;
		char c = 'J';
		
		// expected answer
		String exp = "JUMBO";
		
		// run test
		assertEquals(exp, WordleUtils.replace(s, index, c));
	}
	
	@Test
	public void test01c_replace() {
		// method args
		String s = "JIMBO";
		int index = 1;
		char c = 'U';
		
		// expected answer
		String exp = "JUMBO";
		
		// run test
		assertEquals(exp, WordleUtils.replace(s, index, c));
	}
	
	@Test
	public void test01d_replace_throws() {
		String s = "JIMBO";
		int index = -1;
		char c = 'U';
		
		try {
			WordleUtils.replace(s, index, c);
			fail("IndexOutOfBoundsException expected for index "+index);
		}
		catch(IndexOutOfBoundsException x) {
			//okay good
		}
		
	}
	
	@Test
	public void test02a_iSGreen(){	
		
		String guess="HELLO";
		String answer="BONJOUR";
		
		
		
		try {
			WordleUtils.isGreen(guess,answer);
			fail("IllegalArgumentException Expected");
		}
		catch(IllegalArgumentException x) {
			//okay good
		}
		
	}
	
	@Test
	public void test03a_isYellow(){
		
		String guess="KAYAK";
		String answer="WHACK";
		
		ArrayList<Boolean> exp=new ArrayList<>();
		exp.add(false);
		exp.add(true);
		exp.add(false);
		exp.add(false);
		exp.add(false);
		
		assertEquals(exp, WordleUtils.isYellow(guess, answer));
		
		
	}
	
	@Test
	public void test04a_getColors(){
	
		String guess="HEXLO";
		String answer="HELLO";
		
		ArrayList<WordleColor> exp=new ArrayList<>();
		exp.add(WordleColor.GREEN);
		exp.add(WordleColor.GREEN);
		exp.add(WordleColor.GRAY);
		exp.add(WordleColor.GREEN);
		exp.add(WordleColor.GREEN);
		
		assertEquals(exp,WordleUtils.getColors(guess, answer));
		
		
	}
}
