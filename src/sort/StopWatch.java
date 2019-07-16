package sort;

public class StopWatch {

    private long startTime = 0;
    private long stopTime = 0;

    public StopWatch()
    {
        startTime = System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
        System.out.println("sort.StopWatch: " + getElapsedTime() + " milliseconds.");
        System.out.println("sort.StopWatch: " + getElapsedTimeSecs() + " seconds.");
    }

    /**
     * @param process_name
     */
    public void stop(String process_name) {
        stopTime = System.currentTimeMillis();
        System.out.println(process_name + " sort.StopWatch: " + getElapsedTime() + " milliseconds.");
        System.out.println(process_name + " sort.StopWatch: " + getElapsedTimeSecs() + " seconds.");
    }

    //elaspsed time in milliseconds
    public long getElapsedTime() {
        return stopTime - startTime;
    }

    //elaspsed time in seconds
    public double getElapsedTimeSecs() {
        double elapsed;
        elapsed = ((double)(stopTime - startTime)) / 1000;
        return elapsed;
    }
}
