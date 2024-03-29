package estructuras;
/*
 * Estructura de un arbol binario de busqueda.
 * Source: github del profesor 
 * @author Gretchell y Marco
 */
import java.io.File;

public class ArbolString {
	 
    private String dato;
    private LinkedList referencia = new LinkedList();
    private ArbolString izquierda;
    private ArbolString derecha;
    public ArbolString raiz;
 
    public ArbolString() {
        this.raiz = null;
        this.dato = "";
        this.referencia  = new LinkedList();
        this.izquierda = null;
        this.derecha = null;
    }
     
    public ArbolString(String dato, File referencia) {
        this.dato = dato;
        this.referencia  = new LinkedList();
        this.referencia.insertFirst(referencia);
        this.izquierda = null;
        this.derecha = null;
    }
 
    public void createTree( String content, File path ) {
       
        if( content != null ) {
            
            content = content.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
            String[] words = content.split( " " );
           
            for( int i = 0; i < words.length; i++ ) {
                this.addNode( words[i], path);
            }
        } 
        
    }
 
     
   
    public void addNode(String dato, File referencia) {
        if (this.dato == null) {
            this.dato = dato;
            this.referencia.insertFirst(referencia);
        } else {
        	if(this.dato.compareTo(dato) == 0) {
        		this.referencia.insertFirst(referencia);
        	}
        	else if (this.dato.compareTo(dato) > 0) {
                if (this.izquierda != null) {
                    this.izquierda.addNode(dato, referencia);
                } else {
                    this.izquierda = new ArbolString(dato, referencia);
                }
 
            } else {
                if (this.derecha != null) {
                    this.derecha.addNode(dato, referencia);
                } else {
                    this.derecha = new ArbolString(dato, referencia);
                }
 
            }
        }
    }
     
    public void traversePreOrder() {
    		System.out.println(this.dato+" , "+this.referencia);
        if (this.izquierda != null) {
            this.izquierda.traversePreOrder();
        }
        if (this.derecha != null) {
            this.derecha.traversePreOrder();
        }
    }
 
    public void traverseInOrder() {
        if (this.izquierda != null) {
            this.izquierda.traverseInOrder();
        }
        System.out.println(this.dato+" , "+this.referencia);
        if (this.derecha != null) {
            this.derecha.traverseInOrder();
        }
    }
 
 
    public void traversePostOrder() {
        if (this.izquierda != null) {
            this.izquierda.traversePostOrder();
        }
        if (this.derecha != null) {
            this.derecha.traversePostOrder();
        }
        System.out.println(this.dato+" , "+this.referencia);
    }
    //public ArbolString nodo = new ArbolString();
    public LinkedList buscar(String llave){
       
       return buscarI(llave);
    
    }
    public  LinkedList buscarI(String str) {
        if(this.dato.equals(str)){
        	System.out.println(referencia + "  encontrada!!!");
            return referencia;
        }else if(str.compareTo(this.dato) < 0){
            return izquierda == null ? null:izquierda.buscarI(str);
        
        }else{
            return derecha == null ? null:derecha.buscarI(str);
        }
        
    }
    
    
     public static void main(String[] args) {
        /**
         * metodo principal
         * 
         * inserta y muestra
         */
        
        ArbolString Arbol = new ArbolString();
        Arbol.createTree("hola soy bb",new File("C:\\Users\\grero\\Desktop\\Hello-1.txt"));
        Arbol.createTree("stella va a la playa",new File("C:\\Users\\grero\\Desktop\\Hello-1.txt"));
        Arbol.createTree("stella es mi waifu",new File("C:\\Users\\grero\\Desktop\\Hello-1.txt"));
        Arbol.traversePreOrder();
        Arbol.buscar("stella");
    }
    
 
}