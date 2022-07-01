public class StepTracker {
    Converter converter = new Converter();

    MonthData[] monthToData;
    public StepTracker() {

        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void createdDays () {
        for (int i = 0; i< monthToData.length; i++ ){
            monthToData[i].createArray();
        }
    }
    public void saveSteps (int userInputMonth, int userInputDays, int steps) {
        monthToData[userInputMonth - 1].days[userInputDays - 1] = steps;
    }

    void showingOurStatistics(int userInputMonth) {

        for (int i = 0; i < monthToData[userInputMonth].days.length; i++) {
            System.out.print(i + 1 +" день " + " пройдено " + " " + monthToData[userInputMonth].days[i] + " \n");
        }
                                System.out.println();
    }
    void showingOurSeries(int userInputMonth) {
        int stepsSeries = 0;
        int stepDump = 0;

        for (int i = 0; i < 30; i++) {
            if (monthToData[userInputMonth].days[i] >= monthToData[userInputMonth].defaultSteps) {
                stepDump = stepDump + 1;
            } else if (stepDump >= stepsSeries) {
                stepDump = 0;
            }
            if(stepsSeries<stepDump) {
                stepsSeries =  stepDump;
            }
        }
        System.out.println("Лучшая серия " + stepsSeries + " день");
    }

    void resultOfEffort(int userInputMonth) {
        int stepSum = 0;
        for (int i = 0; i < monthToData[userInputMonth].days.length; i++) {
            stepSum += monthToData[userInputMonth].days[i];
        }
        String str0 = String.format("Количество сожжённых килокалорий:    %.2f кал", converter.getOfFat(stepSum));
        System.out.println(str0);

        String str1 = String.format("Пройденная дистанция:    %.2f   км", converter.conv(stepSum));
        System.out.println(str1);
    }

    void  showingSeries(int userInputMonth) {
        int stepSum = 0;
        for (int i = 0; i < monthToData[userInputMonth].days.length; i++) {
            stepSum += monthToData[userInputMonth].days[i];
        }
        System.out.println("Среднее количество шагов за месяц " +  stepSum / monthToData[userInputMonth].days.length);
    }

    void showingMaximum(int userInputMonth) {
        int stepMax = 0;
        int[] days = new int[30];
        for (int i = 0; i < days.length; i++) {
            if (monthToData[userInputMonth].days[i] > stepMax) {
                stepMax = monthToData[userInputMonth].days[i];
            }
        }
        System.out.println("Максимум шагов за месяц " + stepMax + "\n");
    }

}
