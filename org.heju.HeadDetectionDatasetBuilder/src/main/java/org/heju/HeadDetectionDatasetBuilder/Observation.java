package org.heju.HeadDetectionDatasetBuilder;

public interface Observation<T extends Number> {
	
	Rect head();
	Rect body();
	int personId();
	int frameId();
	boolean validBody();
	boolean validHead();
	
	
	

}
