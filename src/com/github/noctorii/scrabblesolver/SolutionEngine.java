package com.github.noctorii.scrabblesolver;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SolutionEngine {
    private ScoringEngine scoringEngine;
    private Set<String> words;
    private Set<String> subwords;

    public SolutionEngine (Collection<String> words, ScoringEngine scoringEngine){
        this.scoringEngine = scoringEngine;
      
        this.words = new HashSet<String>(words);
        this.subwords = new HashSet<String>();
        for(String word : words) subindex(word);
    }

    private void subindex(String word) {
        index(word.substring(0, word.length()-1));
        index(word.substring(1, word.length()));
    }

    private void index(String word) {
        if(word.isEmpty() || subwords.contains(word)) return;
        subwords.add(word);
        subindex(word);
    }

    public Play solve (GameState state, Hand hand){
        return null;
    }
}
