package be.ehb.ngo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tijdstip is verplicht")
    private LocalDateTime tijdstip;

    @NotBlank(message = "Titel is verplicht")
    private String titel;

    @NotBlank(message = "Omschrijving is verplicht")
    private String omschrijving;

    @NotBlank(message = "Organisatie is verplicht")
    private String organisatie;

    @NotBlank(message = "Email is verplicht")
    @Email(message = "Email moet geldig zijn")
    private String email;

    @ManyToOne
    @NotNull(message = "Locatie is verplicht")
    private Location locatie;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getTijdstip() { return tijdstip; }
    public void setTijdstip(LocalDateTime tijdstip) { this.tijdstip = tijdstip; }
    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }
    public String getOmschrijving() { return omschrijving; }
    public void setOmschrijving(String omschrijving) { this.omschrijving = omschrijving; }
    public String getOrganisatie() { return organisatie; }
    public void setOrganisatie(String organisatie) { this.organisatie = organisatie; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Location getLocatie() { return locatie; }
    public void setLocatie(Location locatie) { this.locatie = locatie; }
}
