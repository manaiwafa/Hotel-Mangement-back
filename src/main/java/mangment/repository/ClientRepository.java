package mangment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mangment.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
