package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bvn;

public interface BvnRepository {
    Bvn save(Bvn bvn);
    Bvn findBvn(String id);
    void delete(Bvn bvn);
}
