package me.denisblondeel.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

//@Entity
@Document(collection = "measurements")
public class Measurement{

    @Id
    private BigInteger id;

    private double temperature;
    private double humidity;
    private double pressure;

    public Measurement()
    {
        //empty constructor
    }

    public Measurement(double temperature, double humidity, double pressure)
    {
        setHumidity(humidity);
        setPressure(pressure);
        setTemperature(temperature);
    }


    public double getHumidity()
    {
        return humidity;
    }

    public void setHumidity(double humidity)
    {
        this.humidity = humidity;
    }

    public double getPressure()
    {
        return pressure;
    }

    public void setPressure(double pressure)
    {
        this.pressure = pressure;
    }



    public double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(double temperature)
    {
        this.temperature = temperature;
    }

}
