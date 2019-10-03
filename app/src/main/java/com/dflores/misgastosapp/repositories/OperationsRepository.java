package com.dflores.misgastosapp.repositories;

import com.dflores.misgastosapp.models.OperationsModel;
import com.dflores.misgastosapp.models.OperationsModel;

import java.util.ArrayList;
import java.util.List;

public class OperationsRepository {
    private static List<OperationsModel> operation;
    static{
        operation = new ArrayList<>();
        operation.add(new OperationsModel("12/05/2000","Egresos", "1200.50", "Tarjeta de Crédito"));
        operation.add(new OperationsModel("18/04/2000","Ingresos", "1300.50", "Ahorro"));
        operation.add(new OperationsModel("23/04/2000","Ingresos", "1400.50", "Efectivo"));
        operation.add(new OperationsModel("21/07/2000","Ingresos", "5200.50", "Tarjeta de Crédito"));
    }

    public static List<OperationsModel> getOperation(String saldo) {
        List<OperationsModel> temp = new ArrayList<>();
        for(int m = 0; m < operation.size(); m++){
            if(operation.get(m).getSaldo().equals(saldo)){
                temp.add(operation.get(m));
            }
        }
        return temp;
    }



    public static void agregar(String fecha, String tipo, String monto, String saldo){
        operation.add(new OperationsModel(fecha, tipo, monto, saldo));
    };

    public static double total(String saldo){
        double total = 0;
        double total_ingresos = 0;
        double total_egresos = 0;
        for(int m = 0; m < operation.size(); m++){
            if(operation.get(m).getSaldo().equals(saldo)){
                if (operation.get(m).getTipo().equals("Ingresos")){
                    double numero1 = Double.parseDouble(operation.get(m).getMonto());
                    total_ingresos = total_ingresos + numero1;
                }else{
                    double numero2 = Double.parseDouble(operation.get(m).getMonto());
                    total_egresos = total_egresos + numero2;
                }
            }
        }
        total = total_ingresos - total_egresos;
        return total;
    }

    public static double total_global(){
        double sumatoria_egresos = 0;
        double sumatoria_ingresos = 0;
        double sumatoria = 0;
        for(int m = 0; m < operation.size(); m++){
            if(operation.get(m).getTipo().equals("Ingresos")){
                double numero1 = Double.parseDouble(operation.get(m).getMonto());
                sumatoria_ingresos = sumatoria_ingresos + numero1;
            }else{
                double numero2 = Double.parseDouble(operation.get(m).getMonto());
                sumatoria_egresos = sumatoria_egresos + numero2;
            }
        }
        sumatoria = (sumatoria_ingresos/(sumatoria_egresos+sumatoria_ingresos))*100;
        return sumatoria;
    }
}
