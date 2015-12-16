package com.pkm.trust.markmail.parser;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class MarkMailRssParser {
  public static void main(String[] args)
      throws IllegalArgumentException, FeedException, IOException {
    URL feedUrl = new URL("http://markmail.org/atom/thread:wwh3xf4ssm5oil7x");

    SyndFeedInput input = new SyndFeedInput();
    SyndFeed feed = input.build(new XmlReader(feedUrl));
    
    List<SyndEntry> feedEntries = feed.getEntries();
    for (SyndEntry feedEntry : feedEntries) {
      System.out.println(feedEntry.getAuthor() + ": " + feedEntry.getTitle());
    }
  }
}
