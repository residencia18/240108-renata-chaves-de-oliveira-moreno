package com.example.atividades.atividade05;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClientWrapper implements IHttpClient {
	private OkHttpClient _client;
	
	public HttpClientWrapper(OkHttpClient okHttpClient) {
		_client = okHttpClient;
	}

	@Override
	public String getDataFromApi(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
        try (Response response = _client.newCall(request).execute()) {
            return response.body().string();
        }
	}
}
