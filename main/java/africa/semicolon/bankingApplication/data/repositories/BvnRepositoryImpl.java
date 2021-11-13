package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bvn;

import java.util.ArrayList;
import java.util.List;

public class BvnRepositoryImpl implements BvnRepository {
    private List<Bvn> bvns = new ArrayList<>();

    @Override

    public Bvn save(Bvn bvn) {
        bvns.add(bvn);
        return bvn;
    }

    @Override
    public Bvn findBvn(String id) {
        return null;
    }

    @Override
    public void delete(Bvn bvn) {

    }
}

