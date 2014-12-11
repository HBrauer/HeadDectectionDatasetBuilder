package org.heju.HeadDetectionDatasetBuilder;

public class DefaultObservation<T extends Number> implements Observation<T> {
	
	private int personId;
	private int frameId;
	private boolean validHead;
	private boolean validBody;
	private Rect<T> head;
	private Rect<T> body;
	
	
	

	public DefaultObservation( int personId, int frameId,
			boolean validHead, boolean validBody, Rect<T> head, Rect<T> body) {
		super();
		
		this.personId = personId;
		this.frameId = frameId;
		this.validHead = validHead;
		this.validBody = validBody;
		this.head = head;
		this.body = body;
	}

	@Override
	public Rect<T> head() {
		return head;
	}

	@Override
	public Rect<T> body() {
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
