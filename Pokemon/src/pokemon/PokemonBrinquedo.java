/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pokemons.*;

/**
 *
 * @author Fernanda
 */
public class PokemonBrinquedo extends Pokemons{
    Pokemons pokemon = new Pokemons() {
        @Override
        public double atacar() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    public void VendaPokemon() throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalArgumentException, IllegalAccessException{
        Controlador controlador = new Controlador();
        Scanner leitura = new Scanner(System.in);
        int i=1,j, quantidade;
        String nomePok;
        ArrayList<Double> valores = new ArrayList<Double>();
        ArrayList<String> listaPokemons = new ArrayList<String>(); 
        
       while(i == 1){
            System.out.println("Digite o pokemon que deseja comprar: de 0 a 13");
            controlador.imprimelistapokemons();
            j = leitura.nextInt();
            nomePok = controlador.getnomepokemon(j);
            listaPokemons.add(nomePok);
            System.out.println("Digite a quantidade que deseja");
            quantidade = leitura.nextInt();
            try {
                valores.add(calcularValor(j, quantidade));
            } catch (InvocationTargetException ex) {
                Logger.getLogger(PokemonBrinquedo.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Deseja comprar mais? [Digite 1 para SIM e 0 para NÃO]");
            i = leitura.nextInt();
       }
       double valorFinal = 0;
        for (double k: valores) {
            valorFinal = valorFinal + k;
        }
        imprimirValorFinal(valorFinal, listaPokemons );
               
    }
    public double calcularValor(int indice, int quantidade) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        Controlador controlador = new Controlador();
        pokemon = (Pokemons) Class.forName("pokemons."+controlador.getnomepokemon(indice)).getConstructor().newInstance();
           
        return (pokemon.getPreco())*quantidade;
    }
    public void imprimirValorFinal(double valorFinal,ArrayList<String>listaPokemons  ){
        if(valorFinal < 0 ){
            System.out.println("Valor Invalido. ");
        }
        System.out.println("Lista de Pokemons selecionados: ");
        for(String nome : listaPokemons){
            System.out.println("* "+nome);
        }
        System.out.println("Valor final: %f" +valorFinal);
    }

    @Override
    public double atacar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
