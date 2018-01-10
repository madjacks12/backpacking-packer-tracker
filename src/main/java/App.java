import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Mod;
import models.Item;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sun.jvm.hotspot.oops.ObjectHeap;

import javax.print.DocFlavor;

import static spark.Spark.*;




public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/item/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "item-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/item/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int price = Integer.parseInt(request.queryParams("price"));
            boolean purchased = Boolean.getBoolean(request.queryParams("purchased"));
            String manufacturer = request.queryParams("manufacturer");
            int weight = Integer.parseInt(request.queryParams("weight"));
            Item newItem = new Item(name, price, purchased, weight, manufacturer);
            model.put("newItem", newItem);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/item", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Item> items = Item.getAll();
            model.put("items", items);
            return new ModelAndView(model, "all-items.hbs");
        }, new HandlebarsTemplateEngine());

        get("/item/packing-list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Item> packinglist = Item.getAllUnpacked();
            model.put("packinglist", packinglist);
            return new ModelAndView(model, "packing-list.hbs");
        }, new HandlebarsTemplateEngine());

        get("/item/shopping-list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Item> shoppinglist = Item.getAllUnpurchased();
            model.put("shoppinglist", shoppinglist);
            return new ModelAndView(model, "shopping-list.hbs");
        }, new HandlebarsTemplateEngine());


    }


}
