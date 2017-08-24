# Wattics api-client-java
Java library for the [Wattics](https://wattics.com) platform.

## Quick Start
This guide gets you started with the library with a simple working example.

#### Download & build
You’ll need a local copy of the example code to work through this quickstart. Download the code from our [Github repository](https://github.com/Wattics/api-client-java):

```sh
$ git clone https://github.com/Wattics/api-client-java
$ cd api-client-java
$ gradle install
```

At this point you will have the library available as a maven dependency, so you can embed this snippet in your pom.xml:
```xml
    <dependency>
      <groupId>com.wattics</groupId>
      <artifactId>api-client</artifactId>
      <version>0.2.0</version>
    </dependency>
```

#### Example code
Here's some basic code to get started with the library:

```java
import com.wattics.*;

import static com.wattics.Config.Environment.DEVELOPMENT;
import static java.time.LocalDateTime.now;

public class Main {
    public static void main(String[] args) {
        Agent agent = Agent.getInstance();
        agent.addMeasurementSentHandler((measurement, httpResponse) -> {
            System.out.println(measurement);
            System.out.println(httpResponse);
        });

        // Config config = new Config(PRODUCTION, "username", "password");
        Config config = new Config(DEVELOPMENT, "username", "password");

        SimpleMeasurement simpleMeasurement = new SimpleMeasurement();
        simpleMeasurement.setId("meter-id-01");
        simpleMeasurement.setTimestamp(now());
        simpleMeasurement.setValue(12.5);
        agent.send(simpleMeasurement, config);

        ElectricityMeasurement electricityMeasurement = new ElectricityMeasurement();
        electricityMeasurement.setId("meter-id-02");
        electricityMeasurement.setTimestamp(now());
        electricityMeasurement.setActivePowerPhaseA(5.12);
        electricityMeasurement.setActiveEnergyPhaseA(1.5);
        // ...
        agent.send(electricityMeasurement, config);
    }
}
```

