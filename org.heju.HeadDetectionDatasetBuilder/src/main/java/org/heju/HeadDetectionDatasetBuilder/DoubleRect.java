package org.heju.HeadDetectionDatasetBuilder;



public class DoubleRect implements Rect<Double> {
	
	private final Double x;
	private final Double y;
	private final Double width;
	private final Double height;
	

	public DoubleRect(Double x, Double y, Double width, Double height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	

	public Double x() {
		return x;
	}

	public Double y() {
		return y;
	}

	public Double width() {
		return width;
	}

	public Double height() {
		return height;
	}
	
	@Override
	public Double xPlusWidth() {
		return x + width;
	}

	@Override
	public Double yPlusHeight() {
		return y + height;
	}




	@Override
	public String toString() {
		return "DefaultRect [x=" + x + ", y=" + y + ", width=" + width
				+ ", height=" + height + "]";
	}




	
}
