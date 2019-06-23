/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softultra.almamater.models;

import java.util.Arrays;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

/**
 *
 * @author JSilva
 */
@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int region;
    private String url;
    @Column(name = "urlescudo")
    private String urlEscudo;
    @Column(name = "ptsbeca")
    private int ptsBca;
    @Column(name = "ptsacr")
    private int ptsAcr;
    @Column(name = "ptsrank")
    private int ptsRank;
    @Column(name = "isprivate")
    private String isPrivate;
    @Column(name = "rankuniver")
    private int rankUniver;
    @Column(name = "anosacr")
    private int anosAcr;
    @Transient
    private int ptsNear;
    @Transient
    private double distanceKNN;

    private double lat;
    private double lng;
    @Transient
    private double distanceLatLng;

    @ManyToMany
    @JoinTable(
            name = "university_has_career",
            joinColumns = @JoinColumn(name = "university_id"),
            inverseJoinColumns = @JoinColumn(name = "career_id"))
    Set<Career> careers;

    public University() {
    }
 
    

    public Set<Career> getCareers() {
        return careers;
    }

    public void setCareers(Set<Career> careers) {
        this.careers = careers;
    }

    public double[] getPointsWithNear() {
        double[] points = {ptsBca, ptsAcr, ptsRank, ptsNear};
        return points;
    }

    public double[] getPoints() {
        double[] points = {ptsBca, ptsAcr, ptsRank};
        return points;
    }

    public double getPointsSum() {
        return Arrays.stream(getPoints()).sum();
    }

    public double getDistanceKNN() {
        return distanceKNN;
    }

    public void setDistanceKNN(double distanceKNN) {
        this.distanceKNN = distanceKNN;
    }

    public double getDistanceLatLng() {
        return distanceLatLng;
    }

    public void setDistanceLatLng(double distanceLatLng) {
        this.distanceLatLng = distanceLatLng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getPtsBca() {
        return ptsBca;
    }

    public void setPtsBca(int ptsBca) {
        this.ptsBca = ptsBca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getPtsAcr() {
        return ptsAcr;
    }

    public void setPtsAcr(int ptsAcr) {
        this.ptsAcr = ptsAcr;
    }

    public int getPtsRank() {
        return ptsRank;
    }

    public void setPtsRank(int ptsRank) {
        this.ptsRank = ptsRank;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public int getPtsNear() {
        return ptsNear;
    }

    public void setPtsNear(int ptsNear) {
        this.ptsNear = ptsNear;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlEscudo() {
        return urlEscudo;
    }

    public void setUrlEscudo(String urlEscudo) {
        this.urlEscudo = urlEscudo;
    }

    public int getRankUniver() {
        return rankUniver;
    }

    public void setRankUniver(int rankUniver) {
        this.rankUniver = rankUniver;
    }

    public int getAnosAcr() {
        return anosAcr;
    }

    public void setAnosAcr(int anosAcr) {
        this.anosAcr = anosAcr;
    }
}
