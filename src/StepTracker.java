public class StepTracker {
    Converter converter = new Converter();

    MonthData[] monthToData;
    public StepTracker() {

        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void createdDays (){
        for (int i = 0; i< monthToData.length; i++ ){
            monthToData[i].createArray();
        }
    }
    public void saveSteps (int userSetMoths, int userSetDays, int steps) {
        monthToData[userSetMoths - 1].days[userSetDays - 1] = steps;
    }

    void showingOurStatistics(int userSetMoths) {
        int[] days = new int[30];
        userSetMoths = userSetMoths -1;

        for (int i = 0; i < days.length; i++) {
            System.out.print(i + 1 +" день " + " пройдено " + " " + monthToData[userSetMoths].days[i] + " \n");
        }

    }
    void showingOurSeries(int userSetMoths) {
        int stepsSeries = 0;
        int stepDump = 0;
        userSetMoths = userSetMoths -1;

        for (int i = 0; i < 30; i++) {
            if (monthToData[userSetMoths].days[i] >= monthToData[userSetMoths].defaultSteps) {
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

    void resultOfEffort(int userSetMoths) {
        int[] days = new int[30];
        int stepSum = 0;
        userSetMoths = userSetMoths -1;
        for (int i = 0; i < days.length; i++) {
            stepSum += monthToData[userSetMoths].days[i];
        }
        System.out.println("Количество сожжённых килокалорий " + converter.getOfFat(stepSum));
        System.out.println("Пройденная дистанция " + converter.conv(stepSum) + " км");
    }

    void  showingSeries(int userSetMoths) {
        int[] days = new int[30];
        int stepSum = 0;
        userSetMoths = userSetMoths -1;
        for (int i = 0; i < days.length; i++) {
            stepSum += monthToData[userSetMoths].days[i];
        }
        System.out.println("Среднее количество шагов за месяц " +  stepSum / days.length);
    }

    void showingMaixmum(int userSetMoths) {
        int stepMax = 0;
        int[] days = new int[30];
        userSetMoths = userSetMoths -1;
        for (int i = 0; i < days.length; i++) {
            if (monthToData[userSetMoths].days[i] > stepMax) {
                stepMax = monthToData[userSetMoths].days[i];
            }
        }
        System.out.println("\n Максимум шагов за месяц " + stepMax);
    }

}