package com.softcloud.model;

import com.google.auto.value.AutoValue;
import com.softcloud.model.base.BaseData;

import java.util.List;

/**
 * Created by Softcloud on 16/11/24.
 */

@AutoValue
public abstract class Card extends BaseData {

    public abstract String cardId();
    public abstract String name();
    public abstract String cardSet();
    public abstract String type();
    public abstract String rarity();
    public abstract String text();
    public abstract String playerClass();
    public abstract List<Mechanic> mechanics();
    public abstract String faction();
    public abstract boolean collectible();
    public abstract String img();
    public abstract String imgGold();

    public abstract String locale();
}
