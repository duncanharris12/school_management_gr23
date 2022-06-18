package za.ac.cput.service.users;

public interface IService<T, ID> {

    T save(T t);
    T read(ID id);
    void delete(ID id);
}
