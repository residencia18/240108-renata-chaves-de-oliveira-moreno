package com.example.atividades.atividade05;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import okhttp3.OkHttpClient;

public class HttpClientIntegrationTest {

	@Test
	public void testGetDataFromApi() throws IOException {
		// Arrange
		String url = "https://jsonplaceholder.typicode.com/todos/1";
		OkHttpClient okHttpClient = new OkHttpClient();
		HttpClientWrapper httpClientWrapper = new HttpClientWrapper(okHttpClient);
		HttpClient httpClient = new HttpClient(httpClientWrapper);
		
		// Act
		String response = httpClient.getDataFromApi(url);

		// Assert
        assertNotNull(response);
	}
}
