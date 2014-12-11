package org.heju.HeadDetectionDatasetBuilder;

import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class DefaultTOPFileTest {
	
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void readEmptyFileAndReturnEmptyHeadList(){
		Reader reader = new StringReader("");
		DefaultTOPFile topFile = new DefaultTOPFile(reader);
		List<Observation<Double>> observations = topFile.readObservations();
		assertEquals(observations.size(), 0);
	} 
	
	@Test
	public void readLineAndReturnObservation(){
		final String line = "00000000,2,1,1,1383.096,49.387,1397.904,65.613,1364.265,49.387,1413.972,181.767";
		int personNumber = 0;
		int frameNumber = 2;
		boolean headValid = true;
		boolean bodyValid = true;
		double headLeft = 1383.096;
		double headTop = 49.387;
		double headRight = 1397.904;
		double headBottom = 65.613;
		double bodyLeft = 1364.265;
		double bodyTop = 49.387;
		double bodyRight = 1413.972;
		double bodyBottom = 181.767;
		
		Observation<Double> testobs = new DoubleObservation( personNumber, frameNumber, headValid, bodyValid, 
				new DoubleRect(headLeft, headTop, headRight-headLeft, headBottom-headTop), 
				new DoubleRect(bodyLeft, bodyTop, bodyRight-bodyLeft, bodyBottom-bodyTop));
		
		Reader reader = new StringReader(line);
		DefaultTOPFile topFile = new DefaultTOPFile(reader);
		List<Observation<Double>> observations = topFile.readObservations();
		Observation<Double> obs = observations.get(0);
		assertEquals(personNumber, obs.personId());
		assertEquals(frameNumber, obs.frameId());
		assertEquals(headValid, obs.validHead());
		assertEquals(bodyValid, obs.validBody());
		assertEquals(headLeft, obs.head().x());
		assertEquals(headTop, obs.head().y());
		assertEquals(headRight,obs.head().xPlusWidth());
		assertEquals(headBottom,obs.head().yPlusHeight());
		assertEquals(bodyLeft,obs.body().x());
		assertEquals(bodyTop,obs.body().y());
		assertEquals(bodyRight,obs.body().xPlusWidth());
		assertEquals(bodyBottom,obs.body().yPlusHeight());
	}

}
