package springBootDemo.MySQL.ToDoMySQLSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBootDemo.MySQL.ToDoMySQLSpringBoot.models.ToDo;
import springBootDemo.MySQL.ToDoMySQLSpringBoot.repositories.ToDoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos(){
        return toDoRepository.findAll();
    }

    public void addToDo(ToDo toDo){
        toDoRepository.save(toDo);
    }

    public List<ToDo> getDoneTask(){
        List<ToDo> allToDos = toDoRepository.findAll();
        List<ToDo> doneTask = new ArrayList<>();
        allToDos.forEach((toDo -> {
            if(toDo.getDone())
                doneTask.add(toDo);
        }));
        return doneTask;
    }

    public List<ToDo> getNotDoneTask(){
        List<ToDo> allToDos = toDoRepository.findAll();
        List<ToDo> notDoneTask = new ArrayList<>();
        allToDos.forEach((toDo -> {
            if(!toDo.getDone())
                notDoneTask.add(toDo);
        }));
        return notDoneTask;
    }

    public void changeStatus(Integer Id){
        ToDo toDo = toDoRepository.findById(Id).get();
        toDo.setTitle(toDo.getTitle());
        toDo.setDone(!toDo.getDone());
        toDoRepository.save(toDo);
    }

    public void delete(Integer Id){
        toDoRepository.deleteById(Id);
    }
}
