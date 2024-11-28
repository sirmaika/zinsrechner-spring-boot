package com.example.zinsrechnerspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZinseszinsController {

    @Autowired
    private ZinseszinsBerechnung zinseszinsBerechnung;

    @GetMapping("/berechne")
    public String berechneZinseszins(
            @RequestParam double anfangskapital,
            @RequestParam double monatlicheSparrate,
            @RequestParam double jahreszins,
            @RequestParam int spardauerInJahren) {

        double endkapital = zinseszinsBerechnung.berechneEndwert(anfangskapital, monatlicheSparrate, jahreszins, spardauerInJahren);
        double gesamteeinzahlungen = zinseszinsBerechnung.berechneGesamteEinzahlungen(anfangskapital, monatlicheSparrate, spardauerInJahren);
        double erhalteneZinszahlungen = endkapital - gesamteeinzahlungen;

        return "Endkapital: " + zinseszinsBerechnung.formatiereWaehrung(endkapital) + "<br>" +
                "Gesamte Einzahlungen: " + zinseszinsBerechnung.formatiereWaehrung(gesamteeinzahlungen) + "<br>" +
                "Erhaltene Zinszahlungen: " + zinseszinsBerechnung.formatiereWaehrung(erhalteneZinszahlungen);
    }
}

