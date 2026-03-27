package za.ac.cput.repository.impl;
import za.ac.cput.entity.Trainer;
import za.ac.cput.repository.TrainerRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Author: Lisakhanya Tshokolo
 * (220239215)
 * 26 March 2026
 */

public class TrainerRepositoryImpl implements TrainerRepository {

    private static TrainerRepositoryImpl repository;
    private Map<String, Trainer> trainersMap;

    private TrainerRepositoryImpl() {
        trainersMap = new HashMap<>();
    }

    public static TrainerRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new TrainerRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Trainer create(Trainer trainer) {
        if (!trainersMap.containsKey(trainer.getTrainerId())) {
            trainersMap.put(trainer.getTrainerId(), trainer);
        }
        return trainersMap.get(trainer.getTrainerId());
    }

    @Override
    public Trainer read(String trainerId) {
        return trainersMap.get(trainerId);
    }

    @Override
    public Trainer save(Trainer trainer) {
        return null;
    }

    @Override
    public Trainer findById(String s) {
        return null;
    }

    @Override
    public List<Trainer> findAll() {
        return List.of();
    }

    @Override
    public Trainer update(Trainer trainer) {
        if (trainersMap.containsKey(trainer.getTrainerId())) {
            trainersMap.put(trainer.getTrainerId(), trainer);
            return trainer;
        }
        return null;
    }

    @Override
    public boolean delete(String trainerId) {
        return trainersMap.remove(trainerId) != null;
    }

    @Override
    public List<Trainer> getAll() {
        return new ArrayList<>(trainersMap.values());
    }
}