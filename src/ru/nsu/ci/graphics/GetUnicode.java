package ru.nsu.ci.graphics;

class GetUnicode {
  public static void main(String[] args) {
      if (args.length < 1) return;
      for (String input: args) {
        for (int index = 0; index < input.length(); ++index) {
            final char c = input.charAt(index); 
            final String s = String.format ("\\u%04x", (int)c);
            System.out.print(s);
        }
        System.out.println();
      }
  }
}