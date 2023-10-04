package main.list.Ordenacao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {

    //atributo
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    /*
    adicionarPessoa(String nome, int idade, double altura): Adiciona uma pessoa à lista.
    ordenarPorIdade(): Ordena as pessoas da lista por idade usando a interface Comparable.
    ordenarPorAltura(): Ordena as pessoas da lista por altura usando um Comparator personalizado.
    */

    public void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;

    }


    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Nome1", 20, 1.56);
        ordenacaoPessoas.adicionarPessoa("Nome2", 30, 1.80);
        ordenacaoPessoas.adicionarPessoa("Nome3", 25, 1.70);
        ordenacaoPessoas.adicionarPessoa("Nome4", 17, 1.56);

        System.out.println(ordenacaoPessoas.pessoaList);
        System.out.println(ordenacaoPessoas.ordenarPorIdade());
        System.out.println(ordenacaoPessoas.ordenarPorAltura());
    }



}
