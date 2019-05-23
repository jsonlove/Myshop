package com.xiecl.myShop.domain;

public class Content extends BaseBean{
        private String categoryid ;
        private String 	title ;
        private String 	subtitle ;
        private String 	titledesc ;
        private String 	url ;
        private String 	pic ;
        private String 	pic2 ;
        private String 	content ;

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitledesc() {
        return titledesc;
    }

    public void setTitledesc(String titledesc) {
        this.titledesc = titledesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
