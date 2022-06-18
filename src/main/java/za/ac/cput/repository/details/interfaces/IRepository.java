package za.ac.cput.repository.details.interfaces;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepository<T, ID> {

    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);
}

