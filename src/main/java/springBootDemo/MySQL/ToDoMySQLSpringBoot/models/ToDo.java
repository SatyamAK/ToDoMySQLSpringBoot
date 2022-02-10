package springBootDemo.MySQL.ToDoMySQLSpringBoot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ToDo")
@Getter
@Setter
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private Boolean done;

    public ToDo(){

    }

    public ToDo(String title){
        this.title = title;
        this.done = false;
    }

    public ToDo(Integer id, String title, Boolean done){
        this.title = title;
        this.done = !done;
    }
    public String getTitle() {
        return title;
    }
}
