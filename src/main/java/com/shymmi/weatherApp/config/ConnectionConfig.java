package com.shymmi.weatherApp.config;

import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Getter
@Setter
public class ConnectionConfig {
    private String host;
    private String key;
    private static ConnectionConfig configInstance;

    public static ConnectionConfig getInstance(){
        if(configInstance == null){
            configInstance = new ConnectionConfig();
            configInstance.load();
        }

        return configInstance;
    }

    public void load(){
        Yaml yaml = new Yaml();
        try {
            InputStream in = Files.newInputStream(Paths.get("src\\main\\java\\com\\shymmi\\weatherApp\\config\\config.yml"));
            ConnectionConfig config = yaml.loadAs(in, ConnectionConfig.class);
            configInstance.setHost(config.getHost());
            configInstance.setKey(config.getKey());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(configInstance.getHost() == null || configInstance.getKey() == null){
            throw new NullPointerException("Host or Key is not set");
        }
    }

    @Override
    public String toString() {
        return "Host: " +host +", Key: " +key;
    }
}
