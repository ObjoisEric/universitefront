package fr.objois.universite.universitefront.utils;

public enum ListUrl {

    url(UrlBack.SONAR);

    private UrlBack urlBack;

    private ListUrl(UrlBack urlBack) {
        this.urlBack = urlBack;
    }
    public UrlBack getUrl(){
        return this.urlBack;

    }


}
