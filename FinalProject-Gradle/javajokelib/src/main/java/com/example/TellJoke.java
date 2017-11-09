package com.example;

public class TellJoke {
    public String[] jokeReserve={
            "Mobile - Update\n" + "Tablet - Update\n" + "Laptop - Update\n" + "TV - Update \n" +
                    "Gaming console - Update\n" +
                    "\n" +
                    "Somehow I am afraid to plug in the iron.\n" +
                    "\n",
            "I have never been married, but I can imagine how it feels. I once had a stone stuck in my shoe for 10 hours.\n" ,
            "A recent scientific study showed that out of 2,293,618,367 people, 94% are too lazy to actually read that number.\n" ,

    };
    public String tellAJoke(int n){
        return jokeReserve[n];
    }


}