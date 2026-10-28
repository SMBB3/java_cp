public class PriorityTask extends Task {

    private Priority priority;

    public PriorityTask(int id, String title, String description, Priority priority) {
        super(id, title, description);
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PriorityTask{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", priority=" + getPriority() +
                ", status=" + getStatus() +
                '}';
    }
}