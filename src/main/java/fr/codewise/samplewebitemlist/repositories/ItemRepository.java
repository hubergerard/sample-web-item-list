package fr.codewise.samplewebitemlist.repositories;

import fr.codewise.samplewebitemlist.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemRepository extends JpaRepository<Item, Long> {

}
