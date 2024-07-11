package org.example;

public class Vehiculo {
    String placa;
    String marca;
    float cilindraje;
    String tipoCombustble;
    String color;
    String propietario;
    String fechaCompra;
    public Vehiculo() {}
    public Vehiculo(String placa,String marca,float cilindraje,String tipoCombustble,String color,String propietario,String fechaCompra) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.tipoCombustble = tipoCombustble;
        this.color = color;
        this.propietario = propietario;
        this.fechaCompra = fechaCompra;
    }

    //getters y setters


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(float cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipoCombustble() {
        return tipoCombustble;
    }

    public void setTipoCombustble(String tipoCombustble) {
        this.tipoCombustble = tipoCombustble;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    //metodos personalizados


    @Override
    public String toString() {
        return "Placa: "+ placa + '\n' +
                "Marca: "+marca + '\n' +
                "Cilindraje: "+cilindraje + '\n' +
                "Tipo Combustble: "+tipoCombustble + '\n' +
                "Color: "+color + '\n' +
                "Propietario: "+propietario + '\n' +
                "Fecha Compra: "+fechaCompra + '\n';
    }

}
