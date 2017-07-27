package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by dinhv on 2/23/2017.
 */
@Entity
@Table(name = "READER_TYPE")
public class ReaderType extends AbstractModel{
    @Column(name = "TYPE_NAME")
    private String typeName;
    @Column(name = "BOOK_LIMIT")
    private short numberOfBookAllowedToBorrow;//số sách tối đa được mượn
    @Column(name = "PERIOD_LIMIT")
    private short reservationPeriod;//số ngày mượn sách tối đa

    public ReaderType() {
    }

    public ReaderType(String typeName, short numberOfBookAllowedToBorrow, short reservationPeriod) {
        this.typeName = typeName;
        this.numberOfBookAllowedToBorrow = numberOfBookAllowedToBorrow;
        this.reservationPeriod = reservationPeriod;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public short getNumberOfBookAllowedToBorrow() {
        return numberOfBookAllowedToBorrow;
    }

    public void setNumberOfBookAllowedToBorrow(short numberOfBookAllowedToBorrow) {
        this.numberOfBookAllowedToBorrow = numberOfBookAllowedToBorrow;
    }

    public short getReservationPeriod() {
        return reservationPeriod;
    }

    public void setReservationPeriod(short reservationPeriod) {
        this.reservationPeriod = reservationPeriod;
    }
}
