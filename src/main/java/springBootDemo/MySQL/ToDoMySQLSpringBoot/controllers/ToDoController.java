package springBootDemo.MySQL.ToDoMySQLSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springBootDemo.MySQL.ToDoMySQLSpringBoot.models.ToDo;
import springBootDemo.MySQL.ToDoMySQLSpringBoot.models.ToDoForm;
import springBootDemo.MySQL.ToDoMySQLSpringBoot.services.ToDoService;

import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping
    String getAllToDos(Model model){
        List<ToDo> toDos = toDoService.getAllToDos();
        model.addAttribute("toDoList", toDos);
        model.addAttribute("newToDo", new ToDoForm());
        return "allToDo";
    }

    @GetMapping("/done")
    String getAllDoneToDo(Model model){
        List<ToDo> toDos = toDoService.getDoneTask();
        model.addAttribute("toDoList", toDos);
        model.addAttribute("newToDo", new ToDoForm());
        return "allToDo";
    }

    @GetMapping("/notDone")
    String getAllNotDoneToDo(Model model){
        List<ToDo> toDos = toDoService.getNotDoneTask();
        model.addAttribute("toDoList", toDos);
        model.addAttribute("newToDo", new ToDoForm());
        return "allToDo";
    }

    @PostMapping
    String addToDo(@ModelAttribute("newToDo") ToDoForm toDoform){
        toDoService.addToDo(new ToDo(toDoform.getTitle()));
        return "redirect:/";
    }

    @PostMapping("/{id}/changeStatus")
    String changeStatus(@PathVariable Integer id){
        toDoService.changeStatus(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    String delete(@PathVariable Integer id){
        toDoService.delete(id);
        return "redirect:/";
    }
}
