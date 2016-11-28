package com.softcloud.model;

import com.softcloud.model.base.AllCardsModel;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Softcloud on 16/11/24.
 */

public interface HealthStoneApi {
    
    @GET("cards")
    Flowable<AllCardsModel> getAllCards(
            //@Query("collectible") String collectible
            @Query("cost") String cost
            //, @Query("durability") String durability
            , @Query("health") String health
            , @Query("locale") String locale);
}
