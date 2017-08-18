package com.wattics.internal;

import com.wattics.Config;
import com.wattics.Measurement;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

import static org.apache.http.auth.AuthScope.ANY;

public class Client {
    public CloseableHttpResponse send(Measurement measurement, Config config) throws IOException {
        String uri = config.getUri();
        CloseableHttpClient httpClient = buildClient(config);

        HttpPost httpPost = new HttpPost(uri);

        String json = JsonUtils.serialize(measurement);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = httpClient.execute(httpPost);
        response.close();

        return response;
    }

    private CloseableHttpClient buildClient(Config config) {
        String username = config.getUsername();
        String password = config.getPassword();

        BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        credentialsProvider.setCredentials(ANY, credentials);

        return HttpClients
                .custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
    }
}
