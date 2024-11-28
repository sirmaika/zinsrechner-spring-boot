package com.example.zinsrechnerspringboot;

import org.springframework.stereotype.Service;
import java.text.NumberFormat;

@Service
public class ZinseszinsBerechnung {


    public double berechneEndwert(double anfangskapital, double monatlicheSparrate, double jahreszins, int spardauerInJahren) {
        double monatlicherZinssatz = jahreszins / 100 / 12; // Monatlicher Zinssatz
        int monate = spardauerInJahren * 12; // Gesamtzahl der Monate

        // Berechnung des Endwertes
        return anfangskapital * Math.pow((1 + monatlicherZinssatz), monate) +
                monatlicheSparrate * (Math.pow((1 + monatlicherZinssatz), monate) - 1) / monatlicherZinssatz;
    }

    public double berechneGesamteEinzahlungen(double anfangskapital, double monatlicheSparrate, int spardauerInJahren) {
        int monate = spardauerInJahren * 12; // Gesamtzahl der Monate

        // Berechnung der gesamten Einzahlungen
        return anfangskapital + monatlicheSparrate * monate;
    }

    public String formatiereWaehrung(double betrag) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return currencyFormat.format(betrag);
    }
}
