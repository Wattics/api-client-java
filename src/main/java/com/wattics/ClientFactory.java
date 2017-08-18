package com.wattics;

import com.wattics.internal.Client;

public class ClientFactory {
    private static ClientFactory SINGLETON_INSTANCE;

    public static void setInstance(ClientFactory clientFactory) {
        SINGLETON_INSTANCE = clientFactory;
    }

    public static ClientFactory getInstance() {
        if (SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new ClientFactory();
        }
        return SINGLETON_INSTANCE;
    }

    public Client createClient() {
        return new Client();
    }
}
