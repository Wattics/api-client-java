package com.wattics;

import com.wattics.internal.Client;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

public class MockClient extends Client {
    @Override
    public CloseableHttpResponse send(Measurement measurement, Config config) throws IOException {
        return null;
    }
}
