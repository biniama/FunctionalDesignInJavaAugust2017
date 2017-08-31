package com.dancingcloudservices.functionaldesign;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

/**
 * @author Simon Roberts
 */
class Average {
  private double sum;
  private long count;
  
  public Average() {
  }
  
  public void include(double d) {
    sum += d;
    count++;
  }
  
  public void merge(Average other) {
    sum += other.sum;
    count += other.count;
  }
  
  public double get() {
    return sum / count;
  }
}

public class StreamCollection {
  public static void main(String[] args) {
    long start = System.nanoTime();
    Average a = 
    DoubleStream.generate(()-> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
        .parallel()
        .limit(1_000_000_000)
        .map(Math::sin)
//        .collect(()->new Average(), (b, i) -> b.include(i), (b1, b2) -> b1.merge(b2))
        .collect(Average::new, Average::include, Average::merge)
        ;
    long end = System.nanoTime();
    
    System.out.println("> " + a.get());
    System.out.println("Time was: " + (end - start));
  }
}
