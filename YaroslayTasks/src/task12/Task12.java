package task12;

public class Task12 {
      /**
       Top N problem
       Description
       You are tasked with implementing a class that handles price updates from the market
       and can output N highest unique price values for the whole class runtime.
       N is immutable throughout the application runtime and should be defined on startup.

       Проблема номер N Описание Вам поручено реализовать класс, который
       обрабатывает обновления цен с рынка и может выводить N самых высоких
       уникальных значений цен за все время работы класса. N неизменяем во время
       выполнения приложения и должен определяться при запуске.
       */
      /**
       Your class must have the following methods:
       void push(int val);
       Collection<Integer> top();
       Where push is called for each new price value and top is called when result is needed.
       Assume that this is a single threaded environment.
       Input
       Infinite stream of non-unique integer values will be fed into handler class by calling push
       method
       Output
       When top method is called you should return a Collection of N highest unique price
       values received by your class throughout whole application runtime. Order of the values
       in a resulting collection doesn't matter

       Ваш класс должен иметь следующие методы:
       void push (int val);
       Collection<Integer> top();
       Где push вызывается для каждого нового значения цены,
       а top вызывается, когда необходим результат.
       Предположим, что это однопоточная среда.
       Вход :
       Бесконечный поток неуникальных целочисленных
       значений будет передан в класс обработчика путем вызова метода push.
       Выход :
       При вызове метода top вы должны вернуть коллекцию из N самых высоких
       уникальных значений цен, полученных вашим классом за все время выполнения
       приложения. Порядок значений в результирующей коллекции не имеет
       значения.
       */
      public static void main(String[] args) {
            /*
                  TreeSetRealization
             */

      }
}
