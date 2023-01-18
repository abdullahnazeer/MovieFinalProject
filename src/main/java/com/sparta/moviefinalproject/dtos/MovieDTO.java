package com.sparta.moviefinalproject.dtos;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import com.sparta.moviefinalproject.dtos.subdtos.AwardDTO;
import com.sparta.moviefinalproject.dtos.subdtos.ImdbDTO;
import com.sparta.moviefinalproject.dtos.subdtos.TomatoDTO;
import com.sparta.moviefinalproject.entities.subentities.Award;
import com.sparta.moviefinalproject.entities.subentities.Imdb;
import com.sparta.moviefinalproject.entities.subentities.Tomato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import com.sparta.moviefinalproject.converters.subtypes.AwardConverter;
import com.sparta.moviefinalproject.converters.subtypes.ImdbConverter;
import com.sparta.moviefinalproject.converters.subtypes.TomatoConverter;
import java.time.LocalDateTime;
import com.sparta.moviefinalproject.entities.Movie;
import com.sparta.moviefinalproject.entities.subentities.Award;
import com.sparta.moviefinalproject.entities.subentities.Imdb;
import com.sparta.moviefinalproject.entities.subentities.Tomato;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    @NonNull
    private ObjectId id;
    @Embedded
    @NonNull
    private AwardDTO awards;
    @Nullable
    private String[] directors;
    @Nullable
    private String fullPlot;
    @Nullable
    private String[] languages;
    @Nullable
    private Integer numMflixComments;
    @Nullable
    private String plot;
    @NonNull
    private String title;
    @Nullable
    private String[] writers;
    @Nullable
    private String[] genres;
    @Nullable
    private LocalDateTime lastUpdated;
    @Nullable
    private String poster;
    @Embedded
    @Nullable
    private TomatoDTO tomatoes;
    @NonNull
    private String year;
    @Embedded
    @NonNull
    private Imdb imdb;
    @Nullable
    private String rated;
    @Nullable
    private LocalDateTime released;
    @Nullable
    private String[] cast;
    @Nullable
    private Integer runtime;
    @Nullable
    private String[] countries;
    @NonNull
    private String type;

    public boolean dtoEqualsEntity(Movie obj) {
        AwardDTO awardConverted = new AwardConverter().entityToDto(obj.getAwards());
        TomatoDTO tomatoConverted = new TomatoConverter().entityToDto(obj.getTomatoes());
        ImdbDTO imdbConverted = new ImdbConverter().entityToDto(obj.getImdb());
        if (this.getId() == obj.getId() &&
                this.getAwards().equals(awardConverted) &&
                this.getDirectors() == obj.getDirectors() &&
                this.getFullPlot() == obj.getFullPlot() &&
                this.getLanguages() == obj.getLanguages() &&
                this.getNumMflixComments() == obj.getNumMflixComments() &&
                this.getPlot() == obj.getPlot() &&
                this.getTitle() == obj.getTitle() &&
                this.getWriters() == obj.getWriters() &&
                this.getGenres() == obj.getGenres() &&
                this.getLastUpdated() == obj.getLastUpdated() &&
                this.getPoster() == obj.getPoster() &&
                this.getTomatoes().equals(tomatoConverted) &&
                this.getYear() == obj.getYear() &&
                this.getImdb().equals(imdbConverted) &&
                this.getRated() == obj.getRated() &&
                this.getReleased() == obj.getReleased() &&
                this.getCast() == obj.getCast() &&
                this.getRuntime() == obj.getRuntime() &&
                this.getCountries() == obj.getCountries() &&
                this.getType() == obj.getType()){
            return true;
        } else {
            return false;
        }
    }
}
