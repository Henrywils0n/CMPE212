
public class Midterm {

	public static String longest(String s,String t) {

		if(s.length()>t.length()) return s;
		else if(s.length()<t.length())return t;
		else {
			if (s.compareTo(t)<=0)return s;
			else return t;
		}
			
	}

}
