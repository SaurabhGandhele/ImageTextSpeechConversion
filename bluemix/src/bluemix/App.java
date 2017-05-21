package bluemix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws XmlException
    {
        System.out.println( "Hello World!" );
        Scanner Input = new Scanner(System.in);
        String quest = Input.nextLine();
        String[] match = quest.split("\\s+");
        String res="";
        for(int i=0;i<match.length;i++)
        {
        	if(match[i].equals("Restaurant") || match[i].equals("Location") || match[i].equals("Rating"))
        	{
        		res+=match[i];
        	}
        }
        NaturalLanguageClassifier service = new NaturalLanguageClassifier();
        service.setUsernameAndPassword("1d3ec18e-a3ee-47e7-b98f-4c031728f55b","45VTLKuyXZJb");
        
        service.deleteClassifier("90e7acx197-nlc-46458").execute();
        Classifier classifier = service.createClassifier("nlcyelp", "en",
        	  new File("RestaurantLocation.csv")).execute();
         System.out.println(classifier);	
        
    Classifiers classifiers = service.getClassifiers().execute();
        
       System.out.println(classifiers);
        
        // 90e7acx197-nlc-46458
        
    
    	
    	
    	String csvFile = "yelp_academic_dataset_business.csv";
    	BufferedWriter bw = null;
        
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
               if(i==0)
               {
            	 Headers = yelp.clone(); 
            	 i++;
               }
               else
               {
               content="Name"+"\n"+yelp[6]+"\n \n"+"Timings"+"\n"+yelp[0]+"\n \n"
             +"Is Open"+"\n"+yelp[1]+"\n \n"+"Address"+"\n"+yelp[2]+"\n \n"+"Categories" + "\n"+
             yelp[3]+"\n \n"+"City"+"\n"+yelp[4]+"\n \n"+"Review COunt"+"\n"+yelp[5] + "\n \n"
            		 +"Longitude Lattitude"+"\n"+yelp[7] +" "+yelp[10] + "\n \n" + "State" + "\n" + yelp[8]+
            		 "\n \n"+"Stars"+"\n"+yelp[9];
               //System.out.println(content);
               }
               cnt++;
               try {

               File file = new File("Data"+Integer.toString(cnt)+".txt");
               FileWriter fw = new FileWriter(file);
         	  bw = new BufferedWriter(fw);
         	  bw.write(content);
                 
                  XWPFDocument document = new XWPFDocument(new FileInputStream("Data2.docx"));
                   XWPFDocument doc = new XWPFDocument();
                   XWPFStyles neStyles = doc.createStyles();
              		neStyles.setStyles(document.getStyle());
              		
                   XWPFParagraph tmpParagraph = doc.createParagraph();
                  
                   
           		
           	 tmpParagraph.setStyle("Heading1");
           		
           	 XWPFRun tmpRun = tmpParagraph.createRun();
           	 
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(28);
           		tmpRun.setText(yelp[6]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           	 XWPFParagraph tmpParagraph1 = doc.createParagraph();
             	
           		XWPFRun tmpRun1 = tmpParagraph1.createRun();
           		tmpRun1.setBold(true);
           		tmpRun1.setFontSize(16);
           		tmpRun1.setText("Timings:");
           		tmpRun1.addBreak();
           		
           		XWPFRun tmpRun2 = tmpParagraph.createRun();
           		tmpRun2.setBold(false);
           		tmpRun2.setFontSize(10);
           		tmpRun2.setText(yelp[0]);
           		tmpRun2.addBreak();
           		tmpRun2.addBreak();
           		
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(20);
           		tmpRun.setText("Is Open");
           		tmpRun.addBreak();

           		tmpRun.setBold(false);
           		tmpRun.setFontSize(14);
           		tmpRun.setText(yelp[1]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(20);
           		tmpRun.setText("Address");
           		tmpRun.addBreak();

           		tmpRun.setBold(false);
           		tmpRun.setFontSize(14);
           		tmpRun.setText(yelp[2]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(20);
           		tmpRun.setText("Categories");
           		tmpRun.addBreak();

           		tmpRun.setBold(false);
           		tmpRun.setFontSize(14);
           		tmpRun.setText(yelp[3]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(20);
           		tmpRun.setText("City");
           		tmpRun.addBreak();

           		tmpRun.setBold(false);
           		tmpRun.setFontSize(14);
           		tmpRun.setText(yelp[4]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(20);
           		tmpRun.setText("Review Count");
           		tmpRun.addBreak();

           		tmpRun.setBold(false);
           		tmpRun.setFontSize(14);
           		tmpRun.setText(yelp[5]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(20);
           		tmpRun.setText("Longitude and Latitude");
           		tmpRun.addBreak();

           		tmpRun.setBold(false);
           		tmpRun.setFontSize(14);
           		tmpRun.setText(yelp[7]+" "+yelp[10]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(20);
           		tmpRun.setText("State");
           		tmpRun.addBreak();

           		tmpRun.setBold(false);
           		tmpRun.setFontSize(14);
           		tmpRun.setText(yelp[8]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           		tmpRun.setBold(true);
           		tmpRun.setFontSize(20);
           		tmpRun.setText("Stars");
           		tmpRun.addBreak();

           		tmpRun.setBold(false);
           		tmpRun.setFontSize(14);
           		tmpRun.setText(yelp[9]);
           		tmpRun.addBreak();
           		tmpRun.addBreak();
           		
           
    
               }
            	  finally
            	  { 
            	   try{
            	      if(bw!=null)
            	  	 bw.close();
            	   }catch(Exception ex){
            	       System.out.println("Error in closing the BufferedWriter"+ex);
            	    }
            	  }
                  
            }

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try{
                if(bw!=null)
            	 bw.close();
             }catch(Exception ex){
                 System.out.println("Error in closing the BufferedWriter"+ex);
              }
        }
    	
    }
}
