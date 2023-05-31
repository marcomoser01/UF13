package it.altaformazione.foodmemongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.altaformazione.foodmemongo.models.User;

//Tra le parentesi triangolari si mette la tabella  (in questo caso User) e il tipo della chiave primaria
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByAge(int age);

}
