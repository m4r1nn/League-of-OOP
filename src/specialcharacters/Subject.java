package specialcharacters;

import angels.types.Angel;
import players.types.Hero;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public final void addObserver(final Observer observer) {
        this.observers.add(observer);
    }
    public final void removeObserver(final Observer observer) {
        this.observers.remove(observer);
    }
    public final void notifyObservers(final Hero hero1, final Hero hero2,
                                      final Angel angel, final String messageType) {
        for (Observer observer : this.observers) {
            observer.update(hero1, hero2, angel, messageType);
        }
    };
}
