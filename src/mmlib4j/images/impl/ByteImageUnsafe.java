package mmlib4j.images.impl;

import mmlib4j.images.Image2DUnsafe;
import mmlib4j.images.impl.AbstractGrayScale;
import mmlib4j.images.impl.ByteImage;
import ndarrays4j.arrays.integer.NdByteArray;

public class ByteImageUnsafe extends AbstractGrayScale implements Image2DUnsafe{
	
	private NdByteArray pixels;
	
	public ByteImageUnsafe(NdByteArray pixels, int width, int height) {
		this.pixels = pixels;
		this.width = width;
		this.height = height;
		setPixelIndexer( PixelIndexer.getExceptionIndexer(getWidth(), getHeight()) );
	}
		
	public ByteImageUnsafe(int width, int height) {
		this(new NdByteArray(new int[] {width, height}), width, height);
	}
	
	public ByteImageUnsafe(long address, int width, int height) {
		this(new NdByteArray(address, new int[] {width, height}), width, height);
	}
	
	public ByteImageUnsafe(long address, int width, int height, int order) {
		this(new NdByteArray(address, new int[] {width, height}, order), width, height);
	}
	
	@Override
	public String getType() {	
		return "ByteImageUnsafe";
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
	public int getPixel(final int i) {		
		return ByteImage.toInt(pixels.get(i));		
	}

	@Override
	public int getDepth() {
		return 8;
	}

	@Override
	public int getPixel(int x, int y) {
		return ByteImage.toInt(pixels.get(x, y));
	}

	@Override
	public void setPixel(int x, int y, int value) {
		pixels.set(ByteImage.toByte(value), x, y);
	}

	@Override
	public void setPixel(int i, int value) {
		pixels.set(ByteImage.toByte(value), i);
	}

	@Override
	public ByteImageUnsafe duplicate() {
		NdByteArray pixels = this.pixels.duplicate();
		return new ByteImageUnsafe(pixels, getWidth(), getHeight());
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
        
        this.pixels.setAddress(pixels.getPosition(y * oldWidth + x));   
        this.pixels.setSize(width * height);*/
	}
	
	@Override
	// this method doesn't work yet
	public void setPixels(int width, int height, Object pixels) {
		this.width = width;
		this.height = height;
		this.pixels = (NdByteArray) pixels;
	}

	@Override
	// this method doesn't work yet
	public NdByteArray getPixels() {
		return pixels;
	}

}
