package controller.creators;

import controller.InputProvider;
import entity.AudioItem;

public interface ItemCreator {
    AudioItem create(InputProvider input);
}
