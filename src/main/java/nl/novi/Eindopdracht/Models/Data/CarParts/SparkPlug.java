package nl.novi.Eindopdracht.Models.Data.CarParts;

import jakarta.persistence.Entity;


@Entity
public class SparkPlug extends CarParts {
    private  int spannerSize;
    private String quality;
    private int warmthDegree;
    private Double threadLenght;
    private int torque;
    private int sparkPosition;


    public SparkPlug(Long id, String partName, String partNumber, Double price, Integer amountOfParts,
                     int spannerSize, String quality, int warmthDegree,
                     Double threadLenght, int torque, int sparkPosition) {
        super(id, partName, partNumber, price, amountOfParts);
        this.spannerSize = spannerSize;
        this.quality = quality;
        this.warmthDegree = warmthDegree;
        this.threadLenght = threadLenght;
        this.torque = torque;
        this.sparkPosition = sparkPosition;
    }

    public SparkPlug() {
        super();
    }

    public int getSpannerSize() {
        return spannerSize;
    }

    public String getQuality() {
        return quality;
    }

    public int getWarmthDegree() {
        return warmthDegree;
    }

    public Double getThreadLenght() {
        return threadLenght;
    }

    public int getTorque() {
        return torque;
    }

    public int getSparkPosition() {
        return sparkPosition;
    }

    public void setSpannerSize(int spannerSize) {
        this.spannerSize = spannerSize;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setWarmthDegree(int warmthDegree) {
        this.warmthDegree = warmthDegree;
    }

    public void setThreadLenght(Double threadLenght) {
        this.threadLenght = threadLenght;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public void setSparkPosition(int sparkPosition) {
        this.sparkPosition = sparkPosition;
    }
}
