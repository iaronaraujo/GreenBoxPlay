package controllers;

import com.google.inject.Inject;
import models.User;
import play.data.FormFactory;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    //public Result index() {
    //    return ok(index.render("Your new application is ready."));
    //}
    private List<User> userList = new ArrayList<>();

    @Inject
    private FormFactory formFactory;


    public Result index() {
        return ok(index.render(userList));
    }

    public Result registerUser(){
        User user = formFactory.form(User.class).bindFromRequest().get();
        userList.add(user);
        return ok(userdirectory.render(user));
    }

    public Result register(){
        return ok(register.render());
    }

    public Result login() {
        User user = formFactory.form(User.class).bindFromRequest().get();

        if (isValidUser(user)) {
            return ok(userdirectory.render(getUser(user)));
        } else {
            return ok(usernotfound.render());
        }
    }

    // Method to check if the user exists
    private boolean isValidUser(User checkingUser) {
        for (User user : userList) {
            //This shouldn't be checked like this, but it works for now.
           if (user.getEmail().equals(checkingUser.getEmail()) && user.getPassword().equals(checkingUser.getPassword())) {
               return true;
           }
        }

        return false;
    }

    private User getUser(User user) {
        for (User usercopy: userList) {
            if ( usercopy.getPassword().equals(user.getPassword()) && (usercopy.getEmail().equals(user.getEmail())) ) {
                return user;
            }
        }
        return null;
    }

}