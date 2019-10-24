package thread;

public class Thread6Test {
    public static void main(String[] args) {
        Thread6 outclass = new Thread6();
        Thread6.Ta ta = outclass.new Ta();
        Thread6.Tb tb = outclass.new Tb();
        Thread6.Tc tc = outclass.new Tc();
        Thread6.Td td = outclass.new Td();
        ta.start();
        tb.start();
        tc.start();
        td.start();
    }
}
