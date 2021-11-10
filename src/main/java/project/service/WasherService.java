package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Washer;
import project.model.WasherDTO;
import project.repository.WasherRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class WasherService {
    private final WasherRepository washerRepository;

    public int add(Washer washer) {
        return washerRepository.save(washer).getId();
    }

    public boolean existsById(int id) {
        return washerRepository.existsById(id);
    }

    public Washer get(int id) {
        return washerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void delete(int id) {
        washerRepository.deleteById(id);
    }

    public Iterable<Washer> all() {
        return washerRepository.findAll();
    }

    public Iterable<Washer> allHeavier(int weight) {
        return washerRepository.findWashersByWeightGreaterThan(weight);
    }

    @Transactional
    public void update(WasherDTO washerDTO) {
        Washer washer = washerRepository
                .findById(washerDTO.getId())
                .orElseThrow(NoSuchElementException::new);
        washer.setWeight(washerDTO.getWeight());
        washer.setBrand(washerDTO.getBrand());
        washer.setVolume(washerDTO.getVolume());
        washer.setPassword(washerDTO.getPassword());
        washer.setOwnerName(washerDTO.getOwnerName());
    }
}
