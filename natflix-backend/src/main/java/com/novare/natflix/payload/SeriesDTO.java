package com.novare.natflix.payload;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflix.models.AdditionalDetails;
import com.novare.natflix.models.Episodes;
import com.novare.natflix.models.Seasons;
import com.novare.natflix.models.Series;

@JsonIgnoreProperties(value = { "type_id", "category_id", "logo_url", "poster_url", "banner_url", "number_of_oscars",
        "seasons" })
public class SeriesDTO extends ContentDTO {

    @JsonProperty("content_id")
    private Integer contId;

    @JsonProperty("season_number")
    private Integer seasonNumber;

    @JsonProperty("episode_number")
    private Integer episodeNumber;

    @JsonProperty("video_code")
    private String videoCode;

    @JsonProperty("seasons")
    private Set<SeasonsDTO> seasons;

    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    };

    public Set<SeasonsDTO> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<SeasonsDTO> seasons) {
        this.seasons = seasons;
    }

    public static List<SeriesDTO> buildSeries(List<Series> seriesList) {
        List<SeriesDTO> seriesResponses = new ArrayList<>();
        int id = 1;
        for (Series series : seriesList) {
            int contentId = series.getContent().getId();
            for (Seasons season : series.getSeasons()) {
                int seasonNumber = season.getSeasonNumber();
                for (Episodes episodes : season.getEpisodes()) {
                    SeriesDTO response = new SeriesDTO();
                    AdditionalDetails details = episodes.getAdditional();
                    response.setId(id);
                    response.setContId(contentId);
                    response.setSeasonNumber(seasonNumber);
                    response.setEpisodeNumber(episodes.getEpisodeNumber());
                    response.setTitle(details.getTitle());
                    response.setSummary(details.getSummary());
                    response.setThumbnailUrl(details.getThumbnailUrl());
                    response.setVideoCode(details.getVideoCode());
                    seriesResponses.add(response);
                    id++;
                }
            }
        }
        return seriesResponses;
    }
}
