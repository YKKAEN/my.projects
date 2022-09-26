package springboot.my.projects.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "taskName")
    private String taskName;

    @Column(name = "task_decription")
    private String taskDecription;

    @Column(name = "taskDeadlineDate")
    private String taskDeadlineDate;

    @Column(name = "isCompleted", columnDefinition = "boolean default false")
    private boolean isCompleted;
}
