package com.fakestoreapi.questions;

import com.fakestoreapi.models.responsePost.UserModelPost;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PostDataResponse implements Question<UserModelPost> {

    @Override
    public UserModelPost answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModelPost.class);
    }

    public static PostDataResponse was(){
        return new PostDataResponse();
    }
}
