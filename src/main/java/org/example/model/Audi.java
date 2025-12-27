package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "audi")
public class Audi extends BaseModel {
    String name;

    //UniDirectional
    @OneToMany
    @JoinColumn(name = "audi_id")
    List<Seat> seats;

    //BiDirectional mapping
    @ManyToOne
    Theatre theatre;

    // Since we will need to get a list of shows after user selects a audi
    // not the other way round. So no need of bi directional.
    // we will just keep it here
    // but we are making it bi directional here lets see if later needed.
    @OneToMany(mappedBy = "audi")
    List<Show> shows;
}
