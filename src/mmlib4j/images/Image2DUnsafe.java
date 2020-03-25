package mmlib4j.images;

public interface Image2DUnsafe extends Image2D {
	
	public long getAddress();
	
	public int [] getShape();
	
	public String getType();
	
	public int getOrder();
	 
}
