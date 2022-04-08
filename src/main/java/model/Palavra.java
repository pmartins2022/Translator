package model;

public class Palavra {

    String descricao;

    public Palavra (String descricao){
        this.descricao=descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "model.decricao: " + descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Palavra)) return false;
        Palavra descricao = (Palavra) o;
        return getDescricao().equals(descricao.getDescricao());
    }
}
