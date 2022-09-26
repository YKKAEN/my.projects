package springboot.my.projects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.my.projects.entities.Requests;

import java.util.List;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Requests, Long> {

    List<Requests> findByHandledIsTrue();
    List<Requests> findByHandledFalse();
}
