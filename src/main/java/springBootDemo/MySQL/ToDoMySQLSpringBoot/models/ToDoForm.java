package springBootDemo.MySQL.ToDoMySQLSpringBoot.models;

public class ToDoForm {
    private String title;
    private boolean done;
    private Integer id;

    public boolean isDone() {
        return done;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
