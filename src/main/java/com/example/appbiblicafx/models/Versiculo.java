package com.example.appbiblicafx.models;

/**
 * Representa un versículo bíblico, con libro, capítulo, versículo y texto.
 * ¡Para la gloria de Dios!
 */

public class Versiculo implements Comparable<Versiculo> {
    private final String libro;
    private final int capitulo;
    private final int versiculo;
    private final String texto;

    public Versiculo(String libro, int capitulo, int versiculo, String texto) {
        this.libro = libro;
        this.capitulo = capitulo;
        this.versiculo = versiculo;
        this.texto = texto;
    }

    /** Retorna el libro del versículo */
    public String getLibro() {
        return libro;
    }

    /** Retorna el capítulo del versículo */
    public int getCapitulo() {
        return capitulo;
    }

    /** Retorna el número del versículo */
    public int getNumeroVersiculo() {
        return versiculo;
    }

    /** Retorna el texto bíblico del versículo */
    public String getTexto() {
        return texto;
    }

    /** Retorna la referencia completa en formato 'Libro Capitulo:Versículo' */
    public String getReferencia() {
        return String.format("%s %d:%d", libro, capitulo, versiculo);
    }

    /** Representación amigable del versículo */
    @Override
    public String toString() {
        return getReferencia() + " - " + texto;
    }

    /** Permite ordenar fácilment versículos por libro, capítulo y número de versículo */
    @Override
    public int compareTo(Versiculo otro) {
        int compararLibro = this.libro.compareToIgnoreCase(otro.libro);
        if (compararLibro != 0) {
            return compararLibro;
        }

        int compararCapitulo = Integer.compare(this.capitulo, otro.capitulo);
        if (compararCapitulo != 0) {
            return compararCapitulo;
        }

        return Integer.compare(this.versiculo, otro.versiculo);
    }

    /** Compara igualdad exacta entre dos objetos versículo */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Versiculo)) return false;

        Versiculo otro = (Versiculo) obj;

        return libro.equalsIgnoreCase(otro.libro) &&
                capitulo == otro.capitulo &&
                versiculo == otro.versiculo &&
                texto.equals(otro.texto);
    }

    /** Genera hashcode según los atributos del objeto */
    @Override
    public int hashCode() {
        int result = libro.toLowerCase().hashCode();
        result = 31 * result + capitulo;
        result = 31 * result + versiculo;
        result = 31 * result + texto.hashCode();
        return result;
    }

}