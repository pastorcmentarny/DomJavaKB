
 a regular expression is a sequence of characters defining a search pattern.
 : regex works on characters, not words. Concatenation is implied.
 The . (dot) character matches any single character. - c.t we would match anything ranging from cat to c0t or cAt
 
 The * (asterisk) character is a bit more difficult. It modifies the character preceding it and then matches zero or more characters of that. Yes, read that again, zero or more characters. For example, cat* would match cat, catt, cattttt but also ca.
 
 
 Anchors specify the position of the pattern with respect to the line. These are the two most important anchors:
 
 The ^ (caret) fixes your pattern to the beginning of the line. For example the pattern ^1 matches any line starting with a 1.
 The $ (dollar) fixes your pattern to the end of the sentence. For example, 9$ matches any line ending with a 9.
 
 Character sets are like [0..9] or *
 
 he * (asterisk) is a modifier. A modifier changes the meaning of the character preceding it. 
#Resources:
* https://www.janmeppe.com/blog/regex-for-noobs/