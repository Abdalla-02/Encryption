# Encryption
a small program that encrypts/decryps a given text with ROT13 that rotates a letter by 13 places. I extended the idea and made also RotN (0≤N≤26) and decrypt a text with it

#### in the terminal write :
```
javac Encryption.java
```
##### for encrypting the text with ROT13 write:
```
java Encryption encrypt "The given Text"
```

##### for encrypting the text with ROTN write the number you need after rot(without spaces) : 
```
java Encryption encrypt rot6 "The given Text"
```

##### for decrypting a text that is encrypted with rotN and we don't know the N :
```
java Encryption decrypt "Pxgg wn axktnlzxyngwxg atlm, ptl wbxlxk Mxqm uxwxnmxm, atlm wn xgmpxwxk lxak obxex Fhxzebvadxbmxg tnlikhubxkm ngw wbk ynxgyngwsptgsbzfte Fnxee tgzxznvdm. Hwxk wn atlm wbx spxbmx Mxbetnyztux kbvambz zxehxlm."
```
It will give you an output that most likly to be the decryptions of your text
if it is right just enter 1 otherwise enter 2 for the next possible decryption
