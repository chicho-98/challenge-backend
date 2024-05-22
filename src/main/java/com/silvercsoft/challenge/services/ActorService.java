package com.silvercsoft.challenge.services;

import com.silvercsoft.challenge.model.Actor;
import com.silvercsoft.challenge.model.Movie;
import com.silvercsoft.challenge.repositories.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor createActor(Actor actor) {
        return this.actorRepository.save(actor);
    }

    public Actor getActor(Long id) {
        return this.actorRepository.findById(id).orElseThrow();
    }

    public Set<Movie> getActorMovies(Long id) {
        return this.getActor(id).getMovies();
    }

    public void deleteActor(Long id) {
        Actor actor = this.getActor(id);
        actor.removeFromMovies();
        this.actorRepository.deleteById(id);
    }

    public List<Actor> getActors() {
        return this.actorRepository.findAll();
    }
}
