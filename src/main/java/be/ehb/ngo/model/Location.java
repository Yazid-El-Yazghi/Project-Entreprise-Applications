package be.ehb.ngo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naam is verplicht")
    private String naam;

    @NotBlank(message = "Adres is verplicht")
    private String adres;

    @Min(value = 1, message = "Capaciteit moet minstens 1 zijn")
    private int capaciteit;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNaam() { return naam; }
    public void setNaam(String naam) { this.naam = naam; }
    public String getAdres() { return adres; }
    public void setAdres(String adres) { this.adres = adres; }
    public int getCapaciteit() { return capaciteit; }
    public void setCapaciteit(int capaciteit) { this.capaciteit = capaciteit; }
}
