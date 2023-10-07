package main.map.Ordenacao;

import main.set.Pesquisa.AgendaContatos;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    //atributo
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        // Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        // System.out.println(eventosTreeMap);
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            Evento evento = entry.getValue();
            System.out.println("Data: " + dataEvento + ", Evento: " + evento.getNome() + ", Atração: " + evento.getAtracao());
        }
    }

    //    public void obterProximoEvento(){
//        //Set<LocalDate> dataSet = eventosMap.keySet(); //retorna todas as keys
//        //Collection<Evento> values = eventosMap.values(); //retorna todos os valores
//        //eventosMap.get(); //nao funciona pq nao sei qual é a chave
//
//        //data atual do sistema
//        LocalDate dataAtual = LocalDate.now();
//        LocalDate proximaData = null;
//        Evento proximoEvento = null;
//
//        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
//        for(Map.Entry<LocalDate, Evento> entry: eventosMap.entrySet()){
//            LocalDate dataEvento = entry.getKey();
//            if(dataEvento.isEqual(dataAtual)|| dataEvento.isAfter(dataAtual)){
//                proximaData = dataEvento;
//                proximoEvento = entry.getValue();
//                System.out.println("O próximo evento: " + proximoEvento  + "acontecerá na data " + proximaData);
//                break;
//            }
//        }
    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        for (Map.Entry<LocalDate, Evento> entry : eventosMap.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            if (dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
                proximaData = dataEvento;
                proximoEvento = entry.getValue();
                //break;
            }
        }
        if (proximoEvento != null) {
            System.out.println("O próximo evento: " + proximoEvento.getNome() + " acontecerá na data " + proximaData);
        } else {
            System.out.println("Não há eventos futuros na agenda.");
        }
    }


    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        System.out.println(LocalDate.now());

        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.JULY, 15), "Evento 1", "Atracao 1");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 10, 4), "Evento 2", "Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JANUARY, 15), "Evento 3", "Atracao 3");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }


}
