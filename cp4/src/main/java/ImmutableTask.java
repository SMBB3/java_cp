public final class ImmutableTask {
    private final int id;
    private final String title;
    private final Priority priority;

    public ImmutableTask(int id, String title, Priority priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public Priority getPriority() { return priority; }


    public ImmutableTask withTitle(String newTitle) {
        return new ImmutableTask(this.id, newTitle, this.priority);
    }

    @Override
    public String toString() {
        return "ImmutableTask{id=" + id + ", title='" + title + "', priority=" + priority + '}';
    }
}