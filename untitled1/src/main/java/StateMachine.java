import lombok.ToString;

import java.util.function.Function;
@ToString

public class StateMachine<T> {
    private T value;

    public StateMachine(T value) {
        this.value = value;
    }

    public <R> StateMachine<R> next(Function<State<T>, State<R>> function) {
        State<T> currentState = State.of(this.value);
        State<R> nextState = function.apply(currentState);
        return new StateMachine<>(nextState.get());
    }

    public T get() {
        return this.value;
    }
}