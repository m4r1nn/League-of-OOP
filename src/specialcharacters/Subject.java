package specialcharacters;

import angels.types.Angel;
import players.types.Hero;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers;

    // constructor
    public Subject() {
        this.observers = new ArrayList<>();
    }

    // add new observer to notify list
    public final void addObserver(final Observer observer) {
        this.observers.add(observer);
    }

    // remove observer from notify list
    public final void removeObserver(final Observer observer) {
        this.observers.remove(observer);
    }

    // method for notifying observers about main stats in game
    public final void notifyObservers(final Hero hero1, final Hero hero2,
                                      final Angel angel, final String messageType) {
        for (Observer observer : this.observers) {
            observer.update(hero1, hero2, angel, messageType);
        }
    };
}
