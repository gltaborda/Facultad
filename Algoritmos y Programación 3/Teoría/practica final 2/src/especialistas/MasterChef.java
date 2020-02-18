package especialistas;

import comidas.Empanada;

public class MasterChef {

    public MasterChef(){

    }

    public String hacerPan(){

        return "Hice pan.";

    }

    public String hacerPanParaCeliacos(){

        return "Hice pan para celiacos.";

    }

    public String hacerPanParaHipertensos(){

        return "Hice pan para hipertensos.";

    }

    public Empanada hacerEmpanada(){

        Empanada empanada = new Empanada();
        return empanada;

    }

    public String hacerEmpanadaParaCeliacos(){

        return "Hice empanada para celiacos.";

    }

    public String hacerEmpanadaParaHipertensos(){

        return "Hice empanada para hipertensos.";

    }
}
