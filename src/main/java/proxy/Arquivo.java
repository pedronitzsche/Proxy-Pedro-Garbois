package proxy;

import java.util.Arrays;
import java.util.List;

public class Arquivo implements IArquivo {

    private Integer id;
    private String nome;
    private String tipo;
    private String conteudo;

    public Arquivo(int id) {
        this.id = id;

        Arquivo objeto = Repositorio.getArquivo(id);

        this.nome = objeto.nome;
        this.tipo = objeto.tipo;
        this.conteudo = objeto.conteudo;
    }

    public Arquivo(Integer id, String nome, String tipo, String conteudo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterInformacoes() {
        return Arrays.asList(this.nome, this.tipo);
    }

    @Override
    public String obterConteudo(Usuario usuario) {
        return this.conteudo;
    }
}