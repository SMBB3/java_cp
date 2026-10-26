import java.util.List;

public interface BookFilter {
    public List< Book > findBooks(String filter);
}
