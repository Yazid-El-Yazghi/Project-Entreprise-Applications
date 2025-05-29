package be.ehb.ngo.repository;

import be.ehb.ngo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}