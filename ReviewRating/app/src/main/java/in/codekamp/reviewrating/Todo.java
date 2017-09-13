package in.codekamp.reviewrating;

/**
 * Created by cerebro on 12/09/17.
 */

public class Todo {
    public int id;
    public String title;
    public int completed;

    public Todo(int completed, String title, int id) {
        this.completed = completed;
        this.title = title;
        this.id = id;
    }
}
