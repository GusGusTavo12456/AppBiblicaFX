package com.example.appbiblicafx.utils;

import com.example.appbiblicafx.models.Versiculo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Clase de utilidad para gestionar versículos bíblicos.
 * ¡Para gloria y honra del Señor!
 */

public class BibliaData {
    // Lista estática de versículos (posteriormente puedes cargar desde archivos o bases de datos)
    private static final List<Versiculo> VERSICULOS = Arrays.asList(
            new Versiculo("Josué", 1, 9,
                    "Mira que te mando que te esfuerces y seas valiente; no temas ni desmayes, porque Jehová tu Dios estará contigo dondequiera que vayas."),
            new Versiculo("Salmos", 23, 1,
            "Jehová es mi pastor; nada me faltará."),
            new Versiculo("Filipenses", 4, 13,
                    "Todo lo puedo en Cristo que me fortalece."),
            new Versiculo("Romanos", 11, 36,
                    "Porque de él, y por él, y para él, son todas las cosas. A él sea la gloria por los siglos. Amén.")
    );

    /**
     * Devuelve todos los versículos disponibles.
     */
    public static List<Versiculo> obtenerVersiculos() {
        return VERSICULOS;
    }
    /**
     * Busca versículos específicos por libro.
     */

    public static List<Versiculo> obtenerVersiculosPorLibro(String libro) {
        return VERSICULOS.stream()
                .filter(v -> v.getLibro().equalsIgnoreCase(libro))
                .collect(Collectors.toList());
    }

    /**
     * Busca versículos específicos por referencia exacta.
     */
    public static Versiculo buscarPorReferencia(String libro, int capitulo, int versiculo) {
        return VERSICULOS.stream()
                .filter(v -> v.getLibro().equalsIgnoreCase(libro) &&
                        v.getCapitulo() == capitulo &&
                        v.getNumeroVersiculo() == versiculo)
                .findFirst()
                .orElse(null);
    }

    /**
     * Permite buscar versículos que contengan una palabra clave en su texto.
     */

    public static List<Versiculo> buscarPorPalabraClave(String palabraClave) {
        return VERSICULOS.stream()
                .filter(v -> v.getTexto().toLowerCase().contains(palabraClave.toLowerCase()))
                .collect(Collectors.toList());
    }
}