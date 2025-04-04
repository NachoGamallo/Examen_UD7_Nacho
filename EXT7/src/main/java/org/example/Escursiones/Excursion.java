package org.example.Escursiones;

import java.util.*;


public class Excursion {

    static Scanner entry = new Scanner(System.in);
    private String nombre;
    private String localidad;
    private double precio;
    private Set<String> profesores;
    private Set<Estudiante> listaAsistentes;

    public Excursion(String nombre, String localidad, double precio){
        this.nombre = nombre;
        this.localidad = localidad;
        this.precio = precio;
        this.profesores = new LinkedHashSet<>();
        this.listaAsistentes = new LinkedHashSet<>();
    }

    public void insertarProfesor(){
        System.out.println("Inserta el nombre del profesor/a para la excursion a " + getLocalidad());
        profesores.add(entry.next());
    }

    public void inscribirAsistente(){
        System.out.println("Creando estudiante...");
        System.out.println("Insertar apellidos:");
        String apellido = entry.next();
        System.out.println("Inserta el nombre:");
        String nombre = entry.next();
        System.out.println("Inserta el curso:");
        String curso = entry.next();
        System.out.println("Introduce su edad:");
        int edad = entry.nextInt();

        int temp = listaAsistentes.size();
        listaAsistentes.add(new Estudiante(nombre,apellido,curso,edad));
        if (temp != listaAsistentes.size()){
            System.out.println("Añadido correctamente al estudiante " + nombre + " " + apellido + " del curso " + curso);
        }else {
            System.out.println("El estudiante ya existe en la lista de asistentes a la actividad " + getNombre());
        }
    }

    public double calcularImporteIgreso(){
        return listaAsistentes.size() * this.precio;
    }

    public void verAsistentes(){

        List<Estudiante> sortedList = new ArrayList<>(listaAsistentes.stream().toList());
        sortedList.sort((student1 , student2) -> student1.getApellidos().compareToIgnoreCase(student2.getApellidos()));
        sortedList.sort((student1 , student2) -> student1.getCurso().compareToIgnoreCase(student2.getCurso()));

        int count = 1;

        System.out.println("Lista de inscritos para la actividad " + getNombre());
        System.out.println("====================");
        for (Estudiante line : sortedList){

            System.out.println("[" + count++ + "]. " + line.getCurso() + " - " + line.getApellidos()
            + ", " + getNombre() + " (" + line.getEdad() + " años).");

        }
        System.out.println("====================");
    }


    public void eliminarAsistentesPorEdad(int edad){

        List<Estudiante> lista = listaAsistentes.stream().toList();

        for (Estudiante line : lista){
            if (line.getEdad() < edad){
                listaAsistentes.remove(line);
            }
        }
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getLocalidad(){
        return this.localidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
