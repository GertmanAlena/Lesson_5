package HomeWork_5;

public class Main {

    private static int forksNumber = 5;

    public static void main(String[] args) {
        /*
        Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
        Вилки лежат на столе между каждой парой ближайших философов.
        Каждый философ может либо есть, либо размышлять.
        Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
        Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
        Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
        Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
         */
        String philosophers[] = {"Mark", "Julius", "Platon", "Wittgenstein", "Kant"};
        Fork forks[] = new Fork[forksNumber];
        for (int i = 0; i < forksNumber; i++) {
            forks[i] = new Fork(i);

        }
        for (int i = 0; i < forksNumber; i++) {
            Philosopher philosopher = new Philosopher(philosophers[i], forks, i);

        }


    }
}
