package org.heju.HeadDetectionDatasetBuilder;

public interface Rect<T extends Number> {
	
	T x();
	T y();
	T width();
	T height();
	T xPlusWidth();
	T yPlusHeight();

}
