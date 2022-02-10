package springBootDemo.MySQL.ToDoMySQLSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBootDemo.MySQL.ToDoMySQLSpringBoot.models.ToDo;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
}
