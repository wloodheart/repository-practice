package by.wlood.spring.data.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    private String email;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
