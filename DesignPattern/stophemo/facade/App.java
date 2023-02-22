package facade;

/**
 * @Author: huojie
 * @Date： 2023/1/16 9:46
 * @Description:
 */
public class App {
    public static void main(String[] args) {
        Favade favade = new Favade();
        boolean prove = favade.prove(12);
        System.out.println(prove);
    }
}
