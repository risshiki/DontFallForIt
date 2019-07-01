import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Arrays; 
import java.util.Collections; 
import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class iteration1sized extends PApplet {




PImage titleScreen;
PImage emailView;
PImage desktopBlank;
PImage tutorial;
PImage phoneScreen;
PImage phoneScreen2;
PImage phoneScreen3;
PImage phoneScreen4;
PImage easteregg;
PImage phoneAlert;
PImage notepad;
PImage phoneReplay;

PImage tutorial1;
PImage tutorial2;
PImage tutorial3;
PImage tutorial4;
PImage tutorial5;
PImage tutorial6;
PImage tutorial7;
PImage robinhood;
PImage robinhood2;
PImage robinhood3;
PImage ideo;
PImage ideo2;
PImage ideo3;

boolean onTitle = true;
boolean onDesktopBlank = false;
boolean onEmailView = false;
boolean tutorialView = false;
boolean alertView = false;
boolean phoneView = false;
boolean notepadView = false;
boolean easyCorrect = false;
boolean mediumCorrect = false;
boolean hardCorrect = false;
boolean replay = false;
boolean startTutorial = false;
boolean easter = false;

boolean trash = false;
boolean flag = false;
boolean forward = false;

int difficulty = 0;
int tutorialIndex = 0;

int currentEmail = 0;
int currentTutorialPoint = 0;

int score = 0;

String sender = "sender@address.com";
String subjectline = "Subject Line here, Subject Line here, Subject Line here";
String content = "Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content Content ";
int[] clicked = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
String[] senders10 = new String[]{sender+"1", sender+"2", sender+"3", sender+"4", sender+"5", sender+"6", sender+"7", sender+"8", sender+"8", sender+"10"};
String[] subjectline10 = new String[]{"1"+subjectline, "2"+subjectline, "3"+subjectline, "4"+subjectline, "5"+subjectline, "6"+subjectline, "7"+subjectline, "8"+subjectline, "9"+subjectline, "10"+subjectline};
String[] content10 = new String[]{"1"+content, "2"+content, "3"+content, "4"+content, "5"+content, "6"+content, "7"+content, "8"+content, "9"+content, "10"+content};
String[] content10desktop;

int simpleCount = 0;
int[] simpleAnswers = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

int[] playerAnswers = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
int[] easyAnswers = new int[]{3, 2, 3, 2, 3, 3, 2, 2, 3, 2};
int[] mediumAnswers = new int[]{2, 2, 2, 3, 3, 2, 3, 3, 2, 3};
int[] hardAnswers = new int[]{3, 3, 2, 2, 3, 2, 2, 3, 2, 3};

String[] tutorialText;
String[] tutorialText2;

String[] contentEasyDesktop;
String[] contentEasy;
String[] subjectsEasy;
String[] sendersEasy;

String[] contentMediumDesktop;
String[] contentMedium;
String[] subjectsMedium;
String[] sendersMedium;

String[] contentHardDesktop;
String[] contentHard;
String[] subjectsHard;
String[] sendersHard;


int [][] easyKCs = new int [][]{
  {}, 
  {1, 2}, 
  {}, 
  {1, 2}, 
  {}, 
  {}, 
  {1, 5}, 
  {1}, 
  {}, 
  {3}
};

int [][] mediumKCs = new int [][]{
  {1, 2, 3}, 
  {3, 5}, 
  {1, 2, 3, 5}, 
  {}, 
  {}, 
  {1, 2, 3, 5}, 
  {}, 
  {}, 
  {1}, 
  {}
};

int [][] hardKCs = new int [][]{
  {}, 
  {}, 
  {1, 2, 3, 5}, 
  {1, 5}, 
  {}, 
  {1, 3, 5}, 
  {3}, 
  {}, 
  {1, 3, 5}, 
  {}
};

PImage amazon;
PImage newyorker;
PImage sbux;
PImage amazonlogo;
PImage spotify;
PImage irs;
PImage instagram;
PImage linkedin;
PImage paypal;
//PImage
//PImage

//double pLStart = 0.3;
//double pTransit = 0.3; 
//double PGuess = 0.5;
//double PSlip = 0.05;

double pLStart = 0.3f;
double pTransit = 0.2f; 
double PGuess = 0.5f;
double PSlip = 0.1f;

double easyMastery = 0.8f;
double mediumMastery = 0.85f;
double hardMastery = 0.9f;


SoundFile file;
SoundFile correct;
SoundFile wrong;

  //You can modify anything in here. This is just a basic implementation.
  public void setup()
{
  file = new SoundFile(this, "merged_3.mp3");
  file.amp(0.75f);
  file.loop();
  
  correct = new SoundFile(this, "correct.mp3");
  correct.amp(0.5f);
  wrong = new SoundFile(this, "wrong.mp3");
  wrong.amp(0.5f);
  //int [] check = new int [] {0, 0, 0, 0, 0, 1, 1, 0, 1, 1};
  //double thresholdCheck = BKT(pLStart, pTransit, PGuess, PSlip, check);
  //System.out.println(thresholdCheck);
  
  titleScreen = loadImage("titlescreen.png");
  desktopBlank = loadImage("desktop-blank.png");
  emailView = loadImage("emailview.png");
  tutorial = loadImage("tutorial.png");
  phoneScreen = loadImage("phonescreen.png");
  phoneScreen2 = loadImage("phonescreen2.png");
  phoneScreen3 = loadImage("phonescreen3.png");
  phoneScreen4 = loadImage("phonescreen4.png");
  phoneReplay = loadImage("replay.png");
  phoneAlert = loadImage("phone-alert.png");
  notepad = loadImage("notepad.png");
  easteregg = loadImage("easteregg.png");

  tutorial1 = loadImage("Tutorial1.png");
  tutorial2 = loadImage("Tutorial2.png");
  tutorial3 = loadImage("Tutorial3.png");
  tutorial4 = loadImage("Tutorial4.png");
  tutorial5 = loadImage("Tutorial5.png");
  tutorial6 = loadImage("Tutorial6.png");
  tutorial7 = loadImage("Tutorial7.png");
  robinhood = loadImage("robinhood.png");
  robinhood2 = loadImage("robinhood2.png");
  robinhood3 = loadImage("robinhood3.png");
  ideo = loadImage("ideo.png");
  ideo2 = loadImage("ideo2.png");
  ideo3 = loadImage("ideo3.png");
  
  
  tutorialText = loadStrings("tutorialText.txt");
  tutorialText2 = loadStrings("tutorialText2.txt");

  amazon = loadImage("amazon.png");
  newyorker = loadImage("newyorker.png");
  sbux = loadImage("sbux.png");
  amazonlogo = loadImage("amazonlogo.png");
  spotify = loadImage("spotify.png");
  irs = loadImage("irs.png");
  instagram = loadImage("instagram.png");
  linkedin = loadImage("linkedin.png");
  paypal = loadImage("paypal.png");

  contentEasyDesktop = loadStrings("content-easy.txt");
  contentEasy = new String[]{"Chad,\nWhen you get a chance, I wanted to sit down with you and go over my meeting notes from the conference last week. Not sure if you and I are on the same page. \nPing me when you can. My number is 679-948-4023, or just use Messenger. \n\nThanks, \n\nThomas \nVice President of Finance \nEight Bit Inc. ", "My beloved fellowship \n\n I know you will be surprised to read from me, but please this letter is a request from in dire need of assistance. I am Mrs. Gerlinde SIFFORD, from South Africa and require assistance to donate the sum of ($2,950,000) inherited from my late husband into your personal/company account. \n \n Before his death, he was a former South Africa envoy who worked with our Embassy in Accra Ghana for nine years before he died on 26th December 2015 I am holding $2,950,000 which he deposited in a private security company in Accra, Ghana. Recently, my doctor told me that I would not last for the next four months due to cancer and leave this fund to orphange since we didn’t have any child. \n \n Having known my condition I decided to donate it into your care to utilize to help the orphans, old age home and other people that need financial assistance. Contact me for more information via my e-mail: slifford62@saintly.com  So that I will forward you all the procedure about this fund. \n \n With love, hoping to receive your response immediately, \n \n Mrs. Gerlinde SIFFORD written from hospital bed", "Hi Chad, your package will arrive: Friday April 12", "Greetings to you my friend,\n\nI know this will come to you as a surprise because you do not know me. \nI am John Alison I work in Central Bank of Nigeria, packaging and courier department.\n\nI got your contact among others from a search on the internet and I was inspired to seek your co-operation, I want you to help me clear this consignment that is already in the Europe which I shipped through our CBN accredited to courier agent. The content of the package is $20,000,000.00 all in $100 bills, but he courier company does not know that the consignment contains money. \n\nAll I want you to do for me now is give me your mailing address, your private phone and fax number, and I believe that at the end of teh day your will have 50% and 50% will be for me. My identity must not be revealed to anybody. \n\nIf this arrangement is okay by you, you can call\n\nPhone: 234 8028776685\nEmail: john_alison444@yahoo.com", "Content TBD", "Time for Coffee, more TBD", "Hello please the escrow just emailed me that you need to send the funds via wire, They dont want to accept check due to a check check issues they just had, You will need to go to your bank to send the wire tomorrow so they can receive the funds before the closing, Please get back to me now so i can send you the wire information.", "Dear Customer, \nWe regret to inform you that your account has been restricted. \nTo continue using our service, please download the file attached to this email and update your login information. \n\n© GlobalPaymentsInc\nAttachment: update 2816.html (7 KB). ", "Chad,  \nThe conference last night with Japan went well. Some Skype issues at first, but we ironed it \nout. I’ve attached some meeting notes that Janet took, but I’d like to meet with you asap\nabout next steps.\n\nTalk soon, \n\nThomas \nVice President of Finance \nEight Bit Inc. ", "Protect your home and family today \nWith Vivint.SmartHome Security\n\nGet a free quote here! \n\nSecure your home from anywhere. \nGet a free quote. \n\nDon’t wan’t to receive email updates? Unsubscribe here. "};
  subjectsEasy = loadStrings("subjects-easy.txt");
  sendersEasy = loadStrings("senders-easy.txt");

  contentMediumDesktop = loadStrings("content-medium.txt");
  contentMedium = new String[]{"Due to a system error you were double charges for your last order, A refund process was initiated but could not be completed due to errors in your billing information. \n\nREF CODE: 2550CGE\n\nYou are required to provide us a valid billing address. \n\nClick Here to Update Your Address. \n\nAfter your information has been validated you should get your refund within 3 business days. \n\nWe hope to see you again soon. \nAmazon.com ", "Dear Chad, \n\n REcently, there’s been activity in your account that seems unusual compared to your normal account activities. \n This is detail your activity : \n -Location: 36 Paraduta STreet , Carabobo, Spain. \n -IP address: 89.22.34.5.333 (89.22.34.5.333.net-uno.net)\n -Time : Thursday, 12 October 2017, 02:45:02 AM \n -Browser : UCWEB/2.0 (Linux; U, OPEra Mini/7.5.3433/0383; en-US; Micromax Q334 Build/LMK471)\n -PLatform : Windows NT 6.1\n\n*YOUR ACCOUNT HAS BEEN DISABLE TEMPORARY\n\nIf you do not do this activity, maybe someone who has access your account ,To view the details of your case please download & read (Billing_Agreement_11102017.pdf)in attachment.", "Dear Employee,\n\nYou have verify updates to your account. You can do this from your Staff Portal. \n\nClick here to read\n\nThank You\nInformation Technology Services", "Hello Chad! \n\nI have some extraneous documents I need to go over with you regarding the Mckinley account. It’s mostly just some signatures and other little clerical things. I’m going to be out of the office on Wednesday for a personal day, so shoot me a message at 374-498-3909 if we can’t meet before then. \n\nThanks, \nJared Carp \nHead Accountant\nEight Bit Inc.", "No need to worry, you can reset your Spotify password by clicking the link below:\n\nhttps://www.spotify.com/us/email-reset/#NApiCkoKDVNwb3RpZnktdXNlcnMSC2tlbmRyaWNrdHNlGgOoAQElGWk5VzIiCggGPHvUlSY7jBIWqZYO3zDb5rUM4dHkfvFVb_iweC9eKhIUc_OJv6v9XxpVv70YwSox7OeDMUU\n\nYour username is: ChadTman\nIf you didn’t request a password reset, feel free to delete this email and carry on enjoying your music!\n\nAll the best, \nThe Spotify Team", "Dear Tax Payer, \n\nWe’ve noticed your account information is missing or incorrect. \nWe need to verify your account information to file your Tax Refund. \nPlease follow this link to verify your information.\n\nThanks,\nIRS Team\n2019 IRS All Rights Reserved\n\nIMPORTANT NOTE: If you receive this message in your spam or junk it is a result of your network provider. Please move this message to your inbox and follow the instruction above. ", "linkedin content tbd", "Hi eightbitinc,\nYou may have seen a notification or an email a few weeks ago telling you about our upcoming changes to our Terms and Data Policy. Your Instagram experience isn't changing, and you still own your photos and videos. We are giving you better ways to access your data and understand how it's used.\n\nWe wanted to let you know that by continuing to use Instagram on or after July 14, 2018, you're agreeing to these updates. You can see some information about our changes here.\n\n© Instagram, 1601 Willow Road, Menlo Park, CA 94025, USA", "Smarty’s Club Catering Services.\n\nUnfortunately the delivery of your order CO-00838737283 was cancelled since the specified address of the recipient was not correct. You are recommended to complete this form and send it back with your reply to us. \nPLease do this within the period of one week - If we don’t get you timely reply you will be paid your money back less than 21% of what you originally booked for. \n\n1998-2019 \nSmarty’s Club Catering Services\nAll rights reserved. ", "Hey Chad, \nI think you might want to look into this. Our company’s shares dropped by 12% this morning because of this news story. We need to schedule a press conference ASAP and figure out a way to deal with this mess as soon as we can, else our stocks will plummet very soon.\n\nhttps://www.cnn.com/8-bit-inc-employee-found-saving-child-pornography-on-email-servers\n\nBest, \nBryan Wilkens\nExecutive Manager\nEight Bit Inc."};
  subjectsMedium = loadStrings("subjects-medium.txt");
  sendersMedium = loadStrings("senders-medium.txt");

  contentHardDesktop = loadStrings("content-hard.txt");
  contentHard = new String[]{"Hey Chad, \nHope you are well. I’m scheduling conferences with every employee in your department in to talk over this past pay period. When you get a chance, please sign up for a slot on this spreadsheet. \n\nhttps://docs.google.com/spreadsheets/d/1hKuti1KXs3cjeKeDLqS_lvk4_BI-BtWLG5AQQAWUNB4/edit#gid=0\n\nBest, \nStephanie Lee \nHuman Resources\nEight Bit Inc. ", "Hey Chad, \nAre you in the office this afternoon? I need to talk to you, preferably as soon as possible. There are some issues with our last print ad and I’m worried about how to move forward. \nI’ll stop by your office after lunch to check in, but let me know your availability if you get this before. \n\nBest, \nJenny", "We need your help\n\nYour account has been suspended, as an error was detected in your informations. The reason for the error is not certain, but for security reasons, we have suspended your account temporarily \n\nWe need you to update your informations for further use of your PayPal account.", "Hello Chad, \nAre you in the office? \nThanks, \nThomas Marks", "Confirm your card\n\nHello Chad,\nYou linked your debit or credit card to your PayPal account on . To make sure the card is yours, we made a small charge to it that you'll need to confirm (and we'll refund the money to your PayPal account when you're done).\nThe charge creates a unique 4-digit code on your card statement. If you don't see the charge right away, don't worry - sometimes it takes a few days to show up. If you can't check your card statement online, check your paper statement when it comes in the mail (this can take up to 30 days). You will find the charge from PayPal with a 4-digit code.\nWhen that's done, you'll be able to pay safer online with your card through PayPal - without ever exposing your financial information to sellers.\n\nSincerely,\nPayPal ", "Kindly find the attached and Confirm accept. \nRegards, \n\nSent from my Iphone\n\nView Slideshow \nDownload all as zip (1). ", "Chad, \nPlease do you have a moment? Am tied up in a meeting and there is something I need you to take care of. We have a pending invoice from our Endor. I have asked them to email me a copy of the invoice. I will be highly appreciative if you can handle it before the close of banking transactions for today.I can’t take calls now so an email will be fine. \n\nRobert. ", "Hi Chad, \nI need to pick up my daughter from daycare on Friday. My husband is out on a business trip and he usually handles Fridays. Is it alright if I duck out about an hour early? \n\nAlso, finished compiling the documents for the recruitment packet. They are attached, and here’s a google doc link as well. \n\nhttps://docs.google.com/document/d/1e9FI2ghj2PMWF8c9Jtk1iOJ1HREpiVGCWwVlKDpE/edit\n\nBest, \nStephanie Lee \nHuman Resources\nEight Bit Inc. ", "Dear Valued User, \nYour Account security validation has expired. This maybe as a result of wrong or incomplete data entered during the last update. \nIt’s strongly required that you should validate your Account Ownership Security, to avoid service suspension. \nLogin to Eight Bit Inc email \n\nWe apologize for any inconvenience, \nSincerely, \nEight Bit Inc. Security Department ", "Hello Chad, \nFor the corporate retreat scheduled on the 28th of August, we are currently co-ordinating meal arrangements with the caterer. Please fill out this survey and let us know about your dietary preferences. This form will expire on May 30th. \n\nhttps://bit.ly/2ICuve8\n\nBest, \nElizabeth Chateau\nHR Executive\nEight Bit Inc.  "};
  subjectsHard = loadStrings("subjects-hard.txt");
  sendersHard = loadStrings("senders-hard.txt");

  //System.out.println(contentEasy[0]);


  orientation(LANDSCAPE); //can also be PORTRAIT -- sets orientation on android device
   //Sets the size of the app. You should modify this to your device's native size. Many phones today are 1080 wide by 1920 tall.
  textFont(createFont("Arial", 12)); //set the font to arial 24
  noStroke(); //my code doesn't use any strokes.
}

//You can modify anything in here. This is just a basic implementation.

public void keyPressed()
{
    
    if (key == 'u')
    {
      //System.out.println("Key code pressed: " + keyCode);
      score = 10;
      //if (difficulty == 1) playerAnswers = easyAnswers; clicked = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; 
      //if (difficulty == 2) playerAnswers = mediumAnswers; clicked = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; 
      //if (difficulty == 3) playerAnswers = hardAnswers; clicked = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; 
      
      simpleAnswers = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; 
      clicked = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; 
    }
    
}


public void draw()
{  
  if (difficulty == 0 && startTutorial == true){
    drawTutorial1();
  }

  if (difficulty == 1) {
    senders10 = sendersEasy;
    subjectline10 = subjectsEasy;
    content10 = contentEasy;
    content10desktop = contentEasyDesktop;
  }

  if (difficulty == 2) {
    senders10 = sendersMedium;
    subjectline10 = subjectsMedium;
    content10 = contentMedium;
    content10desktop = contentMediumDesktop;
  }

  if (difficulty == 3) {
    senders10 = sendersHard;
    subjectline10 = subjectsHard;
    content10 = contentHard;
    content10desktop = contentHardDesktop;
  }

  if (difficulty == 4) {
    onTitle = true;
    onDesktopBlank = onEmailView = tutorialView = alertView = phoneView = easyCorrect = mediumCorrect = hardCorrect = false;
    difficulty = 0;
    tutorialIndex = 0;
    currentEmail = 0;
    currentTutorialPoint = 0;
    score = 0;
  }

  if (onTitle == true) {
    image(titleScreen, 0, 0, 1280, 720);
  }

  if (onDesktopBlank == true) {
    drawDesktop();
    drawDesktopText();
    drawScoreBox();
  }
  if (tutorialView == true) {
    drawTutorial();
    drawTutorialText();
    drawTutorialText2();
  }

  if (notepadView == true) {
    drawNotepad();
  }

  if (onEmailView == true) {
    drawEmailView();
    drawEmailText();
    drawAdditions();
    if (onEmailView == true && easyCorrect == true) drawErrors(1, currentEmail);
    if (onEmailView == true && mediumCorrect == true) drawErrors(2, currentEmail);
    if (onEmailView == true && hardCorrect == true) drawErrors(3, currentEmail);
  }
  
  if (phoneView == true) {
    if (replay == true){
      drawPhoneReplay();
    }
    else{
      if (difficulty == 0) drawPhone();
      if (difficulty == 1) drawPhone2();
      if (difficulty == 2) drawPhone3();
      if (difficulty == 3) drawPhone4();
    }
  }
  
  if (easter == true){
    drawEaster();
  }
  
  if (startTutorial == true){
    if (tutorialIndex == 1) drawTutorial1();
    if (tutorialIndex == 2) drawTutorial2();
    if (tutorialIndex == 3) drawTutorial3();
    if (tutorialIndex == 4) drawTutorial4();
    if (tutorialIndex == 5) drawTutorial5();
    if (tutorialIndex == 6) drawTutorial6();
    if (tutorialIndex == 7) drawTutorial7();
    if (tutorialIndex == 8) drawRobinhood();
    if (tutorialIndex == 9) drawRobinhood2();
    if (tutorialIndex == 10) drawRobinhood3();
    if (tutorialIndex == 11) drawIdeo();
    if (tutorialIndex == 12) drawIdeo2();
    if (tutorialIndex == 13) drawIdeo3();
  }
}

public void drawRobinhood(){
  image(robinhood, 0,0,1280,720);
}

public void drawRobinhood2(){
  image(robinhood2, 0,0,1280,720);
}

public void drawRobinhood3(){
  image(robinhood3, 0,0,1280,720);
}

public void drawIdeo(){
  image(ideo, 0,0,1280,720);
}

public void drawIdeo2(){
  image(ideo2, 0,0,1280,720);
}

public void drawIdeo3(){
  image(ideo3, 0,0,1280,720);
}

public boolean didMouseClick(float x, float y, float w, float h) //simple function to do hit testing
{
  return (mouseX > x && mouseX < x+w && mouseY > y && mouseY < y+h); //check to see if it is in button bounds
}


public void mousePressed()
{
  float ydiff = 29;

  ///////////////////////////////////
  ///////// Desktop View //////////////
  ///////////////////////////////////

  if (onDesktopBlank == true) {
    if (didMouseClick(1069, 452, 211, 173))
    {
      onDesktopBlank = false;
      tutorialView = true;
    }

    if (didMouseClick(1192, 625, 90, 95))
    {
      onDesktopBlank = false;
      tutorialView = true;
    }

    if (didMouseClick(923, 635, 254, 88))
    {
      onDesktopBlank = false;
      notepadView = true;
    }


    for (int i = 0; i < 10; i++) {
      if (didMouseClick(348, 95 + ydiff*i, 671, 30))
      {
        //System.out.println(i);
        if (clicked[i] == 0) {
          clicked[i] = 1;
          currentEmail = i;
          onDesktopBlank = false;
          onEmailView = true;
        }
      }
    }
  }

  ///////////////////////////////////
  ///////// Tutorial View //////////////
  ///////////////////////////////////

  if (tutorialView == true) {
    if (didMouseClick(21, 19, 90, 40))
    {
      onDesktopBlank = true;
      tutorialView = false;
      currentTutorialPoint = 0;
    }
    if (didMouseClick(1083, 359, 40, 42) && currentTutorialPoint < tutorialText.length-1)
    {
      currentTutorialPoint += 1;
    }
    if (didMouseClick(163, 359, 26, 42) && currentTutorialPoint > 0)
    {
      currentTutorialPoint -= 1;
    }
  }

  ///////////////////////////////////
  ///////// Notepad View //////////////
  ///////////////////////////////////

  if (notepadView == true) {
    if (didMouseClick(21, 19, 90, 40))
    {
      onDesktopBlank = true;
      notepadView = false;
      currentTutorialPoint = 0;
    }
  }

  ///////////////////////////////////
  ///////// Email View //////////////
  ///////////////////////////////////

  if (easyCorrect || mediumCorrect || hardCorrect == true) {
    if (didMouseClick(0, 0, 1280, 720)) {
      easyCorrect = mediumCorrect = hardCorrect = false;
    }
  }

  if (onEmailView == true) {
    if (didMouseClick(88, 86, 92, 87)) {
      //back
      onEmailView = false;
      onDesktopBlank = true;
      //playerAnswers[currentEmail] = 1;
      clicked[currentEmail] = 0;
    }

    //tutorial
    if (didMouseClick(1130, 360, 150, 165)) {
      clicked[currentEmail] = 0;
      onEmailView = false;
      tutorialView = true;
    }

    //notepad
    if (didMouseClick(1077, 574, 203, 147)) {
      clicked[currentEmail] = 0;
      onEmailView = false;
      notepadView = true;
    }

    if (didMouseClick(88, 191, 92, 87)) {
      //Flag
      if (playerAnswers[currentEmail] == 0){ 
        playerAnswers[currentEmail] = 2;
        if (difficulty == 1) {
          if (easyAnswers[currentEmail] == 2) score += 1; simpleAnswers[simpleCount] = 1; 
        } else if (difficulty == 2) {
          if (mediumAnswers[currentEmail] == 2) score += 1; simpleAnswers[simpleCount] = 1; 
        } else if (difficulty == 3) {
          if (hardAnswers[currentEmail] == 2) score += 1; simpleAnswers[simpleCount] = 1; 
        }
      }
      
      if (difficulty == 1) {
        if (easyAnswers[currentEmail] != 2) {easyCorrect = true; wrong.play(); simpleAnswers[simpleCount] = 0; }
        else backToDesktop();
      } else if (difficulty == 2) {
        if (mediumAnswers[currentEmail] != 2) {mediumCorrect = true; wrong.play(); simpleAnswers[simpleCount] = 0; }
        else backToDesktop();
      } else if (difficulty == 3) {
        if (hardAnswers[currentEmail] != 2) {hardCorrect = true; wrong.play(); simpleAnswers[simpleCount] = 0; }
        else backToDesktop();
      }
    }

    if (didMouseClick(88, 297, 92, 87)) {
      //star
      if (playerAnswers[currentEmail] == 0){ 
        playerAnswers[currentEmail] = 3;
        if (difficulty == 1) {
          if (easyAnswers[currentEmail] == 3) score += 1; simpleAnswers[simpleCount] = 1; 
        } else if (difficulty == 2) {
          if (mediumAnswers[currentEmail] == 3) score += 1; simpleAnswers[simpleCount] = 1; 
        } else if (difficulty == 3) {
          if (hardAnswers[currentEmail] == 3) score += 1; simpleAnswers[simpleCount] = 1; 
        }
      }
      if (difficulty == 1) {
        if (easyAnswers[currentEmail] != 3){easyCorrect = true;wrong.play(); simpleAnswers[simpleCount] = 0; }
        else backToDesktop();
      } else if (difficulty == 2) {
        if (mediumAnswers[currentEmail] != 3){mediumCorrect = true;wrong.play(); simpleAnswers[simpleCount] = 0; }
        else backToDesktop();
      } else if (difficulty == 3) {
        if (hardAnswers[currentEmail] != 3){hardCorrect = true;wrong.play(); simpleAnswers[simpleCount] = 0; }
        else backToDesktop();
      }
    }
  }


  ///////////////////////////////////
  ///////// Alert View //////////////
  ///////////////////////////////////

  if (alertView == true) {    
    if (didMouseClick(34, 460, 265, 260)) {
      alertView = false;
      onDesktopBlank = false;
      int [] answerCheck = new int [] {0,0,0,0,0,0,0,0,0,0};
      
      if (difficulty == 1){
        //easyAnswers
        for (int i = 0; i < easyAnswers.length; i++){
          if (easyAnswers[i] == playerAnswers[i]) answerCheck[i] = 1;
          else answerCheck[i] = 0;
        }
      }
      if (difficulty == 2){
        //easyAnswers
        for (int i = 0; i < easyAnswers.length; i++){
          if (mediumAnswers[i] == playerAnswers[i]) answerCheck[i] = 1;
          else answerCheck[i] = 0;
        }
      }
      if (difficulty == 3){
        //easyAnswers
        for (int i = 0; i < easyAnswers.length; i++){
          if (hardAnswers[i] == playerAnswers[i]) answerCheck[i] = 1;
          else answerCheck[i] = 0;
        }
      }
      //System.out.println(Arrays.toString(answerCheck));
      System.out.println(Arrays.toString(simpleAnswers));
      double thresholdCheck = BKT(pLStart, pTransit, PGuess, PSlip, simpleAnswers);
      
      System.out.println(thresholdCheck);
      System.out.println(easyMastery);
      System.out.println(thresholdCheck >= easyMastery);
      
      if (difficulty == 1){
        if (thresholdCheck <= easyMastery){
          replay = true;
        }
        else replay = false;
      }
      else if (difficulty == 2){
        if (thresholdCheck <= mediumMastery){
          replay = true;
        }
        else replay = false;
      }
      else if (difficulty == 3){
        if (thresholdCheck <= hardMastery){
          replay = true;
        }
        else replay = false;
      }
      
      
      phoneView = true;
      
    }
  }

  if (phoneView == true) {
    if (didMouseClick(1001, 376, 104, 75)) {
      phoneView = false;
      playerAnswers = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      clicked = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      if (difficulty == 0) startTutorial = true;
      else onDesktopBlank = true;
      if (replay == false) difficulty += 1; score = 0; simpleCount = 0;
    }
    
    if (didMouseClick(1001, 488, 104, 75)) {
      easter = true;
      phoneView = false;
    }
  }
  
  if (easter == true){
    if (didMouseClick(1001, 376, 104, 75)) {
      easter = false;
      playerAnswers = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      clicked = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      if (difficulty == 0) startTutorial = true;
      else onDesktopBlank = true;
      if (replay == false) difficulty += 1; score = 0;
    }
  }

  if (onTitle == true) {
    if (didMouseClick(0, 0, 1280, 720))
    {
      onTitle = false;
      phoneView = true;
      //startTutorial = true;
      //onDesktopBlank = true;
    }
  }
  
  if (startTutorial == true){
    if (didMouseClick(0, 0, 1280, 720)){
      tutorialIndex += 1;
    }
    if (tutorialIndex == 14){
      startTutorial = false;
      onDesktopBlank = true;
    }
  }
}

public void backToDesktop() {
  onEmailView = false;
  onDesktopBlank = true;
  clicked[currentEmail] = 1;
  correct.play();
  simpleCount += 1;
}

public void drawFalsePositive() {
  fill(70, 135, 228);
  rect(884, 110, 214, 110);
  textFont(createFont("Arial", 20)); 
  fill(255, 255, 255);
  text("This Email is not a scam!", 910, 135, 163, 62);
}

public void drawErrors(int difficulty, int currentEmail) {
  fill(50, 130);
  rect(0, 0, 1280, 720);
  if (difficulty == 1) {
    int[] current = easyKCs[currentEmail];
    if (current.length > 0) {
      for (int i = 0; i < current.length; i++) {
        if (current[i] == 1) drawSenderAddress();
        if (current[i] == 2) drawRequesting();
        if (current[i] == 3) drawSpelling();
        if (current[i] == 4) drawUrgent();
        if (current[i] == 5) drawValidation();
      }
    } else {
      drawFalsePositive();
    }
  }

  if (difficulty == 2) {
    int[] current = mediumKCs[currentEmail];
    if (current.length > 0) {
      for (int i = 0; i < current.length; i++) {
        if (current[i] == 1) drawSenderAddress();
        if (current[i] == 2) drawRequesting();
        if (current[i] == 3) drawSpelling();
        if (current[i] == 4) drawUrgent();
        if (current[i] == 5) drawValidation();
      }
    } else {
      drawFalsePositive();
    }
  }

  if (difficulty == 3) {
    int[] current = hardKCs[currentEmail];
    if (current.length > 0) {
      for (int i = 0; i < current.length; i++) {
        if (current[i] == 1) drawSenderAddress();
        if (current[i] == 2) drawRequesting();
        if (current[i] == 3) drawSpelling();
        if (current[i] == 4) drawUrgent();
        if (current[i] == 5) drawValidation();
      }
    } else {
      drawFalsePositive();
    }
  }
}

public void drawDesktop()
{
  image(desktopBlank, 0, 0, 1280, 720);
}

public void drawPhone()
{
  image(phoneScreen, 0, 0, 1280, 720);
}

public void drawPhone2()
{
  image(phoneScreen2, 0, 0, 1280, 720);
}

public void drawPhone3()
{
  image(phoneScreen3, 0, 0, 1280, 720);
}

public void drawPhone4()
{
  image(phoneScreen4, 0, 0, 1280, 720);
}

public void drawPhoneReplay()
{
  image(phoneReplay, 0, 0, 1280, 720);
}

public void drawTutorial()
{
  image(tutorial, 0, 0, 1280, 720);
}

public void drawNotepad()
{
  image(notepad, 0, 0, 1280, 720);
}


public void drawTutorialText() {
  fill(50);
  textFont(createFont("Arial", 20)); //set the font to arial 20
  text(tutorialText[currentTutorialPoint], 205, 201, 390, 435);
}

public void drawTutorialText2() {
  fill(50);
  textFont(createFont("Arial", 20)); //set the font to arial 20
  text(tutorialText2[currentTutorialPoint], 680, 201, 390, 435);
}

public void drawEmailView()
{
  image(emailView, 0, 0, 1280, 720);
}

public void drawEmailText() {
  int blue = color(170, 203, 255, 0);
  fill(blue);
  rect(88, 86, 92, 87);
  rect(88, 191, 92, 87);
  rect(88, 297, 92, 87);


  //rect(362, 224, 481, 29);
  //rect(362, 279, 481, 29);
  //rect(362, 359, 531, 305);

  fill(50);
  textFont(createFont("Arial", 15)); 
  text(subjectline10[currentEmail], 350, 130, 550, 29 );
  text(senders10[currentEmail], 350, 157, 550, 29);
  text("Chad Tillman <chad@eightbitinc.com>", 350, 184, 550, 29);
  text(content10[currentEmail], 322, 234, 740, 471);
}

public void drawDesktopText() {
  int checkAllClicked = 0;
  for (int i = 0; i < 10; i++) {
    if (clicked[i] == 1) {
      checkAllClicked += 1;
    }
  }

  if (checkAllClicked == 10) {
    //clicked = new int[]{0,0,0,0,0,0,0,0,0,0};
    image(phoneAlert, 0, 0, 1280, 720);
    fill(255, 255, 255);
    textFont(createFont("Arial", 16));
    if (difficulty == 1) text("That wasn’t too bad! But looks like you’re getting a text from your boss! ", 40, 310, 157, 100);
    if (difficulty == 2) text("Whew, that was a bit harder. Wait, another text?", 40, 310, 157, 100);
    if (difficulty == 3) text("Some of those were tricky! One more text?", 40, 310, 157, 100);
    alertView = true;
  }

  textFont(createFont("Arial", 12));
  float ydiff = 29;

  for (int i = 0; i < 10; i++) {
    int blue = color(170, 203, 255, 0);
    fill(blue);
    rect(348, 95 + ydiff*i, 671, 28);

    int grayedout = color(185, 185, 185, 100);
    fill (grayedout);
    if (clicked[i] == 1) {
      rect(348, 95 + ydiff*i, 671, 28);
    }
    fill(50);
    noStroke(); //my code doesn't use any strokes.
    if (senders10[i].length() > 18) {
      text(senders10[i].substring(0, 18) + " ...", 387, 113 + i*ydiff);
    } else {
      text(senders10[i], 387, 113 + i*ydiff);
    }

    if (subjectline10[i].length() > 36) {
      text(subjectline10[i].substring(0, 36) + " ...", 523, 113 + i*ydiff);
    } else {
      text(subjectline10[i], 523, 113 + i*ydiff);
    }

    fill(135, 135, 135);
    if (content10desktop[i].length() > 36) {
      text(content10desktop[i].substring(0, 36) + " ...", 752, 113 + i*ydiff);
    } else {
      text(content10desktop[i], 752, 113 + i*ydiff);
    }
  }
}

public void drawSenderAddress()
{
  int yellow = color(255, 239, 118);
  fill(yellow);
  rect(628, 139, 214, 102);
  fill(50);
  textFont(createFont("Arial", 15)); 
  text("Double check the Sender Address!", 647, 165, 200, 75);
}

public void drawRequesting()
{
  int yellow = color(253, 211, 29);
  fill(yellow);
  rect(886, 204, 220, 102);
  fill(50);
  textFont(createFont("Arial", 15)); 
  text("Beware of Emails Requesting Personal Information.", 900, 230, 200, 75);
}

public void drawSpelling()
{
  int orange = color(253, 175, 29);
  fill(orange);
  rect(896, 360, 214, 102);
  fill(255, 255, 255);
  textFont(createFont("Arial", 15)); 
  text("Watch out for Spelling and Grammar!", 914, 385, 200, 100 );
}

public void drawUrgent()
{
  int orange = color(253, 132, 29);
  fill(orange);
  rect(798, 510, 214, 102);
  fill(255, 255, 255);
  textFont(createFont("Arial", 15)); 
  text("Beware of emails requesting Urgent Action", 816, 540, 200, 75);
}

public void drawValidation()
{
  int red = color(253, 72, 29);
  fill(red);
  rect(534, 586, 214, 102);
  fill(255, 255, 255);
  textFont(createFont("Arial", 15)); 
  text("Double check Attachments and Link of validation!", 558, 610, 200, 75);
}

public void drawAdditions() {
  if (difficulty == 1) {
    if (currentEmail == 2) {
      image(amazon, 322, 278);
    }
    if (currentEmail == 4) {
      image(newyorker, 322, 232);
    }
    if (currentEmail == 5) {
      image(sbux, 322, 232);
    }
  }

  if (difficulty == 2) {
    if (currentEmail == 0) {
      image(amazonlogo, 322, 575);
    }
    if (currentEmail == 4) {
      image(spotify, 322, 490);
    }
    if (currentEmail == 5) {
      image(irs, 322, 525);
    }
    if (currentEmail == 6) {
      image(linkedin, 322, 232);
    }
    if (currentEmail == 7) {
      image(instagram, 322, 490);
    }
  }

  if (difficulty == 3) {
    if (currentEmail == 2) {
      image(paypal, 322, 425);
    }
    if (currentEmail == 4) {
      image(paypal, 315, 600);
    }
  }
}


public void drawTutorial1()
{
  image(tutorial1, 0, 0, 1280, 720);
}

public void drawTutorial2()
{
  image(tutorial2, 0, 0, 1280, 720);
}

public void drawTutorial3()
{
  image(tutorial3, 0, 0, 1280, 720);
}

public void drawTutorial4()
{
  image(tutorial4, 0, 0, 1280, 720);
}

public void drawTutorial5()
{
  image(tutorial5, 0, 0, 1280, 720);
}

public void drawTutorial6()
{
  image(tutorial6, 0, 0, 1280, 720);
}

public void drawTutorial7()
{
  image(tutorial7, 0, 0, 1280, 720);
}

public void drawEaster(){
  image(easteregg, 0, 0, 1280, 720);
}

public void drawScoreBox()
{
  fill(255,255,255);
  rect(1122,17,135,50);
  textFont(createFont("Arial", 20));
  fill(20);
  String scoreText = "Score: " + Integer.toString(score) + " /10";
  text(scoreText, 1131, 45);
}

/////////////////////////////////////
//////////// BKT ////////////////////
/////////////////////////////////////


public double BKT(double plStart, double pTransit,double PGuess, double PSlip, int [] responses)
{
    return knowledgeTrace(plStart, pTransit, PGuess, PSlip, responses);
}

public double knowledgeTrace(double pL, double pT, double pG, double pS, int [] responses)
{
    double tracedPL = pL;
    for(int i = 0; i < responses.length ; i++){
        double pKnew = 0;
        if (responses[i] == 1)
            pKnew = correctTrace(tracedPL, pT, pG, pS);
        else
            pKnew = wrongTrace(tracedPL, pT, pG, pS);
        
        double pLearnNow = (1 - pKnew) * pT;
        tracedPL = pKnew + pLearnNow;
    }
    return tracedPL;  
}

public double correctTrace(double givenPL,double  pT, double pG, double pS){
   
    double probKnowNotSlip = givenPL * (1 - pS);
    double probNotKnowGuess = (1 - givenPL) * pG;
    double probCorrect = probKnowNotSlip + probNotKnowGuess;
    return probKnowNotSlip/probCorrect;
}

public double wrongTrace(double givenPL, double pT, double pG, double pS){

    double probKnowSlip = givenPL * pS;
    double probNotKnowNotGuess = (1 - givenPL) * (1 - pG);
    double probIncorrect = probKnowSlip + probNotKnowNotGuess;
    return probKnowSlip/probIncorrect;   
}
  public void settings() {  size(1280, 720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "iteration1sized" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
