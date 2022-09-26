package springboot.my.projects.database.constructors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    private Long id;
    private String name;
    private String description;
    private double price;
}
