package com.silvercsoft.challenge.model;

import java.util.Set;

public record MovieDTO(String title, int runtimeMinutes, String genre, Set<Actor> actors) {
}
