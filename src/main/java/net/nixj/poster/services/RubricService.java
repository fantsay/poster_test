package net.nixj.poster.services;


import net.nixj.poster.entity.Rubric;
import net.nixj.poster.repository.RubricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fantsay on 10/23/15.
 */
@Service
public class RubricService {
    @Autowired
    RubricRepository repo;
    public void createRubric(String name)
    {
        Rubric rubric = new Rubric(name);
        repo.save(rubric);
    }
}
