package com.softcloud.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.softcloud.model.base.AllCardsModel;
import com.softcloud.model.base.BaseData;

import java.util.List;

/**
 * Created by Softcloud on 16/11/24.
 */

@AutoValue
public abstract class Card extends BaseData {

    @Nullable public abstract String cardId();
    @Nullable public abstract String name();
    @Nullable public abstract String cardSet();
    @Nullable public abstract String type();
    @Nullable public abstract String rarity();
    @Nullable public abstract String text();
    @Nullable public abstract String playerClass();
    @Nullable public abstract List<Mechanic> mechanics();
    @Nullable public abstract String faction();
    public abstract boolean collectible();
    @Nullable public abstract String img();
    @Nullable public abstract String imgGold();

    public abstract String locale();

    public static TypeAdapter<Card> typeAdapter(final Gson gson) {
        return new AutoValue_Card.GsonTypeAdapter(gson);
    }
}
