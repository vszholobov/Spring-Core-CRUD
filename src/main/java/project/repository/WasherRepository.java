package project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.Washer;

import java.util.List;

@Repository
public interface WasherRepository extends CrudRepository<Washer, Integer> {
    List<Washer> findWashersByWeightGreaterThan(int weight);
}
