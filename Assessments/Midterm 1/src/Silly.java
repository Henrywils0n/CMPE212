
import java.util.ArrayList;

public class Silly {

	public static void main(String[] args) {
		String[]x= {"hi","ho","ho","ho","ho","ho","ho","ho"};
		ArrayList<String> y=new ArrayList<>();
		
		for(int i=0;i<x.length;i++) {
			y.add(x[i]);
		}
		
		boolean boo=false;
		
		for (int i=1;i<y.size();i++) {
			if(y.get(0)==y.get(i)) {
				boo=true;
				break;		
			}
		}
		
		System.out.println(boo);

	}
}