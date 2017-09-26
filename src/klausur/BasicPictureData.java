package klausur;

public abstract class BasicPictureData {
	protected int width;
	protected int height;
	
	public BasicPictureData(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public double getPitxelCount () {
		return width * height;
	}
	
	public String sizeToString () {
		return width + " X " + height;
	}
	
	protected abstract String getPictureType();
	public String toString () {
		return getPictureType () + ": " + sizeToString ();
	}
		
}
