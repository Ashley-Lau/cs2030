package cs2030.simulator;

import java.util.Random;

public class RandomGenerator {
    private final Random rngArrival;
    private final Random rngService;
    private final Random rngRest;
    private final Random rngRestPeriod;
    private final Random rngTimeoutPeriod;
    private final Random rngCustomerType;
    private final double customerArrivalRate;
    private final double customerServiceRate;
    private final double serverRestingRate;
    
    /**
     * constructor to initialise a RandomGenerator object.
     */
    public RandomGenerator(final int n, final double customerArrivalRate,
        final double customerServiceRate, final double serverRestingRate) {
        this.rngArrival = new Random(n);
        this.rngService = new Random(n + 1);
        this.rngRest = new Random(n + 2);
        this.rngRestPeriod = new Random(n + 3);
        this.rngCustomerType = new Random(n + 4);
        this.rngTimeoutPeriod = new Random(n + 5);
        this.customerArrivalRate = customerArrivalRate;
        this.customerServiceRate = customerServiceRate;
        this.serverRestingRate = serverRestingRate;
    }
    
    public double genInterArrivalTime() {
        return -Math.log(this.rngArrival.nextDouble()) / this.customerArrivalRate;
    }
    
    public double genServiceTime() {
        return -Math.log(this.rngService.nextDouble()) / this.customerServiceRate;
    }
    
    public double genRandomRest() {
        return this.rngRest.nextDouble();
    }
    
    public double genRestPeriod() {
        return -Math.log(this.rngRestPeriod.nextDouble()) / this.serverRestingRate;
    }
    
    public double genCustomerType() {
        return this.rngCustomerType.nextDouble();
    }
}
