package ru.inno.ec.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marks {
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private Schedule lesson;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Check(constraints = "mark >= 1 and mark <= 5")
    private int mark;

    private String description;
}
