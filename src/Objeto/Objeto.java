package Objeto;


public class Objeto implements Comparable<Objeto>{
    protected Long id;
    protected String clave;
    protected String nombre;
    protected Long telefono;
    protected Character genero;
    protected Boolean casado;

    @Override
    public int compareTo(Objeto o) {

        if(this.id > o.id)
            return 1;
        else if(this.id < o.id)
            return -1;
        else return 0;
    }

    public Objeto(Long _id, String _clave, String _nombre, Long _telefono, Character _genero, Boolean _casado)
    {
        clave = _clave;
        id = _id;
        nombre = _nombre;
        telefono = _telefono;
        casado = _casado;
        genero = _genero;
    }

    public Long getClave() {
        return id;
    }

    public String getId() {
        return clave;
    }

    public void setId(String id) {
        this.clave = id;
    }

    public void setClave(Long clave) {
        this.id = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Boolean getCasado() {
        return casado;
    }

    public void setCasado(Boolean casado) {
        this.casado = casado;
    }

    @Override
    public String toString(){
        return String.format("%d,%s,%s,%d,%s,%s",id,clave,nombre,telefono,genero,(casado)? "si": "no");
    }


}
