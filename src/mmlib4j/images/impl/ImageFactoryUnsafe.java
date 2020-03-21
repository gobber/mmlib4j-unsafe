package mmlib4j.images.impl;

import mmlib4j.images.BinaryImage;
import mmlib4j.images.ColorImage;
import mmlib4j.images.GrayScaleImage;
import mmlib4j.images.RealImage;

public class ImageFactoryUnsafe extends AbstractImageFactory {

	
	public static void setInstance() {
		AbstractImageFactory.instance = new ImageFactoryUnsafe();
	}
	
	@Override
	public GrayScaleImage createGrayScaleImage(int depth, int width, int height) {
		if(depth == DEPTH_8BITS)
			return new ByteImageUnsafe(width, height);
		else if(depth == DEPTH_16BITS)
			return new ShortImageUnsafe(width, height);
		return  null;	
	}

	@Override
	public BinaryImage createBinaryImage(int width, int height) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public ColorImage createColorImage(int width, int height) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public RealImage createRealImage(int width, int height) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public ColorImage createCopyColorImage(GrayScaleImage img) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public ColorImage createCopyColorImage(BinaryImage img) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public ColorImage createCopyColorImage(ColorImage img) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public GrayScaleImage createCopyGrayScaleImage(GrayScaleImage img) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public BinaryImage createCopyBinaryImage(BinaryImage img) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public RealImage createCopyRealImage(RealImage img) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public ColorImage createReferenceColorImage(int[] pixels, int width, int height) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public RealImage createReferenceRealImage(float[] pixels, int width, int height) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public BinaryImage createReferenceBinaryImage(boolean[] pixels, int width, int height) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

	@Override
	public GrayScaleImage createReferenceGrayScaleImage(int depth, Object pixels, int width, int height) {
		throw new UnsupportedOperationException("This method doesn't work yet!");
	}

}
