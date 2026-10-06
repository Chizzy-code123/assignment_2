// Configurations
int scene = 0;
boolean exitDoorOpen = false;
boolean helpedPassenger = false;

// Helpers

// STORY \\
size(400, 400);

background(148, 189, 255);
fill(255, 0, 0);

// Setting
println("'Attention passengers. Please ensure that you are wearing your seatbelts.' You are on a trip to Egypt. It is dark outside and you can hear everyone snoozing.");
println("A tired flight attendant slowly rolls a drink cart down the aisle.");
println("'Water?' she asks quietly.");

String takeWater = Ask.forString("Take the water? [YES] [NO]");

// Water scene
if (takeWater.toLowerCase().startsWith("y")) {
  println("You take then drink the water");
  scene = 1;
} else {
  println("You decline the water");
  println("You look outside the window and see the plane smoothly drifting through the clouds. \n\n\n");
  scene = 4;
}

if (scene == 1) {
  println("You have to pee because you just drank a lot of water.");
  println("Do you use the washroom or stay?");
  String useWashroom = Ask.forString("Use the washroom? [YES] [NO]");
  useWashroom = useWashroom.toLowerCase();

  if (useWashroom.toLowerCase().startsWith("y")) {
    println("You enter the washroom");
    scene = 3;
  } else {
    println("You decide to stay in your seat. \n\n\n");
    println("A few moments later...");
    scene = 4;
  }
}

if (scene == 3) {
  println("As your peeing, the plane begins to shake");
  println("You hear the intercom saying brace yourself for impact.");
  println("In a panic, you consider leaving the washroom");

  String leaveTheWashroom = Ask.forString("Leave the washroom?");

  if (leaveTheWashroom.toLowerCase().startsWith("y")) {
    scene = 5;
  } else {
    println("You decide to wait here.");
    scene = 6;
  }
} else if (scene == 4) {
  println("As you are chilling, you look outside the window and the plane seems to be moving downwards...");
  println("'Alert! Alert! The plane is losing oxygen to stay afloat.' You hear from the intercom.");
  println("In a panick, passengers wake up and start running around in the plane.");
  println("You consider doing the same to figure out a way to get out.");

  String getUp = Ask.forString("Get up? [YES] [NO]");
  if (getUp.toLowerCase().startsWith("y")) {
    println("You need to find somewhere for cover but you see someone trip on the floor.");
    println("You see the washroom down the hall");
    println("Now you wonder whether you should help the passenger or not.");
    println("You see the flight attendant trying to get everyone's attention.");
    println("[1] Run to the washroom OR [2] help passengers out? [3] Follow flight attendant?");

    int choice = Ask.forInt("[1] Run to the washroom OR [2] help passengers out? [3] Follow flight attendant?");
    if (choice == 1) {
      println("You decide to protect yourself and run to the washroom.");
      println("You make it to the washroom and stay there panicking.");
      scene = 6;
    } else if (choice == 2) {
      println("You grab onto a drowsy person's arm to help them regain their feet.");
      println("The plane continues to go down and you hear screaming.");
      helpedPassenger = true;
      scene = 5;
    } else if (choice == 3) {
      println("You chase after the flight attendant who is struggling to open the emergency exit.");
      println("You help her out");
      println("The bar hits your shoulder, wounding it.");
      println("The door opens and you can feel the fresh breeze enter the plane.");
      exitDoorOpen = true;
      scene = 6;
    }
  } else {
    println("You decide to stay put in your seat, and fasten your seatbelt.");
    println("You see the flight attendant struggling to get everyone's attention as shes opening the emergency exit door.");
    println("You consider helping her.");

    String choice = Ask.forString("Follow flight attendant? [YES] [NO]");

    if (choice.toLowerCase().startsWith("y")) {
      println("You chase after and help her out");
      println("The door's handle hits your shoulder, wounding it.");
      println("The door swings and you can feel the fresh breeze enter the plane.");
      println("You did it! Now people can jump out.");
      exitDoorOpen = true;
      scene = 6;
    } else {
      println("You lazily ignore her and fasten your seatbelt.");
    }

    println("Few moments later...");
    scene = 5;
  }
}

// Random luck to see if the player ends up surviving if they entered the washroom

if (scene == 6) {

  float luck;

  if (exitDoorOpen) {
    luck = random(1, 100);

    if (luck < 60) {
      scene = 7;
    } else {
      scene = 5;
    }
  } else {
    luck = random(1, 100);

    if (luck < 20) {
      scene = 7;
    } else {
      scene = 5;
    }
  }
}

if (scene == 5 && helpedPassenger) {
  println("CRASH \n\n\n\n\n\n\n");
  println("You toss your body over the passenger as the plane crashes.");
  println("...");
  println("The plane crashes and you don't survive. The passenger your helped luckly survived.");

  // Showing game over on screen
  textSize(40);
  text("Game over", 150, 150);
} else if (scene == 5) {
  println("CRASH \n\n\n\n\n\n\n");
  println("The plane crashes and you don't survive. The passenger your helped luckly survived.");
} else if (scene == 7) {
  println("CRASH \n\n\n\n\n\n\n");
  println("Your head feels dizzy and your eyesight is foggy.");


  println("It seems to be you survived the plane crash, how lucky.");
  if (exitDoorOpen) {
    println("Thanks to your courage, some people where able to survive because of the open exit door.");
  }
  println("You and some other passengers exit the plane to be in a random forest...");
  println("To Be Continued...");

  textSize(128);
  text("You Survived!", 250, 250);
}
