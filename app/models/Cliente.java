package models;

import play.data.validation.Constraints;

public class Cliente {
    @Constraints.MinLength(5)
    public String nome;
    @Constraints.Email
    public String email;
    @Constraints.Pattern("\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
    public String cpf;
}
