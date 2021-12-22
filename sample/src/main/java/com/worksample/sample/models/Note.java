package com.worksample.sample.models;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "notes")
@ToString @EqualsAndHashCode
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "title")
    private String title;

    @Getter @Setter @Column(name = "content")
    private String content;

    @Getter @Setter @Column(name = "createdat")
    private String createdat;

    @Getter @Setter @Column(name = "updatedat")
    private String updatedat;

}
