package springboot.my.projects.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_operator")
public class Operators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "operator_name")
    private String operator_name;

    @Column(name = "operator_surname")
    private String operator_surname;

    @Column(name = "operator_department")
    private String operator_department;

}
