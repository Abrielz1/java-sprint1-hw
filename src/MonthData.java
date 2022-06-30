public class MonthData {

    int[] days = new int[30];
    int defaultSteps = 10_000;
    void createArray() {
        for (int i = 0; i < days.length; i++) {
            days[i] = 0;
        }
    }
}
