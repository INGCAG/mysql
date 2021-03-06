package com.example.spring.mysql.controller;

import com.example.spring.mysql.model.Tweet;
import com.example.spring.mysql.repository.Tweets;
import com.example.spring.mysql.repository.TwitterUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping(path = "/mySQL/tweet")
public class CtrlTweet {
    @Autowired
    private Tweets tweetRepository;
    @Autowired
    private TwitterUsers twitterUsersRepository;

    @GetMapping(path = "/lst") // Map ONLY GET Requests
    public @ResponseBody
    Iterable<Tweet> listTweets() {
        // This returns a JSON or XML with the users
        return tweetRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tweet> getTweet(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Optional<Tweet> u = tweetRepository.findById(id);
        if (u.get() == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Tweet>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Tweet>(u.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createTweet(@RequestBody Tweet tweet, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Tweet " + tweet.getTweetInternalId());

        twitterUsersRepository.save(tweet.getUser());
        tweetRepository.save(tweet);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(tweet.getTweetInternalId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tweet> updateTweet(@PathVariable("id") long id, @RequestBody Tweet tweet) {
        System.out.println("Updating User " + id);
        Optional<Tweet> t = tweetRepository.findById(id);

        if (t.get() == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Tweet>(HttpStatus.NOT_FOUND);
        }

        Tweet updatedUser = new Tweet(t.get().getTweetId(), tweet.getExternalId(), tweet.getText()
                , tweet.getUnmodifiedtext(), tweet.getSource(), tweet.getUser(), tweet.getCreatedAt()
        , tweet.getFromUser(), tweet.getProfileImageUrl(), tweet.getToUserId(), tweet.getFromUserId()
        , tweet.getInReplyToStatusId(), tweet.getLanguageCode(), tweet.getRetweetCount(), tweet.getRetweeted()
        , tweet.getRetweetedStatus(), tweet.getRetweet(), tweet.getFavorited(), tweet.getFavoriteCount()
        , tweet.getInReplyToUserId(), tweet.getInReplyToScreenName());

        tweetRepository.save(updatedUser);
        return new ResponseEntity<Tweet>(updatedUser, HttpStatus.OK);
    }
    */

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tweet> deleteTweet(@PathVariable("id") long id) {
        System.out.println("Deleting User " + id);
        Optional<Tweet> u = tweetRepository.findById(id);

        if (u.get() == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Tweet>(HttpStatus.NOT_FOUND);
        }

        tweetRepository.delete(u.get());
        return new ResponseEntity<Tweet>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public ResponseEntity<Tweet> deleteAll() {
        System.out.println("Deleting All Users ");

        tweetRepository.deleteAll();
        return new ResponseEntity<Tweet>(HttpStatus.NO_CONTENT);
    }
}
