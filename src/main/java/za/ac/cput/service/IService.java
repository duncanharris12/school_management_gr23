package za.ac.cput.service;

import java.util.Optional;

public interface IService<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);

}
