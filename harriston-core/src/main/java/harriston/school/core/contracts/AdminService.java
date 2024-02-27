package harriston.school.core.contracts;

import harriston.school.core.entities.*;

import java.util.List;

public interface AdminService {

    ISave save(ISave item);

    List<ISave> listAll(ISave type);

    void delete(ISave id);

}
