package com.softcloud.model.base;

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
    public abstract List<Card> Basic();
    public abstract List<Card> Classic();
    public abstract List<Card> Promo();
    public abstract List<Card> Reward();
    public abstract List<Card> Naxxramas();
    @SerializedName("Goblins vs Gnomes")
    public abstract List<Card> GoblinsVsGnomes();
    @SerializedName("Blackrock Mountain")
    public abstract List<Card> BlackrockMountain();
    @SerializedName("The Grand Tournament")
    public abstract List<Card> TheGrandTournament();
    @SerializedName("The League of Explorers")
    public abstract List<Card> TheLeagueOfExplorers();
    @SerializedName("Whispers of the Old Gods")
    public abstract List<Card> WhispersOfTheOldGods();
    public abstract List<Card> Karazhan();
    @SerializedName("Tavern Brawl")
    public abstract List<Card> TavernBrawl();
    @SerializedName("Hero Skins")
    public abstract List<Card> HeroSkins();
    public abstract List<Card> Missions();
    public abstract List<Card> Credits();
    public abstract List<Card> System();
    public abstract List<Card> Debug();


    // TODO: 16/11/24 more lists to be add


    public static TypeAdapter<AllCardsModel> typeAdapter(final Gson gson) {
        return new AutoValue_AllCardsModel.GsonTypeAdapter(gson);
    }

}
