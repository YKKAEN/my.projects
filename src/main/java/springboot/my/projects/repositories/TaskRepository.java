package springboot.my.projects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.my.projects.entities.Task;


@Repository
@Transactional
public interface TaskRepository  extends JpaRepository<Task, Long> {
}
