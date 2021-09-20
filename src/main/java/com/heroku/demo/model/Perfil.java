package com.heroku.demo.model;

public enum Perfil {

    /**
     * Por exigência do Spring Secutiry a descrição dos perfis precisa ter o prefixo
     * "ROLE_"
     */
    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");

    private int cod;
    private String descricao;

    private Perfil(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static Perfil toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }
        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
