package exam;

import java.util.Objects;

public class Gray {
	
	private int intValue;
	private float floatValue;
	private boolean	isInt;
	 
	public Gray(int colour) {
		
		if(colour<0||colour>255) throw new IllegalArgumentException();

		
		this.intValue= colour;
		this.floatValue= colour/255;
		isInt=true;
	}
	
	private Gray(float colour) {
		
		if(colour<0||colour>1)throw new IllegalArgumentException();
		
		this.floatValue=colour;
		this.intValue=(int)(255*colour);
		isInt=false;
	}
	
	public static Gray setFloatVal(float colour) {
		return new Gray(colour);
	}
	
	public float returnfloat() {
		return floatValue;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other==null) {
			return false;
		}
		if(this==other) {
			return true;
		}
		
		if (!(this instanceof Gray)) {
		      return false;
		}
		
		Gray otherGray=(Gray) other;
		double tol=1e-6;
		
		if(this.intValue==otherGray.intValue && Math.abs(this.floatValue-otherGray.floatValue)<tol && this.isInt==otherGray.isInt) {
			return true;
		}
		
		return false;
	

	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.intValue,this.floatValue,this.isInt);
	}
	
	@Override
	public String toString() {
		if (isInt) {
			return String.format("Integer Gray: %d",this.intValue);
		}
		else return String.format("Float Gray: %f",this.floatValue);
	}
	
	
	
}
