package facade;

public class Favade {
    SubFlow1 s1 = new SubFlow1();
    SubFlow2 s2 = new SubFlow2();
    SubFlow3 s3 = new SubFlow3();

    boolean prove(int num) {
        return s1.isWin(num) && s2.isOk(num) && s3.isTrue(num);
    }
}
