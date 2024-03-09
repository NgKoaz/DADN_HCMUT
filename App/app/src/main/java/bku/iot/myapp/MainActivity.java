package bku.iot.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MainActivity extends AppCompatActivity {
    MqttClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String broker = "ssl://io.adafruit.com:8883";
        String username = "";
        String password = "";
        byte qos = 1;
        String clientId = MqttClient.generateClientId();
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        MqttConnectOptions opts = new MqttConnectOptions();
        opts.setCleanSession(true);
        opts.setUserName(username);
        opts.setPassword(password.toCharArray());


        try {
            this.client = new MqttClient(broker, clientId, memoryPersistence);
            IMqttToken token = this.client.connectWithResult(opts);

            MqttMessage message = new MqttMessage("32".getBytes());
            message.setQos(qos);
            // this.client.publish(username + "/f/sensor", message);
            // this.client.subscribe(username+ "f/button1");


            this.client.disconnect();
        } catch (MqttException me){
            me.printStackTrace();
        }



    }
}