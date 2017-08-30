package com.dancingcloudservices.functionaldesign;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

/**
 * @author Simon Roberts
 */
public class Car {

  private final Color color;
  private final String make;
  private final List<String> permits;

  public Car(Color color, String make, String... permits) {
    this.color = color;
    this.make = make;
    this.permits = Arrays.asList(permits);
  }

  public Color getColor() {
    return color;
  }
  
  public String getMake() {
    return make;
  }

  public List<String> getPermits() {
    return permits;
  }

  @Override
  public String toString() {
    return "Car{" + "color=" + color + ", make=" + make + ", permits=" + permits + '}';
  }
}
