public class Main {
    public static void main(String[] args) {
        String text = "abacabadabacaba";
        int k = 2;
        TMarkov markov = new TMarkov(text, k);
        
        System.out.println("Frequency of 'ab': " + markov.freq("ab"));
        System.out.println("Frequency of 'ab' followed by 'a': " + markov.freq("ab", "a"));
        System.out.println("Random event following 'ab': " + markov.rand("ab"));
        System.out.println("Generated sequence: " + markov.gen("ab", 20));
    }
}