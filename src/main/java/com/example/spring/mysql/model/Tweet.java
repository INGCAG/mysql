package com.example.spring.mysql.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name="TWEETS")// This tells Hibernate to make a table out of this class
@Component
public class Tweet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_TWEET", nullable = false)
    private Long tweetId;

    @Column(name = "EXTERNAL_ID")
    private Long externalId;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "UNMODIFIED_TEXT")
    private String unmodifiedtext;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "TWEETER_USER_ID")
    private Long user;//reference

    @Column(name = "CREATE_AT")
    private Long createdAt;

    @Column(name = "FROM_USER")
    private String fromUser;

    @Column(name = "PROFILE_IMAGE_URL")
    private String profileImageUrl;

    @Column(name = "TO_USER_ID")
    private Long toUserId;//default(0)

    @Column(name = "FROM_USER_ID")
    private Long fromUserId;

    @Column(name = "IN_REPLY_TO_STATUS_ID")
    private Long inReplyToStatusId;//default(null)

    @Column(name = "LANGUAGE_CODE")
    private String languageCode;

    @Column(name = "RETWEETED_COUNT")
    private Long retweetCount;// default(0)

    @Column(name = "RETWEETED")
    private Boolean retweeted;//default(false)

    @Column(name = "RETWEETED_STATUS")
    private String retweetedStatus;//default(null)

    @Column(name = "RETWEET")
    private Boolean retweet;//default(false)

    @Column(name = "FAVORITED")
    private Boolean favorited;//default(false)

    @Column(name = "FAVORITE_COUNT")
    private Long favoriteCount;//default(0)

    @Column(name = "IN_REPLY_TO_USER_ID")
    private Long inReplyToUserId;//default(null)

    @Column(name = "IN_REPLY_TO_SCREEN_NAME")
    private String inReplyToScreenName;//default(null)

    public Long getTweetId() {
        return tweetId;
    }

    public Long getExternalId() {
        return externalId;
    }

    public String getText() {
        return text;
    }

    public String getUnmodifiedtext() {
        return unmodifiedtext;
    }

    public String getSource() {
        return source;
    }

    public Long getUser() {
        return user;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public Long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public Long getRetweetCount() {
        return retweetCount;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public String getRetweetedStatus() {
        return retweetedStatus;
    }

    public Boolean getRetweet() {
        return retweet;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public Long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public Tweet() {
    }

    public Tweet(Long tweetId) {
        this.tweetId = tweetId;
    }

    public Tweet(Long tweetId, Long externalId, String text, String unmodifiedtext, String source, Long user, Long createdAt, String fromUser, String profileImageUrl, Long toUserId, Long fromUserId, Long inReplyToStatusId, String languageCode, Long retweetCount, Boolean retweeted, String retweetedStatus, Boolean retweet, Boolean favorited, Long favoriteCount, Long inReplyToUserId, String inReplyToScreenName) {
        this.tweetId = tweetId;
        this.externalId = externalId;
        this.text = text;
        this.unmodifiedtext = unmodifiedtext;
        this.source = source;
        this.user = user;
        this.createdAt = createdAt;
        this.fromUser = fromUser;
        this.profileImageUrl = profileImageUrl;
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
        this.inReplyToStatusId = inReplyToStatusId;
        this.languageCode = languageCode;
        this.retweetCount = retweetCount;
        this.retweeted = retweeted;
        this.retweetedStatus = retweetedStatus;
        this.retweet = retweet;
        this.favorited = favorited;
        this.favoriteCount = favoriteCount;
        this.inReplyToUserId = inReplyToUserId;
        this.inReplyToScreenName = inReplyToScreenName;
    }
}
