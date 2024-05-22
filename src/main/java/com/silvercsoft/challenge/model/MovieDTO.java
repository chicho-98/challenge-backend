package com.silvercsoft.challenge.model;

import java.util.Set;

public record MovieDTO(String title, Set<Actor> actors) {
}
