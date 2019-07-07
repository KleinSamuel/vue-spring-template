package de.sksdev.backend.db.repositories;

import de.sksdev.backend.db.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> findByEmail(@Param("email") String email);

}
