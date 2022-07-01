public class Converter {
    double stepSize = 0.75;                                                              // 1 шаг равный 75 сантиметров
    double divisor = 1000;  // те калории, что мы жгём пока гуляем. Использован в виде переменной, так как мы приводим дроби, и делитель в обоих случая одинаков использована одна переменная.
    double calories = 50.0;                                                             //то, что мы сжигаем за 1 шаг
                                                                                                         // 1 килокалория = 1000 калорий

    double conv (double stepSum) {
        return stepSize * stepSum /  divisor;                  //вычисляем пройденную дистанцию

    }
    double getOfFat (double stepSum) {                                           //вычисляем сожёные калории, те жыр
        return stepSum * calories / divisor;

    }

}