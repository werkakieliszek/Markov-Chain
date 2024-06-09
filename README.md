# Markov-Chain
Easy example of Markov Model implemented in Java

## Project Description

This project implements a simple Markov model in Java, specifically designed to generate sequences based on input text and a specified order k. The TMarkov class builds a transition map from the input text, calculates the frequencies of events, generates random events, and produces sequences of a specified length. This project can be useful for applications such as text prediction, where the goal is to generate text that follows the statistical properties of the input text.

## What is a Markov Model?

A Markov model is a stochastic model used to represent systems that transition from one state to another in a pseudo-random manner. The key characteristic of a Markov model is the Markov property, which states that the future state of the system depends only on the current state and not on the sequence of events that preceded it. This property simplifies the modeling and computation of complex systems.

## Usage

The `TMarkov` class provides methods to build a transition map from the input text, calculate frequencies of events, generate random events, and generate sequences.

### Example

```java
public class Main {
    public static void main(String[] args) {
        String text = "abacabadabacadadacaba";
        int k = 2;
        TMarkov markov = new TMarkov(text, k);
        
        System.out.println("Occurrences of 'ab': " + markov.freq("ab"));
        System.out.println("Occurrences of 'ab', followed by 'a': " + markov.freq("ab", "a"));
        System.out.println("Random event after 'ab': " + markov.rand("ab"));
        System.out.println("Generated sequence: " + markov.gen("ab", 10));
    }
}
