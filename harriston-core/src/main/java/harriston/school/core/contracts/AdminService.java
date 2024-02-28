package harriston.school.core.contracts;

import harriston.school.core.entities.*;

import java.util.List;
import java.util.function.Consumer;

public interface AdminService {

    AdminService saveThen(ISave item, Consumer<ISave> then);

    ISave save(ISave item);

    List<ISave> listAll(ISave type);

    void delete(ISave id);

}
