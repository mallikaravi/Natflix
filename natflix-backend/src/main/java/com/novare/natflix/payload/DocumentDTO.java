package com.novare.natflix.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.novare.natflix.models.AdditionalDetails;
import com.novare.natflix.models.Documentaries;

@JsonIgnoreProperties(value = { "type_id", "category_id", "logo_url", "poster_url", "banner_url", "seasons",
        "number_of_oscars", "title", "summary",
        "thumbnail_url",
        "season_number",
        "episode_number" })
public class DocumentDTO extends ContentDTO {

    @JsonProperty("content_id")
    private Integer contId;

    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }

    public static List<DocumentDTO> buildDocument(List<Documentaries> documentariesList) {
        List<DocumentDTO> documentResponses = new ArrayList<>();
        for (Documentaries documentaries : documentariesList) {
            DocumentDTO response = new DocumentDTO();
            AdditionalDetails details = documentaries.getAdditionalDetails();
            response.setContId(documentaries.getContent().getId());
            response.setId(documentaries.getId());
            response.setVideoCode(details.getVideoCode());
            documentResponses.add(response);
        }

        return documentResponses;
    }
}
