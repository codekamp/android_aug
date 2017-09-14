package in.codekamp.todoapp;

/**
 * Created by cerebro on 12/09/17.
 */

public class Todo {
    public int id;
    public String title;
    public boolean completed;

    public Todo(int id, String title, boolean completed) {
        this.completed = completed;
        this.title = title;
        this.id = id;
    }
}
