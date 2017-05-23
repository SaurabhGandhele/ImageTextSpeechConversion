package org.saurabh.bluemix.ImageTextClassification;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ImageText;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.RecognizedText;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

/**
 * Author: Saurabh Gandhele (smg6512@rit.edu)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
        service.setApiKey("7913c8173679431d2124eed99758918f3b464b12");

        System.out.println("Classify an image");
        ClassifyImagesOptions options = new ClassifyImagesOptions.Builder()
            .images(new File("sample.png"))
            .build();
        VisualClassification result = service.classify(options).execute();
        System.out.println(result);
        
        VisualRecognitionOptions vrOptions = new VisualRecognitionOptions.Builder()
		.images(new File("sample.png"))
		.build();

        RecognizedText text = service.recognizeText(vrOptions).execute();
        System.out.println("Here's the text Watson found in that image: " + text);
        List<ImageText> al = text.getImages();
        String text1=al.get(0).getText();
        
        TextToSpeech service123 = new TextToSpeech();
        service123.setUsernameAndPassword("44233f00-6ede-416d-b1df-a1211ddcfe05", "DxUDEiG7NCl5");

        try {
         // String text1 = "Hello World";
          InputStream stream = service123.synthesize(text1, Voice.EN_ALLISON,
            AudioFormat.WAV).execute();
          InputStream in = WaveUtils.reWriteWaveHeader(stream);
          OutputStream out = new FileOutputStream("sampletext.wav");
          byte[] buffer = new byte[1024];
          int length;
          while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
          }
          out.close();
          in.close();
          stream.close();
        }
        catch (Exception e) {
          e.printStackTrace();
        }
        
        
    }
}
