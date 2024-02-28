package harriston.school.core.contracts;

import harriston.school.core.entities.*;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface AdminService {

    AdminService saveWith(ISave item, Consumer<ISave> then);

    ISave save(ISave item);

    List<ISave> listAll(ISave type);

    void delete(ISave id);

}
