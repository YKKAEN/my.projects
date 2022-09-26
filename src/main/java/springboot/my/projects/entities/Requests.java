package springboot.my.projects.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_request")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "handled", columnDefinition = "boolean default false")
    private boolean handled;

    @ManyToOne(fetch = FetchType.EAGER)
    private Courses course;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Operators> operators;
}
