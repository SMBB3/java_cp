import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        Integer n = scanner.nextInt();

        Integer dn = new StateMachine<>(n)
                .get();
        show(dn);
        String d2 = new StateMachine<>(n)
                .next(main::a)
                .get();
        show(d2);
        Double d3 = new StateMachine<>(n)
                .next(main::a)
                .next(main::b)
                .get();
        show(d3);
        String d4 = new StateMachine<>(n)
                .next(main::a)
                .next(main::b)
                .next(main::c)
                .get();
        show(d4);
    }
    public static void show(Object o) {
        System.out.println(o.getClass().getSimpleName() + ": " +o);
    }
    public State<String> a(State<Integer> num) {
        return State.of(String.valueOf(num.get()));
    }
    public State<Double> b(State<String> s) {
        return State.of(Double.parseDouble(s.get()) + 5.0);
    }
    public State<String> c(State<Double> d) {
        return State.of("number: " + d.get());
    }
}