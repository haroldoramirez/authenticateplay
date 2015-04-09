package controllers;

import models.Cliente;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.editar;
import views.html.login;

public class Application extends Controller {

    public static class Login {
        public String email;
        public String password;
        public String validate() {
            if("admin".equals(email) && "123".equals(password)) {
                return null;
            }
            return "Invalid user or password";
        }
    }

    private static Form<Cliente> form =
            new Form<Cliente>(Cliente.class);
    private static Form<Login> formLogin =
            new Form<Login>(Login.class);

    public static Result login() {
        return ok(login.render(formLogin));
    }

    public static Result autenticar() {
        Form<Login> f = formLogin.bindFromRequest();
        if (f.hasErrors()){
            return badRequest(login.render(f));
        } else {
            session("email", f.get().email);
            return redirect(routes.Veiculos.index());
        }
    }

    public static Result logout() {
        session().clear();
        return redirect(routes.Application.login());
    }

    public static Result index() {
        return ok(editar.render(form));
    }

    public static Result cadastrar() {
        Form<Cliente> f = form.bindFromRequest();
        if (f.hasErrors()) {
            return ok(editar.render(f));
        }
        return ok("Cadastrado com sucesso!");
    }
}
