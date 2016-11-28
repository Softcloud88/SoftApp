package com.softcloud.model.base;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.softcloud.model.Card;

import java.util.List;

/**
 * Created by Softcloud on 16/11/24.
 */

@AutoValue
public abstract class AllCardsModel extends BaseModel{
    public abstract List<Card> Basic();
    public abstract List<Card> Classic();
    public abstract List<Card> Credits();
    public abstract List<Card> Naxxramas();
    // TODO: 16/11/24 more lists to be add


    public static TypeAdapter<AllCardsModel> typeAdapter(final Gson gson) {
        return new AutoValue_AllCardsModel.GsonTypeAdapter(gson);
    }

}
