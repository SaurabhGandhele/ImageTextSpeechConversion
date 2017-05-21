package watson.demo;

import java.io.File;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.RecognizedText;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

/**
 * A very basic example of the Watson Visual Recognition API for Java
 * 
 * Phillip Lopez - pgl5711@rit.edu
 */
public class ImageRecognitionDemo 
{
	
	private static String apiKey = "a0a8dc1ba55fe86bb45a214d71f0929d6a6eee44"; 
	
    public static void main( String[] args )
    {
    	// Create image classification service
    	VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
    	service.setApiKey(apiKey);
    	
    	System.out.println("Classify an image");
    	ClassifyImagesOptions options = new ClassifyImagesOptions.Builder()
    	    .images(new File(args[0]))
    	    .build();
    	VisualClassification result = service.classify(options).execute();
    	System.out.println("Here's what Watson detected in that image: " + result);
    	
    	// Text Recognition
    	VisualRecognitionOptions vrOptions = new VisualRecognitionOptions.Builder()
    			.images(new File("data/gol.jpg"))
    			.build();

    	RecognizedText text = service.recognizeText(vrOptions).execute();
    	System.out.println("Here's the text Watson found in that image: " + text);
    }
}
