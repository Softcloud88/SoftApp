package com.softcloud.model.base;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.softcloud.model.Card;

import java.util.List;

/**
 * Created by Softcloud on 16/11/24.
 */

@AutoValue
public abstract class AllCardsModel extends BaseModel{
    @Nullable
    public abstract List<Card> Basic();
    @Nullable public abstract List<Card> Classic();
    @Nullable public abstract List<Card> Promo();
    @Nullable public abstract List<Card> Reward();
    @Nullable public abstract List<Card> Naxxramas();
    @Nullable @SerializedName("Goblins vs Gnomes")
    public abstract List<Card> GoblinsVsGnomes();
    @Nullable @SerializedName("Blackrock Mountain")
    public abstract List<Card> BlackrockMountain();
    @Nullable @SerializedName("The Grand Tournament")
    public abstract List<Card> TheGrandTournament();
    @Nullable @SerializedName("The League of Explorers")
    public abstract List<Card> TheLeagueOfExplorers();
    @Nullable @SerializedName("Whispers of the Old Gods")
    public abstract List<Card> WhispersOfTheOldGods();
    @Nullable public abstract List<Card> Karazhan();
    @Nullable @SerializedName("Tavern Brawl")
    public abstract List<Card> TavernBrawl();
    @Nullable @SerializedName("Hero Skins")
    public abstract List<Card> HeroSkins();
    @Nullable public abstract List<Card> Missions();
    @Nullable public abstract List<Card> Credits();
    @Nullable public abstract List<Card> System();
    @Nullable public abstract List<Card> Debug();


    // TODO: 16/11/24 more lists to be add


    public static TypeAdapter<AllCardsModel> typeAdapter(final Gson gson) {
        return new AutoValue_AllCardsModel.GsonTypeAdapter(gson);
    }

}
