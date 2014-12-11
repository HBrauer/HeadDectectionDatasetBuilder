package org.heju.HeadDetectionDatasetBuilder;

public class DoubleObservation  implements Observation<Double>{

	
	
	private int personId;
	private int frameId;
	private boolean validHead;
	private boolean validBody;
	private Rect<Double> head;
	private Rect<Double> body;
	
	
	@Override
	public Rect<Double> head() {
		return head;
	}

	public DoubleObservation( int personId, int frameId,
			boolean validHead, boolean validBody, Rect<Double> head,
			Rect<Double> body) {
		super();
		
		this.personId = personId;
		this.frameId = frameId;
		this.validHead = validHead;
		this.validBody = validBody;
		this.head = head;
		this.body = body;
	}

	@Override
	public Rect<Double> body() {
		return body;
	}


	@Override
	public int personId() {
		return personId;
	}

	@Override
	public int frameId() {
		return frameId;
	}

	@Override
	public boolean validBody() {
		return validBody;
	}

	@Override
	public boolean validHead() {
		return validHead;
	}

}
