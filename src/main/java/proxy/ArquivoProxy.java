package proxy;

import java.util.List;

public class ArquivoProxy implements IArquivo {

    private Arquivo arquivo;
    private Integer id;

    public ArquivoProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterInformacoes() {

        if (this.arquivo == null) {
            this.arquivo = new Arquivo(this.id);
        }

        return this.arquivo.obterInformacoes();
    }

    @Override
    public String obterConteudo(Usuario usuario) {

        if (!usuario.isAutorizado()) {
            throw new IllegalArgumentException("Usuario nao autorizado");
        }

        if (this.arquivo == null) {
            this.arquivo = new Arquivo(this.id);
        }

        return this.arquivo.obterConteudo(usuario);
    }
}