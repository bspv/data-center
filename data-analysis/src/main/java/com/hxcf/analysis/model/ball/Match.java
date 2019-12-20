package com.hxcf.analysis.model.ball;

import javax.persistence.Id;
import java.util.Date;

public class Match {
    @Id
    private Integer id;

    private String league;

    private Integer leagueType;

    private String homeTeam;

    private String awayTeam;

    private String matchDay;

    private String matchTime;

    private String matchResult;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league == null ? null : league.trim();
    }

    public Integer getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(Integer leagueType) {
        this.leagueType = leagueType;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam == null ? null : homeTeam.trim();
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam == null ? null : awayTeam.trim();
    }

    public String getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(String matchDay) {
        this.matchDay = matchDay == null ? null : matchDay.trim();
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime == null ? null : matchTime.trim();
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult == null ? null : matchResult.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}