package me.denisblondeel.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;

//@Entity
@Document(collection = "measurements")
public class Measurement{

    @Id
    private BigInteger id;

    private double temperature;
    private double humidity;
    private double pressure;
    private double wind;
    private double rain;
    private LocalDateTime timestamp;

    public Measurement()
    {
        //empty constructor
    }

    public Measurement(double temperature, double humidity, double pressure, double rain, double wind)
    {
        setHumidity(humidity);
        setPressure(pressure);
        setTemperature(temperature);
        setWind(wind);
        setRain(rain);
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

    public void setRain(double rain){this.rain = rain;}

    public double getRain(){return rain;}

    public void setWind(double wind){this.wind = wind;}

    public double getWind(){return wind;}

    public double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(double temperature)
    {
        this.temperature = temperature;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

}
