package mmlib4j.images.impl;

import mmlib4j.images.GrayScaleImageUnsafe;

public class ImageFactoryUnsafe {
	
	public static final int UNSAFE_8BITS = 8;
	public static final int UNSAFE_16BITS = 16;

	public static GrayScaleImageUnsafe createGrayScaleImageUnsafe(int depth, int width, int height) {
		if(depth == UNSAFE_8BITS) {
			return new ByteImageUnsafe(width, height);
		} else if(depth == UNSAFE_16BITS) {
			return null;
			//return new ShortImageUnsafe(width, height);
		} else {
			return null;
		}		
	}
	
	public static GrayScaleImageUnsafe createReferenceGrayScaleImageUnsafe(int depth, long address, int width, int height) {		
		if(depth == UNSAFE_8BITS) {
			return new ByteImageUnsafe(address, width, height);
		} else if(depth == UNSAFE_16BITS) {
			return null;
			//return new ShortImageUnsafe(address, width, height);
		} else {
			return null;
		}		
		
	}
	
}
