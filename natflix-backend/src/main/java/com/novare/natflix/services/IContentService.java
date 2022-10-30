package com.novare.natflix.services;

import com.novare.natflix.models.Content;

public interface IContentService {
	Content findByContentType(String type);
}
