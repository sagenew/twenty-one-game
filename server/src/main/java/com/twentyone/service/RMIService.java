package com.twentyone.service;

import java.util.Map;

public interface RMIService {
    public String helloWorld();
    public Map<String,String> startNewGame();
    public Map<String, String> hit();
    public Map<String, String> stand();
}
