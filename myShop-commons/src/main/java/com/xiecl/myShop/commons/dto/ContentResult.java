package com.xiecl.myShop.commons.dto;

import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.domain.ContentCategory;

import java.util.Locale;

public class ContentResult {
    private Content content;
    private ContentCategory category;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public ContentCategory getCategory() {
        return category;
    }

    public void setCategory(ContentCategory category) {
        this.category = category;
    }
}
