package com.novare.natflix.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeasonsDTO {

    @JsonProperty("season")
    private Integer season;

    @JsonProperty("episodes")
    private List<EpisodesDTO> episodes;

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public List<EpisodesDTO> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<EpisodesDTO> episodes) {
        this.episodes = episodes;
    }
}
