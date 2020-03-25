package mmlib4j.images.impl;

import mmlib4j.images.Image2DUnsafe;
import mmlib4j.images.RealImage;
import ndarrays4j.arrays.integer.NdIntArray;
import ndarrays4j.arrays.integer.NdShortArray;
import ndarrays4j.arrays.real.NdFloatArray;


/**
 * MMLib4J - Mathematical Morphology Library for Java 
 * @author Wonder Alexandre Luz Alves
 *
 * @description
 * Classe que representa uma imagem float   
 * 
 */ 
public class FloatImageUnsafe extends AbstractImage2D implements RealImage, Image2DUnsafe {
 
    private NdFloatArray pixels; 

    public FloatImageUnsafe(NdFloatArray pixels, int width, int height) {
		this.pixels = pixels;
		this.width = width;
		this.height = height;
		setPixelIndexer( PixelIndexer.getExceptionIndexer(getWidth(), getHeight()) );
	}

    public FloatImageUnsafe(int width, int height) {
        this(new NdFloatArray(new int [] {width, height}), width, height);
    }
    
	public FloatImageUnsafe(long address, int width, int height) {
		this(new NdFloatArray(address, new int[] {width, height}), width, height);
	}
	
	public FloatImageUnsafe(long address, int width, int height, int order) {
		this(new NdFloatArray(address, new int[] {width, height}, order), width, height);
	}
	
    
    /**
     * Inicializar todos os pixel da imagem para um dado nivel de cinza
     * @param color
     */
    public void initImage(float color){
        for (int i = 0; i < getWidth(); i++){
            for (int j = 0; j < getHeight(); j++){
                setPixel(i,j, color);
            }
        }
    }
    
    public float getValue(int x, int y) {
		return getPixel(getPixelIndexer().getIndex(x, y));
	}
	
	public float getValue(int p) {
		return getPixel(getPixelIndexer().getIndex(p));
	}

    /**
     * Cria uma copia da imagem original
     * @return FloatImage - nova imagem
     */
    public FloatImageUnsafe duplicate(){
    	NdFloatArray pixels = this.pixels.duplicate();
		return new FloatImageUnsafe(pixels, getWidth(), getHeight());
    }

    /**
     * modifica todos os niveis de cinza de uma dada cor para uma outra cor
     * @param colorOld
     * @param colorNew
     */
    public void replaceValue(float colorOld, float colorNew){
    	for(int i=0; i < this.getSize(); i++){
    		if(getPixel(i) == colorOld)
    			setPixel(i, colorNew);
    	}
    }
    
    
    /**
     * Pega o valor do pixel (x, y)
     * @param x - largura
     * @param y - altura
     * @return float - valor do pixel
     */
    public float getPixel(int x, int y){
    	return pixels.get(x, y);
    }
    
    
    /**
     * Modifica o valor do pixel (x, y) = value
     * @param x - largura
     * @param y - altura
     * @param value - valor do pixel
     */
    public void setPixel(int x, int y, float value){
    	pixels.set(value, x, y);
    }
    
    /**
     * Pega uma matriz bidimensional de pixel da imagem
     * @return NdFloatArray
     */
    public NdFloatArray getPixels(){
        return pixels;
    }

    
    
    /**
     * Modifica a matriz de pixel da imagem para os valores da matriz dada
     * @param matrix 
     */
    public void setPixels(int width, int height, Object pixels){
        this.width = width;
        this.height = height;
        this.pixels = (NdFloatArray) pixels;
        setPixelIndexer( PixelIndexer.getExceptionIndexer(getWidth(), getHeight()) );
    }
    

    /**
     * Pega o maior pixel da imagem
     */
    public float getPixelValueMax() {
        float max = Float.MIN_VALUE;
        for (int i = 0; i < getWidth(); i++){
            for (int j = 0; j < getHeight(); j++){
                if(getPixel(i, j) > max)
                    max = getPixel(i, j);
            }
        }
        return max;
    }
    
    /**
     * Pega o menor pixel da imagem
     */
    public float getPixelValueMin() {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < getWidth(); i++){
            for (int j = 0; j < getHeight(); j++){
                if(getPixel(i, j) < min)
                    min = getPixel(i, j);
            }
        }
        return min;
    }

    /**
     * Verifica se duas imagens sao iguais
     * @param img - IGrayScaleImage
     * @return true se forem iguais false caso contrario
     */
    public boolean equals(Object o){
        FloatImageUnsafe img = (FloatImageUnsafe) o;
        for(int x = 0 ; x < getWidth() ; x++)
            for(int y = 0 ; y < getHeight(); y++)
                if(getPixel(x, y) != img.getPixel(x, y)) 
                    return false;
                
        return true;
    }

   
    public void setPixel(int i, float level){
    	pixels.set(level, i);
    }
    
    public float getPixel(int i){
        return pixels.get(i);
    }
    
    public int getDepth(){
    	return 32;
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
	public String getType() {	
		return "FloatImageUnsafe";
	}	


	@Override
	public int getOrder() {
		return pixels.order();
	}

	

}
