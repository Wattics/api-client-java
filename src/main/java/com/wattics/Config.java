package com.wattics;

public class Config {
    public enum Environment {
        PRODUCTION("https://web-collector.wattics.com/measurements/v2/unifiedjson/"),
        DEVELOPMENT("https://dev-web-collector.wattics.com/measurements/v2/unifiedjson/");

        private String uri;

        Environment(String uri) {
            this.uri = uri;
        }

        public String getUri() {
            return uri;
        }
    }

    public static final Config DUMMY_CONFIG = new Config(null, null, null);

    private final Environment environment;
    private final String username;
    private final String password;

    public Config(Environment environment, String username, String password) {
        this.environment = environment;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUri() {
        return environment.getUri();
    }
}
