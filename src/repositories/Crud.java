package repositories;

import java.util.List;

public interface Crud<T, I> {
  T create(T element);

  List<T> getAll();

  T listOne(I id);

  T updateOne(T element);

  T deleteOne(I id);
}
