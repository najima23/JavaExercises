package klausur;

public class PictureData extends BasicPictureData {

	protected int farbtiefe;
	
	public PictureData(int width, int height,int farbtiefe) {
		super(width, height);
		this.farbtiefe=farbtiefe;
	}
	public PictureData(PictureData other) {
		this(other.width,other.height,other.farbtiefe);
	}
	public PictureData(Dimension d, int farbtiefe) {
		this(d.width,d.height,farbtiefe);
	}
	
	protected String getPitctueTyp(){
		if(farbtiefe ==1){
			return "SW-Bild";
		}
		return "Farbbild";
	}

	public String toString () {
		if(farbtiefe>1){
			return super.toString() + ", " + farbtiefe + " bit";
		}
		return super.toString();
	}
	@Override
	protected String getPictureType() {
		// TODO Auto-generated method stub
		return null;
	}

	


}

