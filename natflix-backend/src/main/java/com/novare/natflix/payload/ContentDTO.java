package com.novare.natflix.payload;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflix.exceptions.NatflixException;
import com.novare.natflix.models.AdditionalDetails;
import com.novare.natflix.models.Content;
import com.novare.natflix.models.Documentaries;
import com.novare.natflix.models.EType;
import com.novare.natflix.models.Episodes;
import com.novare.natflix.models.Movies;
import com.novare.natflix.models.Seasons;
import com.novare.natflix.models.Series;
import com.novare.natflix.utils.ImageUtils;

public class ContentDTO implements Comparable<ContentDTO> {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("title")
	@NotEmpty
	private String title;

	@JsonProperty("type_id")
	@NotEmpty
	private Integer typeId;

	@JsonProperty("category_id")
	@NotEmpty
	private Integer catId;

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("logo_url")
	private String logUrl;

	@JsonProperty("poster_url")
	private String posterUrl;

	@JsonProperty("banner_url")
	private String bannerUrl;

	@JsonProperty("thumbnail_url")
	private String thumbnailUrl;

	@JsonProperty("season_number")
	private Integer seasonNumber;

	@JsonProperty("episode_number")
	private Integer episodeNumber;

	@JsonProperty("episode_url")
	private String episodeUrl;

	@JsonProperty("video_code")
	private String videoCode;

	@JsonProperty("number_of_oscars")
	private Integer numberOfOscars;

	@JsonProperty("seasons")
	private Set<SeasonsDTO> seasons;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLogUrl() {
		return logUrl;
	}

	public void setLogUrl(String logUrl) {
		this.logUrl = logUrl;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getEpisodeUrl() {
		return episodeUrl;
	}

	public void setEpisodeUrl(String episodeUrl) {
		this.episodeUrl = episodeUrl;
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
	}

	public Integer getNumberOfOscars() {
		return numberOfOscars;
	}

	public void setNumberOfOscars(Integer numberOfOscars) {
		this.numberOfOscars = numberOfOscars;
	}

	public Set<SeasonsDTO> getSeasons() {
		return seasons;
	}

	public void setSeasons(Set<SeasonsDTO> seasons) {
		this.seasons = seasons;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		ContentDTO contentDTO = (ContentDTO) obj;
		return this.getId() == contentDTO.getId();
	}

	@Override
	public int compareTo(ContentDTO o) {
		return getId().compareTo(o.getId());
	}

	public static List<ContentDTO> get(List<Content> contents, EType eType) throws NatflixException {
		return build(contents).get(eType);
	}

	public static Map<EType, List<ContentDTO>> build(List<Content> contents) throws NatflixException {
		Map<EType, List<ContentDTO>> contentMap = new HashMap<>();
		List<ContentDTO> contentReponses = new ArrayList<>();
		for (Content content : contents) {
			Integer typeId = content.getContentType().getId();
			switch (typeId) {
				case 1 -> {
					List<ContentDTO> buildSeries = buildSeries(content.getSeries(), typeId);
					contentMap.put(EType.SERIES, buildSeries);
					contentReponses.addAll(buildSeries);
				}
				case 2 -> {
					List<ContentDTO> buildMovies = buildMovies(content.getMovies(), typeId);
					contentMap.put(EType.MOVIES, buildMovies);
					contentReponses.addAll(buildMovies);
				}
				case 3 -> {
					List<ContentDTO> buildDocumentaries = buildDocumentaries(content.getDocumentaries(), typeId);
					contentMap.put(EType.DOCUMENTARIES, buildDocumentaries);
					contentReponses.addAll(buildDocumentaries);
				}
				default -> throw new IllegalArgumentException("Unexpected value: ");
			}
		}
		contentMap.put(EType.CONTENT, contentReponses);
		return contentMap;

	}

	public static List<ContentDTO> buildSeries(Set<Series> seriesSet, Integer typeId) {
		List<ContentDTO> seriesResponse = new ArrayList<>();
		for (Series series : seriesSet) {
			AdditionalDetails additional = series.getAdditional();
			ContentDTO response = createResponse(additional, series.getId(), series.getCategory().getId(), typeId);
			seriesResponse.add(response);
		}
		Collections.sort(seriesResponse);
		return seriesResponse;
	}

	public static List<ContentDTO> buildMovies(Set<Movies> moviesSet, Integer typeId) {
		List<ContentDTO> movieResponse = new ArrayList<>();
		for (Movies movie : moviesSet) {
			AdditionalDetails additional = movie.getAdditional();
			ContentDTO response = createResponse(additional, movie.getId(), movie.getCategory().getId(), typeId);
			movieResponse.add(response);
		}
		Collections.sort(movieResponse);
		return movieResponse;
	}

	public static List<ContentDTO> buildDocumentaries(Set<Documentaries> documentaries, Integer typeId) {
		List<ContentDTO> documentResponse = new ArrayList<>();
		for (Documentaries document : documentaries) {
			AdditionalDetails additional = document.getAdditionalDetails();
			ContentDTO response = createResponse(additional, document.getId(), document.getCategory().getId(), typeId);
			documentResponse.add(response);
		}
		Collections.sort(documentResponse);
		return documentResponse;
	}

	public static ContentDTO createResponse(AdditionalDetails additional, int id, int catId, int typeId) {
		ContentDTO response = new ContentDTO();
		response.setCatId(catId);
		response.setId(id++);
		response.setTypeId(typeId);

		response.setBannerUrl(ImageUtils.toBase64(additional.getBannerUrl()));
		response.setLogUrl(ImageUtils.toBase64(additional.getLogoUrl()));
		response.setPosterUrl(ImageUtils.toBase64(additional.getPosterUrl()));
		response.setThumbnailUrl(ImageUtils.toBase64(additional.getThumbnailUrl()));
		response.setEpisodeUrl(ImageUtils.toBase64(additional.getEpisodeUrl()));

		response.setSummary(additional.getSummary());
		response.setTitle(additional.getTitle());
		response.setVideoCode(additional.getVideoCode());
		return response;
	}

	public static Series createSeriesModel(ContentDTO builder) {
		AdditionalDetails additionalModel = createAdditionalModel(builder);
		Series series = new Series();
		series.setId(builder.getId());
		series.setAdditional(additionalModel);
		return series;
	}

	private static AdditionalDetails createAdditionalModel(ContentDTO builder) {
		AdditionalDetails details = new AdditionalDetails();
		details.setPosterUrl(builder.getPosterUrl());
		details.setSummary(builder.getSummary());
		details.setBannerUrl(ImageUtils.toImageFile(builder.getBannerUrl(), "banners/"));
		details.setLogoUrl(ImageUtils.toImageFile(builder.getLogUrl(), "logos/"));
		details.setThumbnailUrl(ImageUtils.toImageFile(builder.getThumbnailUrl(), "thumbnails/"));
		details.setEpisodeUrl(ImageUtils.toImageFile(builder.getEpisodeUrl(), "episodes/"));
		details.setPosterUrl(ImageUtils.toImageFile(builder.getPosterUrl(), "posters/"));
		details.setTitle(builder.getTitle());
		details.setVideoCode(builder.getVideoCode());
		return details;
	}

	public static Movies createMoviesModel(ContentDTO request) {
		AdditionalDetails additionalModel = createAdditionalModel(request);
		Movies movies = new Movies();
		movies.setId(request.getId());
		movies.setNumberOfoscar(request.getNumberOfOscars());
		movies.setAdditional(additionalModel);
		return movies;
	}

	public static Documentaries createDocumentModel(ContentDTO request) {
		AdditionalDetails additionalModel = createAdditionalModel(request);
		Documentaries documentaries = new Documentaries();
		documentaries.setId(request.getId());
		documentaries.setAdditionalDetails(additionalModel);
		return documentaries;
	}

	public static List<ContentDTO> buildSeriesDTO(Series series) {
		List<ContentDTO> seriesResponse = new ArrayList<>();
		for (Seasons seasons : series.getSeasons()) {
			for (Episodes episodes : seasons.getEpisodes()) {
				AdditionalDetails details = episodes.getAdditional();
				ContentDTO dto = createResponse(details, episodes.getId(), series.getCategory().getId(), 1);
				dto.setEpisodeNumber(episodes.getEpisodeNumber());
				dto.setSeasonNumber(seasons.getSeasonNumber());
				seriesResponse.add(dto);
			}
		}
		Collections.sort(seriesResponse);
		return seriesResponse;
	}

}
