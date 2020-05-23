class reverseWords{
  public static void reverse_words (char[] sentence) {
      //TODO: Write - Your - Code
      reverseLetters(sentence, 0, sentence.length - 1);
    
      int spaceIndex = 0;
      for (int i=0; i<= sentence.length; i++){
        if (i == sentence.length || sentence[i] == ' '){
          reverseLetters(sentence, spaceIndex, i-1);
          spaceIndex = i + 1;
        }
      }
  }
  public static void reverseLetters (char[] sentence, int left, int right){
    
    while (left < right){
      char temp = sentence[left];
      sentence[left] = sentence[right];
      sentence[right] = temp;
      left++;
      right--;
    }
  }

}  