package gst.mockproject.database.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dinhv on 2/5/2017.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    protected int id;

    public AbstractModel() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
