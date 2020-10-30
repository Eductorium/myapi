package ru.mtuci.myapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Access(AccessType.FIELD)
// https://thorben-janssen.com/access-strategies-in-jpa-and-hibernate/
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class AbstractBaseEntity {
    public static final int START_SEQ = 1;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Long id;

    public AbstractBaseEntity(Long id) {
        this.id = id;
    }
}
