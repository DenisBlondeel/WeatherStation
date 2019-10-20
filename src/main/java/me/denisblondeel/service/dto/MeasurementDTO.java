package me.denisblondeel.service.dto;

public class MeasurementDTO {

    private long id;

    private double temperature;
    private double humidity;
    private double pressure;

    public MeasurementDTO()
    {
        //empty constructor
    }

    public MeasurementDTO(double temperature, double humidity, double pressure)
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