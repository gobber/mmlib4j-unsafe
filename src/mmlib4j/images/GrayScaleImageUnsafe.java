package mmlib4j.images;

public interface GrayScaleImageUnsafe extends GrayScaleImage {
	
	public long getAddress();
	
	public int [] getShape();
	
	public String getType();
	
	public int getOrder();

}
