package mmlib4j.images.impl;

import mmlib4j.images.Image2DUnsafe;
import mmlib4j.images.impl.AbstractGrayScale;
import mmlib4j.images.impl.ShortImage;
import ndarrays4j.arrays.integer.NdShortArray;

public class ShortImageUnsafe extends AbstractGrayScale implements Image2DUnsafe {
		
	public NdShortArray pixels;
	
	public ShortImageUnsafe(NdShortArray pixels, int width, int height) {
		this.pixels = pixels;
		this.width = width;
		this.height = height;
		setPixelIndexer( PixelIndexer.getExceptionIndexer(getWidth(), getHeight()) );
	}
	
	public ShortImageUnsafe(int width, int height) {
		this(new NdShortArray(new int [] {width, height}), width, height);
	}
	
	public ShortImageUnsafe(long address, int width, int height) {
		this(new NdShortArray(address, new int[] {width, height}), width, height);
	}
	
	public ShortImageUnsafe(long address, int width, int height, int order) {
		this(new NdShortArray(address, new int[] {width, height}, order), width, height);
	}
	
	@Override
	public String getType() {	
		return "ShortImageUnsafe";
	}	
	
	@Override
	public int [] getShape() {
		return pixels.shape();
	}
	
	@Override
	public long getAddress() {
		return pixels.address();
	}

	@Override
	public int getDepth() {
		return 16;
	}

	@Override
	public int getPixel(int i) {
		return ShortImage.toInt(pixels.get(i));
	}

	@Override
	public int getPixel(int x, int y) {
		return ShortImage.toInt(pixels.get(x, y));
	}

	@Override
	public void setPixel(int i, int value) {			
		pixels.set(ShortImage.toShort(value), i);		
	}

	@Override
	public void setPixel(int x, int y, int value) {
		//setPixel(y * width + x, value);
		pixels.set(ShortImage.toShort(value), x, y);
	}
	
	@Override
	public ShortImageUnsafe duplicate() {		
		NdShortArray pixels = this.pixels.duplicate();
		return new ShortImageUnsafe(pixels, getWidth(), getHeight());
	}
	
	public void destroy() {
		this.pixels.finalize();
	}	
	
	@Override
	public int getOrder() {
		return pixels.order();
	}

	@Override
	public void resizeCenter(int width, int height) {				
		throw new UnsupportedOperationException("This method doesn't work yet!");
		/*int oldWidth = this.width;
    	int oldHeight = this.height;
    	this.width = width;
        this.height = height;
        
        int x = Math.abs(oldWidth - width)/2;
        int y = Math.abs(oldHeight - height)/2;        
       
        int i = pixels.offset(x, y);        
		this.pixels.address(pixels.vector().getPosition(i));
		this.pixels.shape(new int[]{width, height});*/
	}	

	@Override
	public void setPixels(int width, int height, Object pixels) {
		this.width = width;
		this.height = height;
		this.pixels = (NdShortArray) pixels;
	}
	
	@Override
	public NdShortArray getPixels() {
		return pixels;
	}

}
