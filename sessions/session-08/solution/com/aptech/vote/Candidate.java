package com.aptech.vote;

public class Candidate {
    private final String name;
    private int votes = 0;
    public Candidate(String name) { this.name = name; }
    public void addVote() { votes++; }
    public int getVotes() { return votes; }
    public String getName() { return name; }
    @Override public String toString() { return name + ": " + votes; }
}
