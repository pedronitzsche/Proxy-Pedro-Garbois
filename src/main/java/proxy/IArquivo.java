package proxy;

import java.util.List;

public interface IArquivo {

    List<String> obterInformacoes();

    String obterConteudo(Usuario usuario);
}