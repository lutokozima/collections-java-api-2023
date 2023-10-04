package main.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livroList.add(new Livro(titulo,autor, anoPublicacao));

    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!livroList.isEmpty()){
            for(Livro l: livroList){
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }

        } else {
            throw new RuntimeException("A lista está vazia!");
        }
        return livrosPorAutor;
    }


    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if(!livroList.isEmpty()){
            for (Livro l: livroList){
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal){
                    livrosPorIntervaloAnos.add(l);
                }
            }
            return livrosPorIntervaloAnos;

        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if(!livroList.isEmpty()){
            for(Livro l: livroList){
                if(l.getTitulo().equalsIgnoreCase((titulo))){
                    livroPorTitulo = l;
                    break;
                }
            }
        } else {
            System.out.println("A lista está vazia");
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", "Autor1", 2020);
        catalogoLivros.adicionarLivro("Livro 1", "Autor2", 2021);
        catalogoLivros.adicionarLivro("Livro 2", "Autor2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor4", 1984);


        System.out.println(catalogoLivros.pesquisarPorAutor("Autor2"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2021, 2022));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));



    }

}
