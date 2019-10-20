package me.denisblondeel.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Measurement{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

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
