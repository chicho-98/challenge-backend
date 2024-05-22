package com.silvercsoft.challenge.controllers;

import com.silvercsoft.challenge.model.Actor;
import com.silvercsoft.challenge.model.Movie;
import com.silvercsoft.challenge.services.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/actors")
public class ActorControllers {

    private final ActorService actorService;

    public ActorControllers(ActorService actorService) {
        this.actorService = actorService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Actor createActor(@RequestBody Actor actor) {
        return this.actorService.createActor(actor);
    }

    @GetMapping("/{id}")
    public Actor getActor(@PathVariable Long id) {
        return this.actorService.getActor(id);
    }

    @GetMapping
    public List<Actor> getActors() {
        return this.actorService.getActors();
    }

    @GetMapping("/{id}/movies")
    public Set<Movie> getActorMovies(@PathVariable Long id) {
        return this.actorService.getActorMovies(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Long id) {
        this.actorService.deleteActor(id);
    }
}
