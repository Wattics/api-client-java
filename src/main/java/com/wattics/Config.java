package com.wattics;

public class Config {
    public enum Environment {
        PRODUCTION("https://web-collector.wattics.com/measurements/v2/"),
        DEVELOPMENT("https://dev-web-collector.wattics.com/measurements/v2/"),
        LOCAL("http://localhost:8080/measurements/v2/");

        private String uri;
        private String utcUri;

        Environment(String uri) {
            this.uri = uri + "unifiedjson/";
            this.utcUri = uri + "unifiedjson_utc/"; // coverts to local time
        }

        public String getUri() {
            return uri;
        }

        public String getUtcUri() {
            return utcUri;
        }
    }
    

    public static final Config DUMMY_CONFIG = new Config(null, null, null);

    private final Environment environment;
    private final String username;
    private final String password;
    private String uriAction = "root";

    public Config(Environment environment, String username, String password) {
        this.environment = environment;
        this.username = username;
        this.password = password;
    }

    public String setUriAction(String uriAction) {
        this.uriAction = uriAction;
        return uriAction;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUri() {
        if (uriAction.equals("utc2local")) {
            return environment.getUtcUri();
        } else {
            return environment.getUri();
        }
    }

    public String getUriAction() {
        return uriAction;
    }
}
