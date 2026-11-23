package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArquivoProxyTest {

    @BeforeEach
    void setUp() {
        Repositorio.addArquivo(
                new Arquivo(
                        1,
                        "Contrato",
                        "PDF",
                        "Conteudo confidencial do contrato"
                )
        );

        Repositorio.addArquivo(
                new Arquivo(
                        2,
                        "Relatorio",
                        "DOCX",
                        "Conteudo interno do relatorio"
                )
        );
    }

    @Test
    void deveRetornarInformacoesArquivo() {
        ArquivoProxy arquivo = new ArquivoProxy(1);

        assertEquals(
                Arrays.asList("Contrato", "PDF"),
                arquivo.obterInformacoes()
        );
    }

    @Test
    void deveRetornarConteudoArquivo() {
        Usuario usuario = new Usuario("Pedro", true);
        ArquivoProxy arquivo = new ArquivoProxy(2);

        assertEquals(
                "Conteudo interno do relatorio",
                arquivo.obterConteudo(usuario)
        );
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizado() {
        try {
            Usuario usuario = new Usuario("Joao", false);
            ArquivoProxy arquivo = new ArquivoProxy(1);

            arquivo.obterConteudo(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals(
                    "Usuario nao autorizado",
                    e.getMessage()
            );
        }
    }
}