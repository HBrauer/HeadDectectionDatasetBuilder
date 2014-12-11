package org.heju.HeadDetectionDatasetBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultTOPFile implements TOPFile {
	
	private static String SPLIT_TOKEN = ",";
	
	private Reader reader;
	
	
	
	

   private static int IDCOUNT = 0;


	public DefaultTOPFile(Reader reader) {
		super();
		this.reader = reader;
	}
	

	
	private void read(){
	
	}



	@Override
	public List<Observation<Double>> readObservations() {
		 try (BufferedReader bufferedReader = new BufferedReader(reader)) {
			 List<Observation<Double>> observations = bufferedReader.lines()
					 .filter(line -> line.trim().length() > 0)
					 .map(line -> lineToObservation(line) )
					 .collect(Collectors.toList());
			 return observations;
		 }  catch (IOException e) {
	            throw new UncheckedIOException(e);
	        }
		
	}
	
	private Observation<Double> lineToObservation(String line){
		String arg[] = line.split(SPLIT_TOKEN);
		int personNumber = Integer.valueOf(arg[0]);
		int frameNumber = Integer.valueOf(arg[1]);
		boolean headValid = arg[2].trim().equals("1");
		boolean bodyValid = arg[3].trim().equals("1");
		double headLeft = Double.valueOf(arg[4]);
		double headTop = Double.valueOf(arg[5]);
		double headRight = Double.valueOf(arg[6]);
		double headBottom = Double.valueOf(arg[7]);
		double bodyLeft = Double.valueOf(arg[8]);
		double bodyTop = Double.valueOf(arg[9]);
		double bodyRight = Double.valueOf(arg[10]);
		double bodyBottom = Double.valueOf(arg[11]);
		Observation<Double> obs = new DoubleObservation( personNumber, frameNumber, headValid, bodyValid, 
				new DoubleRect(headLeft, headTop, headRight-headLeft, headBottom-headTop), 
				new DoubleRect(bodyLeft, bodyTop, bodyRight-bodyLeft, bodyBottom-bodyTop));
		
		return obs;
		
		
		
	}
	
	

}
