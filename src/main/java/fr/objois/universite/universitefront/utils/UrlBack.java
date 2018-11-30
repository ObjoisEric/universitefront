package fr.objois.universite.universitefront.utils;

public enum  UrlBack {
    NEXUS("http://nexus:8082"),
    SONAR("http://sonar:65000"),
    LEGHTAS("10.115.57.227:8080");

    private String url;

    private UrlBack(String url){
        this.url = url;

    }
    public String getUrl(){
        return this.url;

    }

}
