package HomeWork_5;

public class Fork{

    private int IdFork;
    private boolean flag = true;

    public Fork(int id){
        this.IdFork = id;
    }
    synchronized public boolean use() {
        if (flag) {
            System.out.println("Ура!!! Вилка под номером: " + IdFork + "свободна" );
            flag = false;
            return true;
        } else {
            System.out.println("Не могу взять вилку: " + IdFork  );
            return false;
        }
    }
    synchronized public void drop() {
        flag = false;
        System.out.println(" вилка номер: " + IdFork + "доступна");
    }
}
