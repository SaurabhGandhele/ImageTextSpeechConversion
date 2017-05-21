package bluemix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertFile {

	public static void main(String[] args) throws IOException {
		String csvFile = "1234.csv";
    	
		 BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        int i=0;
	        String[] Headers = new String[16];
	        
			
	        String content = "";
	        int cnt=0;
	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] yelp = line.split(cvsSplitBy);
	                	System.out.println(yelp.length);
	                	for(int k=0;k<yelp.length;k++)
	                		
	                	{
	                		if(yelp[k].equals("") || yelp[k].equals(" "))
	                		{
	                			yelp[k]="Information Not Available";
	                		}
	                	}
	               //System.out.println("Country [code= " + yelp[4] + " , name=" + yelp[5] + "]");
	               if(i==0)
	               {
	            	 Headers = yelp.clone(); 
	            	 i++;
	               }
	               else
	               {
	               String temp="Name"+"\n"+yelp[6]+"\n \n"+"Timings"+"\n"+yelp[0]+"\n \n"
	             +"Is Open"+"\n"+yelp[1]+"\n \n"+"Address"+"\n"+yelp[2]+"\n \n"+"Categories" + "\n"+
	             yelp[3]+"\n \n"+"City"+"\n"+yelp[4]+"\n \n"+"Review COunt"+"\n"+yelp[5] + "\n \n"
	            		 +"Longitude Lattitude"+"\n"+yelp[7] +" "+yelp[10] + "\n \n" + "State" + "\n" + yelp[8]+
	            		 "\n \n"+"Stars"+"\n"+yelp[9];
	               //System.out.println(content);
	               }
	               cnt++;
	               /*if(cnt > 1 && cnt < 35)
	               {
	            	   content+= "What is "+yelp[6]+" address? \n";
	               }
	               //if(cnt > 20 && cnt < 50)
	               {
	            	   content+= "What are "+yelp[6]+" categories? \n";
	               }
	               //if(cnt > 40 && cnt < 75)
	               {
	            	   content+= "How many stars does "+yelp[6]+" have? \n";
	               }*/
	               if(cnt > 500 && cnt < 511)
	               {
	            	   content+= "Does "+yelp[6]+" have Wifi? \n";
	               }
	               if(cnt > 600 && cnt < 611)
	               {
	            	   content+= "Is Alcohol available at "+yelp[6]+"? \n";
	               }
	               if(cnt > 700 && cnt < 711)
	               {
	            	   content+= "Does "+yelp[6]+" provide Home Delivery? \n";
	               }
	               if(cnt > 800 && cnt < 811)
	               {
	            	   content+= "What is the Parking provided by "+yelp[6]+"? \n";
	               }
	               if(cnt > 900 && cnt < 911)
	               {
	            	   content+= "Which kind of Ambience does "+yelp[6]+" have? \n";
	               }
	            }
	        }
	               finally {
	                   if (br != null) {
	                       try {
	                           br.close();
	                       } catch (IOException e) {
	                           e.printStackTrace();
	                       }
	                   }
		
		
		
		BufferedWriter bw = null;
		try {
			// Specify the file name and path here
			File file = new File("SampQuests2.txt");

			/*
			 * This logic will make sure that the file gets created if it is not
			 * present at the specified location
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("File written Successfully!!!!!!");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	            }
	        }
	}
