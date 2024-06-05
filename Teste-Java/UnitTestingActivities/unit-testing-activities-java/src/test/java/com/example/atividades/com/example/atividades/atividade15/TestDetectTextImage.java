package com.example.atividades.atividade15;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.mockito.Mockito.*;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException; // Importar IOException
import java.nio.file.Path;
import java.util.List;

public class TestDetectTextImage {

    @Test
    public void testDetectTextLabels() throws IOException {
        // Create a mock RekognitionClient
        RekognitionClient mockRekClient = mock(RekognitionClient.class);

        // Create an instance of DetectTextImage with the mock RekognitionClient
        DetectTextImage detectTextImage = new DetectTextImage("data/java.jpg", mockRekClient);

        // Simulate the behavior of the detectText method to resolve the ambiguity
        when(mockRekClient.detectText(any(DetectTextRequest.class)))
            .thenReturn(DetectTextResponse.builder().build());

        // Call the detectTextLabels method with a test image
        String resultFilePath = "data/test-result.txt";
        detectTextImage.detectTextLabels(resultFilePath);

        // Verify if the detectText method of RekognitionClient was called correctly
        verify(mockRekClient, times(1)).detectText(any(DetectTextRequest.class));
    }

    @Test
    public void testDefaultConstructor() {
        // Create an instance of the default constructor
        DetectTextImage detectTextImage = new DetectTextImage();

        // Verify if the fields were initialized correctly
        assertEquals("data/img-example-for-aws-task.jpg", detectTextImage.sourceImage);
        assertEquals(Region.US_WEST_2, detectTextImage.region);
        assertNotNull(detectTextImage.rekClient); // Verify if rekClient is not null
    }
    
    @Test
    public void testSaveResultToTextFile() throws IOException {
        // Create a list of text detections for testing
        List<TextDetection> textDetections = List.of(
            TextDetection.builder().detectedText("Text1").confidence(99.0f).id(1).parentId(0).type(TextTypes.WORD).build(),
            TextDetection.builder().detectedText("Text2").confidence(98.0f).id(2).parentId(1).type(TextTypes.LINE).build()
        );
        
        // Create an instance of DetectTextImage for testing
        DetectTextImage detectTextImage = new DetectTextImage();
        
        // Set up a temporary file for testing
        Path tempFilePath = Path.of("data/test-result.txt");
        
        // Call the saveResultToTextFile method with the list of text detections and the temporary file path
        detectTextImage.saveResultToTextFile(textDetections, tempFilePath.toString());
        
        // Verify if the result was saved correctly
        assertTrue(tempFilePath.toFile().exists()); // Check if the file exists
        
        // TODO: Add more assertions to verify the content of the saved file if needed
    }
}