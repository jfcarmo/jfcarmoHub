package controllers;

import models.VisitanteEntity;
import play.*;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

    public static Result index() {



        return ok(index.render());
    }
    @Transactional
    public static Result getAllVisitante(){

        return ok(Json.toJson(new VisitanteEntity().findAll())).as("application/json");
    }
}
